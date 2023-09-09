package beginners_level;

import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.fraction.Fraction;

public class ArithmeticExercise {
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		int a = 3 * 4 - 10;
		int b = (int) Math.pow(a, 3);
		int c = new Double(Math.pow(a, 3)).intValue();
		int d = Double.valueOf(Math.pow(a, 3)).intValue();
		int e = (int) Math.round(Math.pow(a, 3));
		double f = new Power(3).value(a);
		
		System.out.println("a) " + a);
		System.out.println("b) " + b);
		System.out.println("c) " + c);
		System.out.println("d) " + d);
		System.out.println("e) " + e);
		System.out.println("f) " + f);
		
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(1, 2);
		Fraction sum = f1.add(f2);
		System.out.println("Apache Math3 1): " + sum);
		System.out.println("Apache Math3 2): " + sum.doubleValue());
		System.out.println("Apache Math3 3): " + sum.percentageValue());
		
		double p1 = Math.pow((6 * (3 + 2)), 2) / (3 * 2);
		double p2 = Math.pow((((1 - 5) * (2 - 7)) / 2), 2);
		double result = (Math.pow((p1 - p2), 3)) / Math.pow(10, 3);
		System.out.println("Solution 1) " + result);
		
		double e1 = Math.floorDiv((int) Math.pow((6 * (3 + 2)), 2), (3 * 2));
		double e2 = Math.pow(Math.floorDiv(((1 - 5) * (2 - 7)), 2), 2);
		double solve = (Math.pow((e1 - e2), 3)) / Math.pow(10, 3);
		System.out.println("Solution 2) " + solve);
		
		double s1 = new Power(2).value(6.0 * (3 + 2)) / (3 * 2);
		double s2 = new Power(2).value(((1 - 5) * (2 - 7)) / 2.0);
		double solution = new Power(3).value(s1 - s2) / 1E3;
		System.out.println("Solution 3) " + solution);
		
	}
	
}
