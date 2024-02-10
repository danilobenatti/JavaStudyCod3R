package lambda;

import java.util.function.BinaryOperator;

public class CalculusTest3 {
	
	public static void main(String[] args) {
		
		BinaryOperator<Double> calc1 = (x, y) -> x + y;
		System.out.println(calc1.apply(2.0, 3.0));
		
		calc1 = (x, y) -> Math.pow(x * y, 2);
		System.out.println(calc1.apply(2.0, 3.0));
	}
}
