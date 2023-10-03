package beginners_level;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.LF;

import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.math3.util.MathUtils;

public class CalculateAreaOfCircle {
	
	static NumberFormat nf = NumberFormat
		.getNumberInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		
		nf.setMinimumFractionDigits(5);
		
		final double PI = 3.14159;
		
		System.out.println(PI);
		System.out.println(PI == Math.PI);
		
		String str = showInputDialog(null, "Inform radiu", "Input Value",
			QUESTION_MESSAGE);
		double radius = Double.parseDouble(str);
		double diameter = 2 * radius;
		
		double areaByRadio = Math.PI * Math.pow(radius, 2);
		
		double areaByDiameter = Math.PI * Math.pow(diameter, 2) / 4;
		
		double perimeterByRadio = MathUtils.TWO_PI * radius;
		double perimeterByDiameter = Math.PI * diameter;
		
		System.out.println(areaByRadio);
		System.out.println(areaByDiameter);
		System.out.println(perimeterByRadio);
		System.out.println(perimeterByDiameter);
		
		System.out.printf("Area by radius: %s%n", nf.format(areaByRadio));
		System.out.printf("Area by \u2205: %.5f%n", areaByDiameter);
		System.out.printf("Perimeter by radius: %s%n",
			nf.format(perimeterByRadio));
		System.out.printf("Perimeter by \u2205: %.6f%n", perimeterByDiameter);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Radius info: ");
		sb.append(radius).append(LF);
		sb.append("Area by radius: ");
		sb.append(nf.format(areaByRadio)).append(LF);
		sb.append("Area by \u2205: ");
		sb.append(nf.format(areaByDiameter)).append(LF);
		sb.append("Perimeter by radius: ");
		sb.append(nf.format(perimeterByRadio)).append(LF);
		sb.append("Perimeter by \u2205: ");
		sb.append(nf.format(perimeterByDiameter));
		showMessageDialog(null, sb, "Result calc.", INFORMATION_MESSAGE);
		
	}
}
