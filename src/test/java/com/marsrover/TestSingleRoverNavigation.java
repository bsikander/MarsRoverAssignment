package com.marsrover;

import org.junit.Test;

import com.marsrover.cardinaldirection.East;
import com.marsrover.cardinaldirection.North;
import com.marsrover.cardinalmanager.SimpleCardinalManager;

import static org.junit.Assert.*;

/**
 * This class is responsible for verifying rover navigation based on
 * a series on rotate and move commands. 
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class TestSingleRoverNavigation {

	@Test
	public void testRoverMovementFrom12NTo13NUsingLMLMLMLMM() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(1,2), 
								new SimpleCardinalManager(new North()));
		
		rover.performActions("LMLMLMLMM");
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
				  new Point(1,3), 
				  new SimpleCardinalManager(new North())));
	}
	
	@Test
	public void testRoverMovementFrom33ETo51EUsingMMRMMRMRRM() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(3,3), 
								new SimpleCardinalManager(new East()));
		
		rover.performActions("MMRMMRMRRM");
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
				  new Point(5,1), 
				  new SimpleCardinalManager(new East())));
	}
	
	@Test
	public void testRoverMovementFrom33ETo53EUsingMMRMMRMRRMOnPlateauOfSize44ShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(4,4)),
				new Point(3,3), 
				new SimpleCardinalManager(new East()));
		
		// This move tries to move the rover to (5,3) whereas the plateau is only of
		// (4,4). The move command is illegal which results in a failure.
		boolean result = rover.performActions("MM");
		
		assertEquals(false, result);
	}

	@Test
	public void testRoverMovementFrom00NTo55NUsingMRMLMRMLMRMLMRMLMRMLMR() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new North()));
		
		rover.performActions("MRMLMRMLMRMLMRMLMRMLMR");
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
				  new Point(5,5), 
				  new SimpleCardinalManager(new North())));
	}
}
