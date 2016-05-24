package com.marsrover;

public class Rover {
  
	private CardinalPoints direction;
	private int xCoordinate;
	private int yCoordinate;
	
	public Rover(int xCoordinate, int yCoordinate, CardinalPoints direction)
	{
		this.direction = direction;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public boolean turnRight()
	{
		return this.direction.spinRight();
	}
	
	public boolean turnLeft()
	{
		return this.direction.spinLeft();
	}
	
	public boolean move()
	{
		if(this.getDirection() == 'N') {
			if(this.yCoordinate + 1 > 5) return false;
			this.yCoordinate += 1;
		}
		else if(this.getDirection() == 'E') {
			if(this.xCoordinate + 1 > 5) return false;
			this.xCoordinate += 1;
		}
		else if (this.getDirection() == 'S') {
			if(this.yCoordinate - 1 < 0) return false;
			this.yCoordinate -= 1;
		}
		else if (this.getDirection() == 'W') {
			if(this.xCoordinate - 1 < 0) return false;
			this.xCoordinate -= 1;
		}
		
		return true;
	}
	
	public char getDirection()
	{
		return this.direction.getDirection(); 
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Rover)) return false;
		
		Rover otherRover = (Rover)other;
		if (this.xCoordinate == otherRover.xCoordinate &&
			this.yCoordinate == otherRover.yCoordinate &&
			this.direction.getDirection() == otherRover.getDirection())
			return true;
		
		return false;
	}
}
