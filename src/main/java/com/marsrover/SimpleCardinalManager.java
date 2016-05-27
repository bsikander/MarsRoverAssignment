package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class represents simple cardinal system.
 * 
 * @author Behroz Sikander
 * @version 1.0
 */
public class SimpleCardinalManager implements CardinalManager {
	private char direction;
	private static final Map<Character, Integer> cardinalPoints = new HashMap<Character, Integer>();
	
	static
	{
		cardinalPoints.put('N', 0);
		cardinalPoints.put('E', 90);
		cardinalPoints.put('S', 180);
		cardinalPoints.put('W', 270);
	}
	
	public SimpleCardinalManager(char direction) {
		this.direction = direction;
	}
	
	@Override
	public char getDirection()
	{
		return this.direction;
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
		if     (this.direction == 'N') return new Point(0,1);
		else if(this.direction == 'E') return new Point(1,0);
		else if(this.direction == 'S') return new Point(0,-1);
		else if(this.direction == 'W') return new Point(-1,0);
		else return new Point(0,0);
	}
	
	private void rotate(int offset) {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char direction = this.getCardinalPointAgainstDegrees( 
																(currentDirectionInDegrees + offset) % 360 
															);
		this.direction = direction;
	}
	
	private char getCardinalPointAgainstDegrees(int degrees)
	{
		for(Entry<Character, Integer> entry: cardinalPoints.entrySet()) {
			if(entry.getValue().equals(degrees)) {
				return entry.getKey();
			}
		}
		return ' ';
	}

}
