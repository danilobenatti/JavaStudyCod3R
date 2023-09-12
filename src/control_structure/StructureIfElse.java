package control_structure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

public class StructureIfElse {
	
	public static void main(String[] args) {
		
		Locale locale = new Locale("en", "US");
		
		BigDecimal number;
		
		try (Scanner scanner = new Scanner(System.in).useLocale(locale)) {
			System.out.print("Inform final note: ");
			number = scanner.nextBigDecimal()
				.setScale(1, RoundingMode.HALF_EVEN).abs();
		}
		
		System.out.println(number);
		
		boolean approved = number.compareTo(BigDecimal.valueOf(7)) >= 0
			&& number.compareTo(BigDecimal.valueOf(10)) <= 0;
		boolean recovery = number.compareTo(BigDecimal.valueOf(4.9)) >= 0
			&& number.compareTo(BigDecimal.valueOf(7)) < 0;
		boolean lessEqualsThanTEN = number.compareTo(BigDecimal.TEN) <= 0;
		boolean greaterEqualsZERO = number.compareTo(BigDecimal.ZERO) >= 0;
		boolean intoRange = lessEqualsThanTEN && greaterEqualsZERO;
		
		if (intoRange && approved) {
			System.out.println("Approved");
		} else if (intoRange && recovery) {
			System.out.println("Recovery");
		} else if (intoRange) {
			System.out.println("Disapproved");
		} else {
			System.out.println(
				"The value must be: greater or equal to ZERO and less or equal to TEN");
		}
		
		if (!intoRange) {
			System.out.println(
				"The value must be: greater or equal to ZERO and less or equal to TEN");
		} else if (approved) {
			System.out.println("Approved");
		} else if (recovery) {
			System.out.println("Recovery");
		} else {
			System.out.println("Disapproved");
		}
		
	}
	
}
