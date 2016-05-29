package com.marsrover.cardinalmanager;

import com.marsrover.Point;
import com.marsrover.cardinaldirection.*;

/**
 * This interface represents a simple abstraction on top of Cardinal points.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public interface CardinalManager {
	public CardinalDirection getCardinalDirection();
	public boolean rotateLeft();
	public boolean rotateRight();
	public Point getUnitPointInCurrentDirection();
}
