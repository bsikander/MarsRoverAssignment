package com.marsrover;

public abstract class CardinalPoints {
	protected char direction;
	protected int degrees;
	protected Point oneGridBlock;
	protected int offset;
	
	public CardinalPoints(int degrees, int offset) {
		this.degrees = degrees;
		this.offset = offset;
	}
	
	public int rotate() {
		return ((this.degrees + this.offset) % 360);
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
