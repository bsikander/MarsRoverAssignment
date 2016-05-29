package com.marsrover.commands;

import com.marsrover.cardinalmanager.CardinalManager;

public class TurnRight implements Command {

	private CardinalManager cardinalManager;
	
	public TurnRight(CardinalManager cardinalManager) {
		this.cardinalManager = cardinalManager;
	}
	
	@Override
	public boolean execute() {
		return this.cardinalManager.rotateRight();
	}

}
