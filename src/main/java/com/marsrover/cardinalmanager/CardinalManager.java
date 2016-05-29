package com.marsrover.cardinalmanager;

import com.marsrover.Point;
import com.marsrover.cardinaldirection.*;

/**
 * This interface represents a simple abstraction on top of rover's Cardinal management.
 * Whenever rover has to change it direction, it contacts the concrete implementation of
 * CardinalManager.
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
