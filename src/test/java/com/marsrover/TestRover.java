package com.marsrover;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestRover {

	@Test
	public void testRoverRightTurnEastToSouth()
	{
	  Rover rover = new Rover(new SimpleCardinalsPoints('E'));
	  rover.turnRight();
	  assertEquals('S', rover.getDirection()); 
	}
	
	@Test
	public void testRoverRightTurnWestToNorth()
	{
	  Rover rover = new Rover(new SimpleCardinalsPoints('W'));
	  rover.turnRight();
	  assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnSouthToEast()
	{
	  Rover rover = new Rover(new SimpleCardinalsPoints('S'));
	  rover.turnLeft();
	  assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnNorthToWest()
	{
	  Rover rover = new Rover(new SimpleCardinalsPoints('N'));
	  rover.turnLeft();
	  assertEquals('W', rover.getDirection());
	}

}
