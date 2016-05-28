package com.marsrover;

import com.marsrover.CardinalPoint.CardinalPoint;

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
	
	public Rover(Plateau plateau, Point position, CardinalManager direction)
	{
		this.cardinalManager = direction;
		this.position = position;
		this.plateau = plateau;
	}
	
	public boolean turnRight()
	{
		this.cardinalManager.rotateRight();
		return this.isValidDirection();
	}
	
	public boolean turnLeft()
	{
		this.cardinalManager.rotateLeft();
		return this.isValidDirection();
	}
	
	public boolean move()
	{
		Point nextPointInCurrentDirection = this.cardinalManager.getOneGridPointInCurrentDirection();
		// TODO: Handles the case 0,0 here
		
		// Create a temporary point object because we first want to verify if the
		// rover is in plateau or not. Once we have verified and it is in plateau,
		// we will assign the new temporary position to the current position of rover.
		Point newProposedRoverPosition = new Point(this.position);
		newProposedRoverPosition.add(nextPointInCurrentDirection);
		
		boolean isRoverInPlateau = this.plateau.contains(newProposedRoverPosition);
		//System.out.println("Position: " + this.position.toString() + " New Position in Direction: " + nextPointInCurrentDirection.toString() + " Added Point: " + temp.toString() + " Result of Contains: " + isRoverInPlateau);
		if(isRoverInPlateau) {
			this.position = newProposedRoverPosition;
			return true;
		}
		else 
			return false;
	}
	
	public CardinalPoint getDirection() {
		return this.cardinalManager.getDirection(); 
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	private boolean isValidDirection() {
		//TODO: Remove this direction
		return this.cardinalManager.getDirection().isValid() ? true : false;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(other == null) return false;
		if(other == this) return true;
		if(!(other instanceof Rover)) return false;
		
		Rover otherRover = (Rover)other;
		if (this.position.equals(otherRover.position) &&
			this.cardinalManager.getDirection().equals(otherRover.getDirection()))
			return true;
		
		return false;
	}
}
