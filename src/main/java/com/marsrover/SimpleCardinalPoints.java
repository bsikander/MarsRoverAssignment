package com.marsrover;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleCardinalPoints implements CardinalPoints {
	private char direction;
	private static final Map<Character, Integer> cardinalPoints = new HashMap<Character, Integer>();
	
	static
	{
		cardinalPoints.put('N', 0);
		cardinalPoints.put('E', 90);
		cardinalPoints.put('S', 180);
		cardinalPoints.put('W', 270);
	}
	
	public SimpleCardinalPoints(char direction) {
		this.direction = direction;
	}
	
	@Override
	public char getDirection()
	{
		return this.direction;
	}
	
	@Override
	public void rotateLeft() {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char direction = this.getCardinalPointAgainstDegrees((currentDirectionInDegrees + 270) % 360);
		this.direction = direction;
		System.out.println("[Turn Left] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees));
	}

	@Override
	public void rotateRight() {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char direction = this.getCardinalPointAgainstDegrees((currentDirectionInDegrees + 90) % 360);
		this.direction = direction;
		System.out.println("[Turn Right] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees + 90));
	}
	
	@Override
	public Point getPointInCurrentDirection() {
		if     (this.direction == 'N') return new Point(0,1);
		else if(this.direction == 'E') return new Point(1,0);
		else if(this.direction == 'S') return new Point(0,-1);
		else if(this.direction == 'W') return new Point(-1,0);
		else return new Point(0,0);
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
