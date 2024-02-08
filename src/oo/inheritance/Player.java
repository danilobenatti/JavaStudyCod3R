package oo.inheritance;

public class Player {
	
	int x;
	int y;
	
	boolean walk(Direction direction) {
		switch(direction) {
			case NORTH -> y--;
			case EAST -> x++;
			case SOUTH -> y++;
			case WEST -> x--;
		}
		return true;
	}
}
