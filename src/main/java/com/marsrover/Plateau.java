package com.marsrover;

public class Plateau {

	private Point upperRightCoordinates;
	private Point lowerLeftCoordinates;
	
	public Plateau(Point lowerLeftCoordinates,Point upperRightCoordinates) {
		this.lowerLeftCoordinates = lowerLeftCoordinates;
		this.upperRightCoordinates = upperRightCoordinates;
	}
	
	public boolean contains(Point roverPosition) {
		return (roverPosition.compareTo(this.lowerLeftCoordinates) != -1 // Rover Points should be greater than or equal to (0,0)
				&& this.upperRightCoordinates.compareTo(roverPosition) != -1); // UpperRightCoordinates should be greater than equal to Rover points
	}
}
