package com.marsrover;

import org.junit.Test;
import static org.junit.Assert.*;
import com.marsrover.cardinaldirection.*;
import com.marsrover.cardinalmanager.SimpleCardinalManager;

/**
 * This class is responsible for verifying navigation of rover squad. 
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class TestRoverSquadNavigation {

	@Test
	public void testRoverSquadNavigation() {
		MissionControl missionControl = new MissionControl();
		Plateau plateau = new Plateau(new Point(5,5));
		
		// Start - Rover 1
		// 1 2 N
        // LMLMLMLMM
		Rover deployedRover = missionControl.deployRover(plateau, 
														 new Point(1,2), 
														 new SimpleCardinalManager(new North()));
		
		missionControl.sendCommandToCurrentlyActiveRover("LMLMLMLMM");
		
		assertEquals(deployedRover, new Rover(new Plateau(new Point(5,5)), 
				  							  new Point(1,3), 
				  							  new SimpleCardinalManager(new North())));
		// End - Rover 1
		
		// Start - Rover 2
		// 3 3 E
		// MMRMMRMRRM
		deployedRover = missionControl.deployRover(plateau, 
								   new Point(3,3), 
								   new SimpleCardinalManager(new East()));
		
		missionControl.sendCommandToCurrentlyActiveRover("MMRMMRMRRM");
		
		assertEquals(deployedRover, new Rover(new Plateau(new Point(5,5)), 
				  					new Point(5,1), 
				  					new SimpleCardinalManager(new East())));
		// End - Rover 2
	}

}
