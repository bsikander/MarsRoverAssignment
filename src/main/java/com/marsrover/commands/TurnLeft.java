package com.marsrover.commands;

import com.marsrover.cardinalmanager.CardinalManager;

public class TurnLeft implements Command {

	private CardinalManager cardinalManager;
	
	public TurnLeft(CardinalManager cardinalManager) {
		this.cardinalManager = cardinalManager;
	}
	
	@Override
	public boolean execute() {
		return this.cardinalManager.rotateLeft();
	}
	
}
