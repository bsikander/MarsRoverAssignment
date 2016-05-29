package com.marsrover;

import org.junit.Test;

import static org.junit.Assert.*;

import com.marsrover.cardinaldirection.*;
import com.marsrover.cardinalmanager.SimpleCardinalManager;

public class TestRoverSquadNavigation {

	@Test
	public void testRoverNavigation() {
		MissionControl missionControl = new MissionControl();
		Rover deployedRover = missionControl.deployRover(new Plateau(new Point(5,5)), 
														 new Point(1,2), 
														 new SimpleCardinalManager(new North()));
		
		missionControl.sendCommandToCurrentlyActiveRover("LMLMLMLMM");
		
		assertEquals(deployedRover, new Rover(new Plateau(new Point(5,5)), 
				  							  new Point(1,3), 
				  							  new SimpleCardinalManager(new North())));
		
		deployedRover = missionControl.deployRover(new Plateau(new Point(5,5)), 
								   new Point(3,3), 
								   new SimpleCardinalManager(new East()));
		
		missionControl.sendCommandToCurrentlyActiveRover("MMRMMRMRRM");
		
		assertEquals(deployedRover, new Rover(new Plateau(new Point(5,5)), 
				  					new Point(5,1), 
				  					new SimpleCardinalManager(new East())));
		
	}

}
