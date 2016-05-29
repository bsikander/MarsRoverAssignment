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
public class TestSingleRoverNavigationFromAToB {

	@Test
	public void testRoverMovementFrom12NTo13NUsingLMLMLMLMM() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(1,2), 
								new SimpleCardinalManager(new North()));
		
		rover.performActions("LMLMLMLMM");
		//LM LM LM LM M
//		rover.turnLeft(); 
//		rover.move();
//		
//		rover.turnLeft();
//		rover.move();
//		
//		rover.turnLeft();
//		rover.move();
//		
//		rover.turnLeft();
//		rover.move();
//		
//		rover.move();
		
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
		//MM RM MR MR RM
//		rover.move();
//		rover.move();
//		
//		rover.turnRight();
//		rover.move();
//		
//		rover.move();
//		rover.turnRight();
//		
//		rover.move();
//		rover.turnRight();
//		
//		rover.turnRight();
//		rover.move();
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
				  new Point(5,1), 
				  new SimpleCardinalManager(new East())));
	}
	
	@Test
	public void testRoverMovementFrom33ETo53EUsingMMRMMRMRRMOnPlateauOfSize44ShouldFail() {
		Rover rover = new Rover(new Plateau(new Point(4,4)),
				new Point(3,3), 
				new SimpleCardinalManager(new East()));
		
		//rover.move();
		// This move tries to move the rover to (5,3) whereas the plateau is only of
		// (4,4). The move command is illegal which results in a failure.
		boolean result = rover.performActions("MM");
		
		
		//boolean wrongMoveResult = rover.move();
		assertEquals(false, result);
	}

	@Test
	public void testRoverMovementFrom00NTo55NUsingMRMLMRMLMRMLMRMLMRMLMR() {
		Rover rover = new Rover(new Plateau(new Point(5,5)),
								new Point(0,0), 
								new SimpleCardinalManager(new North()));
		
		rover.performActions("MRMLMRMLMRMLMRMLMRMLMR");
		
		//MR ML MR ML MR ML MR ML MR ML MR
//		rover.move();		// Reached (0,1)
//		rover.turnRight(); 	// Direction E
//		
//		rover.move();		// Reached (1,1)
//		rover.turnLeft(); 	// Direction N
//		
//		rover.move();		// Reached (1,2)
//		rover.turnRight(); 	// Direction E
//		
//		rover.move();		// Reached (2,2)
//		rover.turnLeft(); 	// Direction N
//		
//		rover.move();		// Reached (2,3)
//		rover.turnRight(); 	// Direction E
//		
//		rover.move();		// Reached (3,3)
//		rover.turnLeft(); 	// Direction N
//		
//		rover.move();		// Reached (3,4)
//		rover.turnRight(); 	// Direction E
//		
//		rover.move();		// Reached (4,4)
//		rover.turnLeft(); 	// Direction N
//		
//		rover.move();		// Reached (4,5)
//		rover.turnRight(); 	// Direction E
//		
//		rover.move();		// Reached (5,5)
//		rover.turnLeft(); 	// Direction N
		
		assertEquals(rover, new Rover(new Plateau(new Point(5,5)), 
				  new Point(5,5), 
				  new SimpleCardinalManager(new North())));
	}
}
