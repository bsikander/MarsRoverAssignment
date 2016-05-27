package com.marsrover;

public class Point implements Comparable<Point> {
	private int xCoordinate;
	private int yCoordinate;
	
	public Point(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public Point(Point point) {
		this.xCoordinate = point.xCoordinate;
		this.yCoordinate = point.yCoordinate;
	}
	
	public void add(Point newPoint) {
		
		this.xCoordinate += newPoint.xCoordinate;
		this.yCoordinate += newPoint.yCoordinate;
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

	/**
	 * Compares two points to figure out where both point lie relative to each other.
	 * @return The current "this" Point should be greater than "that" Point. If yes, then return +1.
	 * If no, then return -1 and if both points are equal then return 0.
	 */
	@Override
	public int compareTo(Point that) {
//		System.out.println("[CompareTo] This -> " + this.toString() + " That ->" + that.toString());
		if(this.xCoordinate == that.xCoordinate && this.yCoordinate == that.yCoordinate) return 0;
		if(this.xCoordinate > that.xCoordinate  && this.yCoordinate > that.yCoordinate) return +1;
		if(this.xCoordinate > that.xCoordinate  && this.yCoordinate == that.yCoordinate) return +1;
		if(this.xCoordinate == that.xCoordinate && this.yCoordinate > that.yCoordinate) return +1;
		
		return -1;
	}
	
	@Override
	public String toString() {
        return "(" + this.xCoordinate + ", " + this.yCoordinate + ")";
    }
}
