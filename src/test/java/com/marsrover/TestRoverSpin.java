package com.marsrover;

import org.junit.Test;

import com.marsrover.cardinaldirection.East;
import com.marsrover.cardinaldirection.North;
import com.marsrover.cardinaldirection.South;
import com.marsrover.cardinaldirection.West;
import com.marsrover.cardinalmanager.SimpleCardinalManager;

import static org.junit.Assert.*;

/**
 * The testcases in this class are responsible for verifying the rotation of 
 * rover in normal and corner cases.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class TestRoverSpin {

	@Test
	public void testRoverRightTurnFromEastToSouth() {
	  Rover rover = new Rover(new Plateau(new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new East()));
	  //rover.turnRight();
	  rover.performActions("R");
	  
	  assertEquals(new South(), rover.getDirection());
	}
	
	@Test
	public void testRoverRightTurnFromWestToNorth() {
	  Rover rover = new Rover(new Plateau(new Point(5,5)), 
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new West()));
	  //rover.turnRight();
	  rover.performActions("R");
	  assertEquals(new North(), rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromSouthToEast() {
	  Rover rover = new Rover(new Plateau(new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new South()));
	  //rover.turnLeft();
	  rover.performActions("L");
	  assertEquals(new East(), rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromNorthToWest() {
	  Rover rover = new Rover(new Plateau(new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new North()));
	  //rover.turnLeft();
	  rover.performActions("L");
	  assertEquals(new West(), rover.getDirection());
	}
}
