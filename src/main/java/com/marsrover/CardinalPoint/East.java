package com.marsrover.CardinalPoint;

import com.marsrover.Point;

public class East extends CardinalPoint {
	
	public East() {
		super('E', 				/* direction */
			   90, 				/* degrees */ 
			   new Point(1,0) 	/* one Grid block */
			 );
	}
	
}
