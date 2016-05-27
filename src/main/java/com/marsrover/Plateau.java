package com.marsrover;

/**
 * This class represents a Plateau in Mars rover assignment.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class Plateau {

	private Point upperRightCoordinates;
	private Point lowerLeftCoordinates;
	
	public Plateau(Point lowerLeftCoordinates,Point upperRightCoordinates) {
		this.lowerLeftCoordinates = lowerLeftCoordinates;
		this.upperRightCoordinates = upperRightCoordinates;
	}
	
	/**
	 * Checks if the coordinates of rover lie in the boundary of Plateau.
	 * 
	 * @param roverPosition The current rover position.
	 * @return True, if the rover lies within the boundaries. False otherwise.
	 */
	public boolean contains(Point roverPosition) {
		return (roverPosition.compareTo(this.lowerLeftCoordinates) != -1 // Rover Points should be greater than or equal to (0,0)
				&& this.upperRightCoordinates.compareTo(roverPosition) != -1); // UpperRightCoordinates should be greater than equal to Rover points
	}
}
