package com.marsrover;

import com.marsrover.CardinalPoint.CardinalPoint;

/**
 * This interface represents a simple abstraction on top of Cardinal points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public interface CardinalManager {
	public CardinalPoint getDirection();
	public void rotateLeft();
	public void rotateRight();
	public Point getOneGridPointInCurrentDirection();
}
