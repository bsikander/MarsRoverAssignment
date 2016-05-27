package com.marsrover;

public class South extends CardinalPoints {
	public South(int offset) {
		super(/* degrees */ 180, offset);
		this.direction = 'S';
		this.oneGridBlock = new Point(0,-1);
	}
}
