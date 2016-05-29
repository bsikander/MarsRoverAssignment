package com.marsrover;

import org.junit.Test;

import com.marsrover.cardinalpoint.East;
import com.marsrover.cardinalpoint.North;
import com.marsrover.cardinalpoint.South;
import com.marsrover.cardinalpoint.West;

import static org.junit.Assert.*;

/**
 * The test cases contained in this class are responsible for verifying one
 * grid block rover movement in normal and corner cases.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class TestRoverMovement {

	@Test
	public void testRoverMoveForwardFrom00NTo01N() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new North()));
		rover.move();
		assertEquals(rover, new Rover(new Plateau(new Point(0,0), new Point(5,5)), 
									  new Point(0,1), 
									  new SimpleCardinalManager(new North())));
	}
	
	@Test
	public void testRoverMoveForwardFrom00ETo10E() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new East()));
		rover.move();
		
		assertEquals(rover, new Rover(new Plateau(new Point(0,0), new Point(5,5)),
									  new Point(1,0), 
									  new SimpleCardinalManager(new East())));
	}
	
	@Test
	public void testRoverMoveForwardFrom00SShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new South()));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05NShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalManager(new North()));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom50EShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(5,0), 
								new SimpleCardinalManager(new East()));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05WShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalManager(new West()));
		
		assertEquals(rover.move() , false);
	}
}
