package beginners_level;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

public class RelationalOperators {
	
	public static void main(String[] args) {
		
		int a = 97;
		int b = 'a';
		System.out.println(a == b);
		
		System.out.println(3 > 4);
		System.out.println(30 != 7);
		System.out.println(3 >= (1 + 2));
		System.out.println(3 < 7);
		System.out.println(30 <= 7);
		
		double grade = Double.parseDouble(showInputDialog("Inform grade:"));
		boolean goodBehavior = showConfirmDialog(null, "Have good behavior?",
			"Behavior", JOptionPane.YES_NO_OPTION) == 0;
		boolean reachedAverage = grade >= 7.0;
		boolean willHaveDiscount = goodBehavior && reachedAverage;
		
		String result = willHaveDiscount ? "Yes" : "No";
		
		showMessageDialog(null,
			new StringBuilder().append("Will have a discount? ").append(result),
			"Discount",
			willHaveDiscount ? INFORMATION_MESSAGE : WARNING_MESSAGE);
		
		System.out.println("Will have a discount? " + result);
	}
	
}
