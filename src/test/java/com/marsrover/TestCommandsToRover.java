package com.marsrover;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCommandsToRover {

	@Test
	public void test() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
				new Point(1,2), 
				new SimpleCardinalPoints('N'));
		//LM LM LM LM M
		rover.turnLeft(); 
		rover.move();
		
		rover.turnLeft();
		rover.move();
		
		rover.turnLeft();
		rover.move();
		
		rover.turnLeft();
		rover.move();
		
		rover.move();
		
		assertEquals(rover, new Rover(new Plateau(new Point(0,0), new Point(5,5)), 
				  new Point(1,3), 
				  new SimpleCardinalPoints('N')));
	}

}
