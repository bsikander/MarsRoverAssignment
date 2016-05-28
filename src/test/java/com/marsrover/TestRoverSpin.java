package com.marsrover;

import org.junit.Test;

import com.marsrover.CardinalPoint.East;
import com.marsrover.CardinalPoint.North;
import com.marsrover.CardinalPoint.South;
import com.marsrover.CardinalPoint.West;

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
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new East()));
	  rover.turnRight();
	  rover.getDirection().toString();
	  assertEquals(new South(), rover.getDirection());
	}
	
	@Test
	public void testRoverRightTurnFromWestToNorth() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)), 
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new West()));
	  rover.turnRight();
	  assertEquals(new North(), rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromSouthToEast() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new South()));
	  rover.turnLeft();
	  assertEquals(new East(), rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromNorthToWest() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager(new North()));
	  rover.turnLeft();
	  assertEquals(new West(), rover.getDirection());
	}
}
