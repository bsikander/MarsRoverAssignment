package com.marsrover;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRover {

	@Test
	public void testRoverRightTurnEastToSouth()
	{
	  Rover rover = new Rover(0, 0, new SimpleCardinalPoints('E'));
	  rover.turnRight();
	  assertEquals('S', rover.getDirection());
	}
	
	@Test
	public void testRoverRightTurnWestToNorth()
	{
	  Rover rover = new Rover(0, 0, new SimpleCardinalPoints('W'));
	  rover.turnRight();
	  assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnSouthToEast()
	{
	  Rover rover = new Rover(0, 0, new SimpleCardinalPoints('S'));
	  rover.turnLeft();
	  assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnNorthToWest()
	{
	  Rover rover = new Rover(0, 0, new SimpleCardinalPoints('N'));
	  rover.turnLeft();
	  assertEquals('W', rover.getDirection());
	}
	
	@Test
	public void testRoverMoveForwardFrom00NTo01N()
	{
		Rover rover = new Rover(0,0, new SimpleCardinalPoints('N'));
		rover.move();
		assertEquals(rover, new Rover(0, 1, new SimpleCardinalPoints('N')));
	}
	
	@Test
	public void testRoverMoveForwardFrom00ETo01E()
	{
		Rover rover = new Rover(0,0, new SimpleCardinalPoints('E'));
		rover.move();
		assertEquals(rover, new Rover(1, 0, new SimpleCardinalPoints('E')));
	}
	
	@Test
	public void testRoverMoveForwardFrom00SShouldFail()
	{
		Rover rover = new Rover(0,0, new SimpleCardinalPoints('S'));
		assertEquals(rover.move() , false);
	}
}
