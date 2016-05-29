package com.marsrover;

import java.util.HashMap;
import java.util.Map;

import com.marsrover.cardinaldirection.CardinalDirection;
import com.marsrover.cardinalmanager.CardinalManager;
import com.marsrover.commands.Command;
import com.marsrover.commands.MoveForward;
import com.marsrover.commands.TurnLeft;
import com.marsrover.commands.TurnRight;

/**
 * This class represents a Rover. Instead of directly
 * manipulating the cardinal points, this class uses an abstraction on top to avoid
 * change (e.g. this program can be extended to use intermediate directions N,NE,E,...).
 * This class also uses strategy pattern to handle commands passed by MissionControl class.  
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class Rover {
  
	private CardinalManager cardinalManager;
	private Point position;
	private Plateau plateau;
	private Map<Character, Command> roverCommands;	
	
	public Rover(Plateau plateau, Point position, CardinalManager direction)
	{
		this.cardinalManager = direction;
		this.position = position;
		this.plateau = plateau;
		
		roverCommands = new HashMap<>();
		roverCommands.put('L', new TurnLeft(this.cardinalManager));
		roverCommands.put('R', new TurnRight(this.cardinalManager));
		roverCommands.put('M', new MoveForward(this));
	}
	
	public boolean performActions(String actions) {
		
		for(int i = 0; i < actions.length(); i++) {
			Command roverActionToPerform = roverCommands.get(actions.charAt(i));
			boolean isActionSuccessful = roverActionToPerform.execute();
			
			if(isActionSuccessful == false)
				return false;
		}
		return true;
	}
	
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	public CardinalDirection getDirection() {
		return this.cardinalManager.getCardinalDirection(); 
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(Point newPosition) {
		this.position = newPosition;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Rover)) return false;
		
		Rover otherRover = (Rover)other;
		if (this.position.equals(otherRover.position) &&
			this.cardinalManager.getCardinalDirection().equals(otherRover.getDirection()))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardinalManager == null) ? 0 : cardinalManager.getCardinalDirection().hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}
	
}
