package com.marsrover;

public class Rover {
  
	private CardinalPoints direction;
	private Point position;
//	private int xCoordinate;
//	private int yCoordinate;
	
	//public Rover(int xCoordinate, int yCoordinate, CardinalPoints direction)
	public Rover(Point position, CardinalPoints direction)
	{
		this.direction = direction;
		this.position = position;
//		this.xCoordinate = xCoordinate;
//		this.yCoordinate = yCoordinate;
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
			if(this.position.getYCoordinate() + 1 > 5) return false;
			this.position.setYCoordinate(this.position.getYCoordinate() + 1);
		}
		else if(this.getDirection() == 'E') {
			if(this.position.getXCoordinate() + 1 > 5) return false;
			this.position.setXCoordinate(this.position.getXCoordinate() + 1);
			System.out.println("[MOVE] Point Position -> X: " + this.position.getXCoordinate() +  "Y: " + this.position.getYCoordinate());;
		}
		else if (this.getDirection() == 'S') {
			if(this.position.getYCoordinate() - 1 < 0) return false;
			this.position.setYCoordinate(this.position.getYCoordinate() - 1);
		}
		else if (this.getDirection() == 'W') {
			if(this.position.getXCoordinate() - 1 < 0) return false;
			this.position.setXCoordinate(this.position.getXCoordinate() - 1);
		}
		return true;
	}
	
	public char getDirection() {
		return this.direction.getDirection(); 
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Rover)) return false;
		
		Rover otherRover = (Rover)other;
		if (this.position.equals(otherRover.position) &&
			this.direction.getDirection() == otherRover.getDirection())
			return true;
		
		return false;
	}
}
