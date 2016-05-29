package com.marsrover;

/**
 * This class presents the mutable reusable implementation of 2d Point.  
 * It also implements the Comparable interface for comparing two points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
	public Point(int xCoordinate, int yCoordinate) {
		this.x = xCoordinate;
		this.y = yCoordinate;
	}
	
	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
	}
	
	/**
	 * This function adds a Point to the current Point instance. This function
	 * helps other classes in operating on a higher layer of abstraction.
	 * 
	 * @param newPoint The Point which needs to be added.
	 */
	public Point add(Point newPoint) {
		return new Point(
							this.x + newPoint.x, 
							this.y + newPoint.y
						);
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Point)) return false;
		
		Point otherPoint = (Point)other;
		if (this.x == otherPoint.x && this.y == otherPoint.y)
			return true;
			
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
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
		if(that == null) return -1;
		if(this.x == that.x && this.y == that.y) return 0;
		if(this.x > that.x  && this.y > that.y) return +1;
		if(this.x > that.x  && this.y == that.y) return +1;
		if(this.x == that.x && this.y > that.y) return +1;
		
		return -1;
	}
	
	@Override
	public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
