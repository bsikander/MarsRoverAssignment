package com.marsrover.cardinaldirection;

import com.marsrover.Point;

public abstract class CardinalDirection {
	protected char directionSymbol;
	protected int degrees;
	protected Point unitBlock;
	
	public CardinalDirection(char directionSymbol, int degrees, Point unitBlock) {
		this.directionSymbol = directionSymbol;
		this.degrees = degrees;
		this.unitBlock = unitBlock;
	}
	
	public int rotate(int offset) {
		return ((this.degrees + offset) % 360);
	}
	
	public Point getUnitBlock() {
		return this.unitBlock;
	}
	
	public boolean compareDegrees(int degree) {
		return (this.degrees == degree);
	}
	
	public boolean isValid() {
		return this.directionSymbol != ' ';
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof CardinalDirection)) return false;
		
		CardinalDirection otherPoint = (CardinalDirection)other;
		if (this.directionSymbol == otherPoint.directionSymbol && this.degrees == otherPoint.degrees)
			return true;
			
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + degrees;
		result = prime * result + directionSymbol;
		
		return result;
	}
	
	@Override
	public String toString() {
        return "(" + this.directionSymbol + ", " + this.degrees + ")";
    }		
}
