package lambda;

public class CalculusTest2 {
	
	public static void main(String[] args) {
		
		Calculus calc1 = (x, y) -> x + y;
		Calculus calc2 = (x, y) -> x * y;
		
		System.out.println(calc1.execute(2, 3));
		System.out.println(calc2.execute(2, 3));
		
		System.out.println(calc1.text());
		System.out.println(Calculus.other());
	}
}
