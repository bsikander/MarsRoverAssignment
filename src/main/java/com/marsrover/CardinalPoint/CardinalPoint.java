package com.marsrover.CardinalPoint;

import com.marsrover.Point;

public abstract class CardinalPoint {
	protected char direction;
	protected int degrees;
	protected Point oneGridBlock;
	
	public CardinalPoint(char direction, int degrees, Point oneGridBlock) {
		this.direction = direction;
		this.degrees = degrees;
		this.oneGridBlock = oneGridBlock;
	}
	
	public int rotate(int offset) {
		//return ((this.degrees + this.offset) % 360);
		int newDegrees = ((this.degrees + offset) % 360);
		System.out.println("CARDINAL POINT: degree -> " + this.degrees + " offset -> " + offset + " newDegrees -> " + newDegrees);
		return newDegrees;
	}
	
	public Point getOneGridBlock() {
		return this.oneGridBlock;
	}
	
	public boolean compareDegrees(int degree) {
		return (this.degrees == degree);
	}
	
	public boolean isValid() {
		return this.direction != ' ';
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof CardinalPoint)) return false;
		
		CardinalPoint otherPoint = (CardinalPoint)other;
		if (this.direction == otherPoint.direction && this.degrees == otherPoint.degrees)
			return true;
			
		return false;
	}
	
	@Override
	public String toString() {
        return "(" + this.direction + ", " + this.degrees + ")";
    }
	
	//private int offset;
	
//	public CardinalPoints(char direction, int offset) {
//		this.offset = offset;
//	}
	
//	public void rotate() {
//		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
//		char direction = this.getCardinalPointAgainstDegrees( 
//																(currentDirectionInDegrees + offset) % 360 
//															);
//		this.direction = direction;
//	}
	
}
