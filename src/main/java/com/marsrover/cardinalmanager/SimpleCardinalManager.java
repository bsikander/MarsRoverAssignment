package com.marsrover.cardinalmanager;


import java.util.Arrays;
import java.util.List;
import com.marsrover.Point;
import com.marsrover.cardinaldirection.*;

/**
 * This class represents simple cardinal system (N,E,S,W).
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class SimpleCardinalManager implements CardinalManager {
	private final int LEFT_OFFSET = 270;
	private final int RIGHT_OFFSET = 90;
	
	private CardinalDirection cardinalDirection;
	private static List<CardinalDirection> cardinalPoints = Arrays.asList(
																		new North(), 
																		new East(), 
																		new South(), 
																		new West()
																	 );
		
	public SimpleCardinalManager(CardinalDirection initialDirection) {
		this.cardinalDirection = initialDirection;
	}
	
	@Override
	public CardinalDirection getCardinalDirection()
	{
		return this.cardinalDirection;
	}
	
	@Override
	public boolean rotateLeft() {
		return this.rotate(this.LEFT_OFFSET);
	}

	@Override
	public boolean rotateRight() {
		return this.rotate(this.RIGHT_OFFSET);
	}
	
	@Override
	public Point getUnitPointInCurrentDirection() {
		return this.cardinalDirection.getUnitBlock();
	}
	
	private boolean rotate(int offset) {
		CardinalDirection newCardinalPoint = this.getCardinalPointAgainstDegrees(
															this.cardinalDirection.rotate(offset)
																			);
		
		if(newCardinalPoint.isValid()) {
			this.cardinalDirection = newCardinalPoint;
			return true;
		}
		return false;
	}
	
	private CardinalDirection getCardinalPointAgainstDegrees(int degrees) {
		for(CardinalDirection cardinalPoint: cardinalPoints) {
			if(cardinalPoint.compareDegrees(degrees)) {
				return cardinalPoint;
			}
		}
		return new NullCardinalPoint();
	}

}
