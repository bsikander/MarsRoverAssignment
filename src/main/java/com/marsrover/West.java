package com.marsrover;

public class West extends CardinalPoints {
	public West(int offset) {
		super(/* degrees */ 270, offset);
		this.direction = 'W';
		this.oneGridBlock = new Point(-1,0);
	}
}