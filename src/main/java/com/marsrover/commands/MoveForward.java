package com.marsrover.commands;

import com.marsrover.Point;
import com.marsrover.Rover;

public class MoveForward implements Command {

	private Rover rover;
	
	public MoveForward(Rover rover) {
		this.rover = rover;
	}
	
	@Override
	public boolean execute() {
		Point unitPointInCurrentDirection = this.rover.getDirection().getUnitBlock();
		
		// Create a temporary point object because we first want to verify if the
		// rover is in plateau or not. Once we have verified and it is in plateau,
		// we will assign the new temporary position to the current position of rover.
		Point newProposedRoverPosition = this.rover.getPosition().add(unitPointInCurrentDirection);
		
		boolean isRoverInPlateau = this.rover.getPlateau().contains(newProposedRoverPosition);
		
		if(isRoverInPlateau) {
			this.rover.setPosition(newProposedRoverPosition);
			return true;
		}
		return false;
	}

}
