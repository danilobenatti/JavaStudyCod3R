package control_structure;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StructureWhile {
	
	public static void main(String[] args) {
		
		// 0 - 9 (integer)
		System.out.println(new Random().nextInt(0, 11));
		
		// between 10 and 100 (integer)
		int min = 10, max = 100;
		// find by 26 (integer)
		final int find = 25;
		
		// solution 1
		int i = 0, j = find + 1;
		while (j != find) {
			j = (int) (Math.random() * (max - min + 1) + min);
			i++;
		}
		message(i, find);
		
		// solution 2
		int k = 0, l = 0;
		do {
			l = new Random().nextInt(max - min + 1);
			k++;
		} while (l != find);
		message(k, find);
		
		// between the origin (inclusive) and the bound (exclusive)
		System.out.println("Random[0 - 100]: " + new Random().nextInt(0, 101));
		
		System.out.println(ThreadLocalRandom.current().nextInt(0, 10));
		System.out.println(ThreadLocalRandom.current().nextBoolean());
		
		for (String v = "#"; !v.equals("######"); v += "#") {
			System.out.println(v);
		}
		
	}
	
	public static void message(int i, int find) {
		System.out.println(String.format(
			"Looping %d times until finding n%c %d", i, '\u00BA', find));
	}
	
}
