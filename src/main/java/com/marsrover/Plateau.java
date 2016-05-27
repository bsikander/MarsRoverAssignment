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
		
		
//		if(this.getDirection() == 'N') {
//		if(this.position.getYCoordinate() + 1 > 5) return false;
//		this.position.setYCoordinate(this.position.getYCoordinate() + 1);
//	}
//	else if(this.getDirection() == 'E') {
//		if(this.position.getXCoordinate() + 1 > 5) return false;
//		this.position.setXCoordinate(this.position.getXCoordinate() + 1);
//		System.out.println("[MOVE] Point Position -> X: " + this.position.getXCoordinate() +  "Y: " + this.position.getYCoordinate());;
//	}
//	else if (this.getDirection() == 'S') {
//		if(this.position.getYCoordinate() - 1 < 0) return false;
//		this.position.setYCoordinate(this.position.getYCoordinate() - 1);
//	}
//	else if (this.getDirection() == 'W') {
//		if(this.position.getXCoordinate() - 1 < 0) return false;
//		this.position.setXCoordinate(this.position.getXCoordinate() - 1);
//	}
//	return true;

	}
	
	 
	
	
}
