package beginners_level;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class ConvertExercise {
	
	static Locale locale = new Locale.Builder().setLanguage("pt")
		.setRegion("BR").build();
	
	public static void main(String[] args) {
		
		Locale.setDefault(locale);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		ArrayList<Double> list = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(locale.getDisplayName());
			System.out.printf("%s (%s)%n",
				Currency.getInstance(locale).getDisplayName(),
				Currency.getInstance(locale).getSymbol());
			for (int i = 1; i <= 3; i++) {
				System.out.println(new StringBuilder().append("Info")
					.append(StringUtils.SPACE).append(i).append("\u00BA")
					.append(StringUtils.SPACE).append("salary:"));
				list.add(Double.valueOf(scanner.nextLine().replace(',', '.')));
			}
		}
		
		// calculate the average of the last three salaries.
		System.out.println(String.format("Average Salary is: %s", nf.format(
			list.stream().mapToDouble(i -> i).average().getAsDouble())));
	}
	
}