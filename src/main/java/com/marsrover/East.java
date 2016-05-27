package com.marsrover;

public class East extends CardinalPoints {
	public East(int offset) {
		super(/* degrees */ 90, offset);
		this.direction = 'E';
		this.oneGridBlock = new Point(1,0);
	}
}
