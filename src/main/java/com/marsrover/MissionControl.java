package com.marsrover;

import java.util.ArrayList;
import java.util.List;

import com.marsrover.cardinalmanager.CardinalManager;

public class MissionControl {
	private List<Rover> deployedRovers;
	
	public MissionControl() {
		deployedRovers = new ArrayList<>();
	}
	
	public Rover deployRover(Plateau plateau, Point position, CardinalManager cardinalManager) {
		Rover newlyDeployedRover = new Rover(plateau, position, cardinalManager);
		deployedRovers.add(newlyDeployedRover);
		
		return 	newlyDeployedRover;
	}
	
	/**
	 * Last Rover added to the list is the currently active Rover. So, this function
	 * pulls that rover out of the list and sends commands to it.
	 * @param command The list of commands to be sent to the rover
	 * @return True, if the actions were performed successfully false otherwise
	 */
	public boolean sendCommandToCurrentlyActiveRover(String commands) {
		if(deployedRovers.size() == 0) return false;
		
		Rover currentRover = deployedRovers.get(deployedRovers.size() - 1);
		return currentRover.performActions(commands);
	}
}
