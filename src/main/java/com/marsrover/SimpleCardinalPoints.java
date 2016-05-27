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

		//		if(direction != ' ') {
//			this.direction = direction;
//			System.out.println("[Turn Left] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees));
//			return true;
//		}
//		return false;
	}

	@Override
	public void rotateRight() {
		int currentDirectionInDegrees = cardinalPoints.get(this.direction);
		char direction = this.getCardinalPointAgainstDegrees((currentDirectionInDegrees + 90) % 360);
		this.direction = direction;
		System.out.println("[Turn Right] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees + 90));
		//return direction;
//		if(direction != ' ') {
//			this.direction = direction;
//			System.out.println("[Turn Right] Current Key -> " + direction + " Degrees -> " + (currentDirectionInDegrees + 90));
//			return true;
//		}
//		return false;
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
