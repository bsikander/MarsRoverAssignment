package com.marsrover;

import java.util.ArrayList;
import java.util.List;

import com.marsrover.CardinalPoint.*;

/**
 * This class represents simple cardinal system.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class SimpleCardinalManager implements CardinalManager {
	
	private CardinalPoint cardinalPoint;
	private static final List<CardinalPoint> cardinalPoints = new ArrayList<CardinalPoint>();
	
	static
	{
		cardinalPoints.add(new North());
		cardinalPoints.add(new East());
		cardinalPoints.add(new South());
		cardinalPoints.add(new West());
	}
	
	public SimpleCardinalManager(CardinalPoint direction) {
		this.cardinalPoint = direction;
	}
	
	@Override
	public CardinalPoint getCardinalPoint()
	{
		return this.cardinalPoint;
	}
	
	@Override
	public boolean rotateLeft() {
		return this.rotate(/* offset */ 270);
	}

	@Override
	public boolean rotateRight() {
		return this.rotate(/* offset */ 90);
	}
	
	@Override
	public Point getOneGridPointInCurrentDirection() {
		return this.cardinalPoint.getOneGridBlock();
	}
	
	private boolean rotate(int offset) {
		CardinalPoint newCardinalPoint = this.getCardinalPointAgainstDegrees(
															this.cardinalPoint.rotate(/* offset */ offset)
																			);
		
		if(newCardinalPoint.isValid()) {
			this.cardinalPoint = newCardinalPoint;
			return true;
		}
		return false;
	}
	
	private CardinalPoint getCardinalPointAgainstDegrees(int degrees) {
		for(CardinalPoint cardinalPoint: cardinalPoints) {
			if(cardinalPoint.compareDegrees(degrees)) {
				return cardinalPoint;
			}
		}
		return new NullCardinalPoint();
	}

}
