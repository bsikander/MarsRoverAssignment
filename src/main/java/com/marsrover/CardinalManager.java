package com.marsrover;

import com.marsrover.CardinalPoint.*;

/**
 * This interface represents a simple abstraction on top of Cardinal points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public interface CardinalManager {
	public CardinalPoint getCardinalPoint();
	public boolean rotateLeft();
	public boolean rotateRight();
	public Point getOneGridPointInCurrentDirection();
}
