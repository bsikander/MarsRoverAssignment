package com.marsrover;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRoverSpin {

	@Test
	public void testRoverRightTurnFromEastToSouth()
	{
	  Rover rover = new Rover(new Point(0,0), new SimpleCardinalPoints('E'));
	  rover.turnRight();
	  assertEquals('S', rover.getDirection());
	}
	
	@Test
	public void testRoverRightTurnFromWestToNorth()
	{
	  Rover rover = new Rover(new Point(0,0), new SimpleCardinalPoints('W'));
	  rover.turnRight();
	  assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromSouthToEast()
	{
	  Rover rover = new Rover(new Point(0,0), new SimpleCardinalPoints('S'));
	  rover.turnLeft();
	  assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromNorthToWest()
	{
	  Rover rover = new Rover(new Point(0,0), new SimpleCardinalPoints('N'));
	  rover.turnLeft();
	  assertEquals('W', rover.getDirection());
	}
}
