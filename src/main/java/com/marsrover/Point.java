package com.marsrover;

public class Point {
	private int xCoordinate;
	private int yCoordinate;
	
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public int getXCoordinate() {
		return this.xCoordinate;
	}
	
	public void setXCoordinate(int newXCoordinate) {
		this.xCoordinate = newXCoordinate;
	}
	
	public void setYCoordinate(int newYCoordinate) {
		this.yCoordinate = newYCoordinate;
	}
	
	public int getYCoordinate() {
		return this.yCoordinate;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Point)) return false;
		
		Point otherPoint = (Point)other;
		if (this.xCoordinate == otherPoint.xCoordinate && this.yCoordinate == otherPoint.yCoordinate)
			return true;
			
		return false;
	}
}
