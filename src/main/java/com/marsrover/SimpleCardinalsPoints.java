package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleCardinalsPoints implements CardinalPoints {
	private char direction;
	private static final Map<Character, Integer> cardinalPoints = new HashMap<Character, Integer>();
	
	static
	{
		cardinalPoints.put('N', 0);
		cardinalPoints.put('E', 90);
		cardinalPoints.put('S', 180);
		cardinalPoints.put('W', 270);
	}
	
	public SimpleCardinalsPoints(char direction) {
		this.direction = direction;
	}
	
	@Override
	public char getDirection()
	{
		return this.direction;
	}
	
	@Override
	public boolean spinLeft() {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		
		// If after turning left the degrees go in negative then just add 360 to get the correct cardinal point
		if(currentDirectionInDegrees - 90 < 0)
			currentDirectionInDegrees = (currentDirectionInDegrees -90) + 360;
		else
			currentDirectionInDegrees -= 90;
		
		char direction = this.getCardinalPointAgainstDegrees(currentDirectionInDegrees % 360);
		
		if(direction != ' ') {
			this.direction = direction;
			System.out.println("[Turn Left] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees));
			return true;
		}
		return false;
	}

	@Override
	public boolean spinRight() {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char direction = this.getCardinalPointAgainstDegrees((currentDirectionInDegrees + 90) % 360);
		
		if(direction != ' ') {
			this.direction = direction;
			System.out.println("[Turn Right] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees + 90));
			return true;
		}
		return false;
	}
	
	private char getCardinalPointAgainstDegrees(int degrees)
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
