package lambda;

public class CalculusTest1 {
	
	public static void main(String[] args) {
		
		Calculus calc1 = new Sum();
		Calculus calc2 = new Multiply();
		
		System.out.println(calc1.execute(2, 3));
		System.out.println(calc2.execute(2, 3));
	}
	
}
