package com.marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.marsrover.cardinalpoint.*;

/**
 * This class represents simple cardinal system.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class SimpleCardinalManager implements CardinalManager {
	private final int LEFT_OFFSET = 270;
	private final int RIGHT_OFFSET = 90;
	
	private CardinalDirection cardinalPoint;
	private static List<CardinalDirection> cardinalPoints = Arrays.asList(
																		new North(), 
																		new East(), 
																		new South(), 
																		new West()
																	 );
		
	public SimpleCardinalManager(CardinalDirection direction) {
		this.cardinalPoint = direction;
	}
	
	@Override
	public CardinalDirection getCardinalDirection()
	{
		return this.cardinalPoint;
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
		return this.cardinalPoint.getUnitBlock();
	}
	
	private boolean rotate(int offset) {
		CardinalDirection newCardinalPoint = this.getCardinalPointAgainstDegrees(
															this.cardinalPoint.rotate(/* offset */ offset)
																			);
		
		if(newCardinalPoint.isValid()) {
			this.cardinalPoint = newCardinalPoint;
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
