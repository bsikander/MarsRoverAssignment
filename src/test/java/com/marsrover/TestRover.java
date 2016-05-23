package com.marsrover;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRover {

	@Test
	public void testRover90DegreeSpinRightWhenRIsPressed()
	{
	  Rover rover = new Rover('E');
	  rover.turnRight();
	  assertEquals('E', rover.getDirection());
	}

}
