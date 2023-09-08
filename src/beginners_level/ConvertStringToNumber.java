package beginners_level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class ConvertStringToNumber {
	
	public static void main(String[] args) {
		
		String str1 = JOptionPane.showInputDialog(null, "Info number1",
			"Input Number1", JOptionPane.QUESTION_MESSAGE);
		String str2 = JOptionPane.showInputDialog(null, "Info number2",
			"Input Number2", JOptionPane.QUESTION_MESSAGE);
		
		double d1 = Double.parseDouble(str1);
		double d2 = Double.parseDouble(str2);
		
		List<Double> list = Arrays.asList(d1, d2);
		
		Long count = list.stream().collect(Collectors.counting());
		Double sum = list.stream().collect(Collectors.summingDouble(d -> d));
		Double avg = list.stream().collect(Collectors.averagingDouble(d -> d));
		
		System.out.println(count);
		System.out.println(sum);
		System.out.println(avg);
	}
	
}
