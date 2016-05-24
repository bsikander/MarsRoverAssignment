package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rover {
  
	//char direction;
	RoverDirection direction;
	
	public Rover(RoverDirection direction)
	{
		this.direction = direction;
	}
	
	public boolean turnRight()
	{
		//RoverDirection d = new SimpleRoverDirection(this.direction);
		return this.direction.spinRight();
//		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
//		char key = this.getKeyAgainstValue((currentDirectionInDegrees + 90) % 360);
//		this.direction = key;
//		System.out.println("[Turn Right] Current Key -> " + key + " Degrees -> " + (currentDirectionInDegrees + 90));
//		return true;
	}
	
	public boolean turnLeft()
	{
		//RoverDirection d = new SimpleRoverDirection(this.direction);
		return this.direction.spinLeft();
//		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
//		
//		// If after turning left the degrees go in negative then just add 360 to get the correct cardinal point
//		if(currentDirectionInDegrees - 90 < 0)
//			currentDirectionInDegrees = (currentDirectionInDegrees -90) + 360;
//		else
//			currentDirectionInDegrees -=90;
//		
//		char key = this.getKeyAgainstValue(currentDirectionInDegrees % 360);
//		this.direction = key;
//		System.out.println("[Turn Left] Current Key -> " + key + " Degrees -> " + (currentDirectionInDegrees));
//		return true;
	}
	
	public char getDirection()
	{
		return this.direction.getDirection(); 
	}
	
//	private char getKeyAgainstValue(int degrees)
//	{
//		for(Entry<Character, Integer> entry: cardinalPoints.entrySet())
//		{
//			if(entry.getValue().equals(degrees))
//			{
//				return entry.getKey();
//			}
//		}
//		return ' ';
//	}
}
