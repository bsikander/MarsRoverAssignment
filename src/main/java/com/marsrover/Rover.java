package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Rover {
  
	CardinalPoints direction;
	
	public Rover(CardinalPoints direction)
	{
		this.direction = direction;
	}
	
	public boolean turnRight()
	{
		return this.direction.spinRight();
	}
	
	public boolean turnLeft()
	{
		return this.direction.spinLeft();
	}
	
	public char getDirection()
	{
		return this.direction.getDirection(); 
	}
}
