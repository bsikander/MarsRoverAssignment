package com.marsrover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.marsrover.CardinalPoint.CardinalPoint;
import com.marsrover.CardinalPoint.East;
import com.marsrover.CardinalPoint.North;
import com.marsrover.CardinalPoint.NullCardinalPoint;
import com.marsrover.CardinalPoint.South;
import com.marsrover.CardinalPoint.West;

/**
 * This class represents simple cardinal system.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class SimpleCardinalManager implements CardinalManager {
	private CardinalPoint cardinalPoint;
	//private static final Map<Character, Integer> cardinalPoints = new HashMap<Character, Integer>();
	private static final List<CardinalPoint> cardinalPoints = new ArrayList<CardinalPoint>();
	
	static
	{
		cardinalPoints.add(new North());
		cardinalPoints.add(new East());
		cardinalPoints.add(new South());
		cardinalPoints.add(new West());
		//		cardinalPoints.put('N', 0);
//		cardinalPoints.put('E', 90);
//		cardinalPoints.put('S', 180);
//		cardinalPoints.put('W', 270);
	}
	
	public SimpleCardinalManager(CardinalPoint direction) {
		this.cardinalPoint = direction;
	}
	
	@Override
	public CardinalPoint getDirection()
	{
		return this.cardinalPoint;
	}
	
	@Override
	public void rotateLeft() {
		this.rotate(/* offset */ 270);
		
	}

	@Override
	public void rotateRight() {
		this.rotate(/* offset */ 90);
	}
	
	@Override
	public Point getOneGridPointInCurrentDirection() {
		return this.cardinalPoint.getOneGridBlock();
//		if     (this.direction == 'N') return new Point(0,1);
//		else if(this.direction == 'E') return new Point(1,0);
//		else if(this.direction == 'S') return new Point(0,-1);
//		else if(this.direction == 'W') return new Point(-1,0);
//		else return new Point(0,0);
	}
	
	private void rotate(int offset) {
		CardinalPoint newCardinalPoint = this.getCardinalPointAgainstDegrees(
															this.cardinalPoint.rotate(/* offset */ offset)
																			);
		//TODO: HANDLE NULL -- NULL OBJECT PATTERN
		
		this.cardinalPoint = newCardinalPoint;
		
		
//		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
//		char direction = this.getCardinalPointAgainstDegrees( 
//																(currentDirectionInDegrees + offset) % 360 
//															);
//		this.direction = direction;
	}
	
	private CardinalPoint getCardinalPointAgainstDegrees(int degrees) {
		for(CardinalPoint cardinalPoint: cardinalPoints) {
			if(cardinalPoint.compareDegrees(degrees)) {
				return cardinalPoint;
			}
		}
		return new NullCardinalPoint();
	}
	
//	private char getCardinalPointAgainstDegrees(int degrees)
//	{
//		for(Entry<Character, Integer> entry: cardinalPoints.entrySet()) {
//			if(entry.getValue().equals(degrees)) {
//				return entry.getKey();
//			}
//		}
//		return ' ';
//	}

}
