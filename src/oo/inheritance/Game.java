package oo.inheritance;

public class Game {
	
	public static void main(String[] args) {
		
		var player1 = new Villain();
		player1.x = 10;
		player1.y = 10;
		
		var player2 = new Hero();
		player2.x = 10;
		player2.y = 11;
		
		System.out.println(player1.life);
		System.out.println(player2.life);
		
		player1.atack(player2);
		
		System.out.println(player1.life);
		System.out.println(player2.life);
	}
}
