package com.marsrover;

import org.junit.Test;

import com.marsrover.cardinaldirection.East;
import com.marsrover.cardinaldirection.North;
import com.marsrover.cardinaldirection.South;
import com.marsrover.cardinaldirection.West;
import com.marsrover.cardinalmanager.SimpleCardinalManager;

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
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new North()));
		//rover.move();
		rover.performActions("M");
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
									  new Point(0,1), 
									  new SimpleCardinalManager(new North())));
	}
	
	@Test
	public void testRoverMoveForwardFrom00ETo10E() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new East()));
		//rover.move();
		rover.performActions("M");
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)),
									  new Point(1,0), 
									  new SimpleCardinalManager(new East())));
	}
	
	@Test
	public void testRoverMoveForwardFrom00SShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new South()));
		
		//assertEquals(rover.move() , false);
		assertEquals(rover.performActions("M") , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05NShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalManager(new North()));
		
		assertEquals(rover.performActions("M") , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom50EShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(5,0), 
								new SimpleCardinalManager(new East()));
		
		assertEquals(rover.performActions("M") , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05WShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalManager(new West()));
		
		assertEquals(rover.performActions("M") , false);
	}
}
