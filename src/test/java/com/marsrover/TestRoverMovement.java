package com.marsrover;

import org.junit.Test;
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
								new SimpleCardinalPoints('N'));
		rover.move();
		assertEquals(rover, new Rover(new Plateau(new Point(0,0), new Point(5,5)), 
									  new Point(0,1), 
									  new SimpleCardinalPoints('N')));
	}
	
	@Test
	public void testRoverMoveForwardFrom00ETo10E() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalPoints('E'));
		rover.move();
		
		assertEquals(rover, new Rover(new Plateau(new Point(0,0), new Point(5,5)),
									  new Point(1,0), 
									  new SimpleCardinalPoints('E')));
	}
	
	@Test
	public void testRoverMoveForwardFrom00SShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalPoints('S'));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05NShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalPoints('N'));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom50EShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(5,0), 
								new SimpleCardinalPoints('E'));
		
		assertEquals(rover.move() , false);
	}
	
	@Test
	public void testRoverMoveForwardFrom05WShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
								new Point(0,5), 
								new SimpleCardinalPoints('W'));
		
		assertEquals(rover.move() , false);
	}
}
