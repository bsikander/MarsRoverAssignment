package com.marsrover;

/**
 * This class presents the mutable reusable implementation of 2d Point.  
 * It also implements the Comparable interface for comparing two points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
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
	
	/**
	 * This function adds a Point to the current Point instance. This function
	 * helps other classes in operating on a higher layer of abstraction.
	 * 
	 * @param newPoint The Point which needs to be added.
	 */
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
	 * Compares two points to figure out which point lie higher than the other.
	 * 
	 * @return +1 if one Point is greater than other
	 * 		   -1 if one Point is less than the other
	 *          0 if both points are same
	 */
	@Override
	public int compareTo(Point that) {
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
