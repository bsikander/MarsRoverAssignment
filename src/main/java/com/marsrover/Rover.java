package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rover {
  
	char direction;
	private static final Map<Character, Integer> cardinalPoints = new HashMap<Character, Integer>();
	
	static
	{
		cardinalPoints.put('N', 0);
		cardinalPoints.put('E', 90);
		cardinalPoints.put('S', 180);
		cardinalPoints.put('W', 270);
	}
	
	public Rover(char direction)
	{
		this.direction = direction;
	}
	
	public boolean turnRight()
	{
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char key = this.getKeyAgainstValue((currentDirectionInDegrees + 90) % 360);
		this.direction = key;
		System.out.println("[Turn Right] Current Key -> " + key + " Degrees -> " + (currentDirectionInDegrees + 90));
		return true;
	}
	
	public boolean turnLeft()
	{
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		if(currentDirectionInDegrees - 90 < 0)
			currentDirectionInDegrees = (currentDirectionInDegrees -90) + 360;
		else
			currentDirectionInDegrees -=90;
		
		char key = this.getKeyAgainstValue(currentDirectionInDegrees % 360);
		this.direction = key;
		System.out.println("[Turn Left] Current Key -> " + key + " Degrees -> " + (currentDirectionInDegrees));
		return true;
	}
	
	public char getDirection()
	{
		return this.direction; 
	}
	
	private char getKeyAgainstValue(int degrees)
	{
		for(Entry<Character, Integer> entry: cardinalPoints.entrySet())
		{
			if(entry.getValue().equals(degrees))
			{
				return entry.getKey();
			}
		}
		return ' ';
	}
}
