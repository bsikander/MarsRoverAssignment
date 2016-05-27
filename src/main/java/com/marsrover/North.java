package com.marsrover;

public class North extends CardinalPoints {

	public North(int offset) {
		super(0, offset);
		this.direction = 'N';
		//this.degrees = 0;
		this.oneGridBlock = new Point(0,1);
		//super.offset = offset;
	}
	
//	@Override
//	public int rotate() {
//		 return ((this.degrees + this.offset) % 360);
//	}
}
