package oo.inheritance;

public class Game {
	
	public static void main(String[] args) {
		
		Player player = new Player();
		
		player.x = 10;
		player.y = 10;
		
		player.walk(Direction.NORTH);
		player.walk(Direction.EAST);
		player.walk(Direction.NORTH);
		player.walk(Direction.EAST);
		
		System.out.println(player.x);
		System.out.println(player.y);
	}
}
