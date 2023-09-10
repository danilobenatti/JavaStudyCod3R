package beginners_level;

public class RelationalOperators {
	
	public static void main(String[] args) {
		
		int a = 97;
		int b = 'a';
		System.out.println(a == b);
		
		System.out.println(3 > 4);
		System.out.println(30 != 7);
		System.out.println(3 >= 3);
		System.out.println(3 < 7);
		System.out.println(30 <= 7);
		
		double grade = 9.9;
		boolean goodBehavior = false;
		boolean reachedAverage = grade >= 7.0;
		boolean willHaveDiscount = goodBehavior && reachedAverage;
		
		System.out.println("Will have a discount? " + willHaveDiscount);
		
		String result = willHaveDiscount ? "Yes" : "No";
		System.out.println("Will have a discount? " + result);
	}
	
}
