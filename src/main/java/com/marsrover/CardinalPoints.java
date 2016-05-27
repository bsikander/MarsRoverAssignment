package com.marsrover;

/**
 * This interface represents a simple abstraction on top of Cardinal points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public interface CardinalPoints {
	public char getDirection();
	public void rotateLeft();
	public void rotateRight();
	public Point getOneGridPointInCurrentDirection();
}
