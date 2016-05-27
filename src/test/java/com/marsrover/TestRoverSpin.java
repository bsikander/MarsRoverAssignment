package com.marsrover;

import org.junit.Test;
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
			  				  new SimpleCardinalManager('E'));
	  rover.turnRight();
	  assertEquals('S', rover.getDirection());
	}
	
	@Test
	public void testRoverRightTurnFromWestToNorth() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)), 
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager('W'));
	  rover.turnRight();
	  assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromSouthToEast() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager('S'));
	  rover.turnLeft();
	  assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void testRoverLeftTurnFromNorthToWest() {
	  Rover rover = new Rover(new Plateau(new Point(0,0), new Point(5,5)),
			  				  new Point(0,0), 
			  				  new SimpleCardinalManager('N'));
	  rover.turnLeft();
	  assertEquals('W', rover.getDirection());
	}
}
