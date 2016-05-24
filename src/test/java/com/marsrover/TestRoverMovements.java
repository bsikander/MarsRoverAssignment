package com.marsrover;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoverMovements {

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
	
	@Test
	public void testRoverMoveForwardFrom05NShouldFail()
	{
		Rover rover = new Rover(0,5, new SimpleCardinalPoints('N'));
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom50EShouldFail()
	{
		Rover rover = new Rover(5,0, new SimpleCardinalPoints('E'));
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05WShouldFail()
	{
		Rover rover = new Rover(0,5, new SimpleCardinalPoints('W'));
		assertEquals(rover.move() , false);
	}

}
