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
 * This class represents a Rover and all of its possible actions. Instead of directly
 * manipulating the cardinal points, this class uses an abstraction on top to avoid
 * change (e.g. this program can be extended to use intermediate directions N,NE,E,...).  
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class Rover {
  
	private CardinalManager cardinalManager;
	private Point position;
	private Plateau plateau;
	private Map<Character, Command> commandMap;	
	
	public Rover(Plateau plateau, Point position, CardinalManager direction)
	{
		this.cardinalManager = direction;
		this.position = position;
		this.plateau = plateau;
		
		commandMap = new HashMap<>();
		commandMap.put('L', new TurnLeft(this.cardinalManager));
		commandMap.put('R', new TurnRight(this.cardinalManager));
		commandMap.put('M', new MoveForward(this));
	}
	
	public boolean performActions(String commands) {
		
		for(int i = 0; i < commands.length(); i++) {
			Command commandToExecute = commandMap.get(commands.charAt(i));
			boolean executedSuccesfully = commandToExecute.execute();
			
			if(executedSuccesfully == false)
				return false;
		}
		return true;

//		for(int i = 0; i< command.length() ; i++) {
//			char action = command.charAt(i);
//			if(action == 'L') {
//				this.turnLeft();
//				System.out.println("Turning Left");
//			}
//			else if(action == 'R') {
//				this.turnRight();
//				System.out.println("Turning Right");
//			}
//			else if(action == 'M') {
//				this.move();
//				System.out.println("Moving Forward");
//			}
//			else
//				return false;
//		}
//		return true;
	}
	
//	protected boolean turnRight()
//	{
//		return this.cardinalManager.rotateRight();
//	}
	
//	protected boolean turnLeft()
//	{
//		return this.cardinalManager.rotateLeft();
//	}
	
	/*protected boolean move()
	{
		Point unitPointInCurrentDirection = this.cardinalManager.getUnitPointInCurrentDirection();
		// TODO: Handles the case 0,0 here
		
		// Create a temporary point object because we first want to verify if the
		// rover is in plateau or not. Once we have verified and it is in plateau,
		// we will assign the new temporary position to the current position of rover.
		Point newProposedRoverPosition = this.position.add(unitPointInCurrentDirection);
		
		boolean isRoverInPlateau = this.plateau.contains(newProposedRoverPosition);
		
		if(isRoverInPlateau) {
			this.position = newProposedRoverPosition;
			return true;
		}
		return false;
	}*/
	
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
