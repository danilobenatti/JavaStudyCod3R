package beginners_level;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

public class CalculateAreaOfCircle {
	
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getNumberInstance(
			new Locale.Builder().setLanguage("pt").setRegion("BR").build());
		nf.setMinimumFractionDigits(5);
		
		final double PI = 3.14159;
		
		System.out.println(PI);
		System.out.println(PI == Math.PI);
		
		String str = JOptionPane.showInputDialog(null, "Inform radiu",
			"Input Value", JOptionPane.QUESTION_MESSAGE);
		double radius = Double.parseDouble(str);
		double diameter = 2 * radius;
		
		double areaByRadio = Math.PI * Math.pow(radius, 2);
		
		double areaByDiameter = Math.PI * Math.pow(diameter, 2) / 4;
		
		double perimeterByRadio = 2 * Math.PI * radius;
		double perimeterByDiameter = Math.PI * diameter;
		
		System.out.println(areaByRadio);
		System.out.println(areaByDiameter);
		System.out.println(perimeterByRadio);
		System.out.println(perimeterByDiameter);
		
		System.out.printf("Area by radius: %s%n", nf.format(areaByRadio));
		System.out.printf("Area by diameter: %.5f%n", areaByDiameter);
		System.out.printf("Perimeter by radius: %s%n", nf.format(perimeterByRadio));
		System.out.printf("Perimeter by diameter: %.6f%n", perimeterByDiameter);
		
		StringBuilder builder = new StringBuilder();
		builder.append("Radius info: ").append(radius);
		builder.append(StringUtils.LF);
		builder.append("Area by radius: ").append(nf.format(areaByRadio));
		builder.append(StringUtils.LF);
		builder.append("Area by diameter: ").append(nf.format(areaByDiameter));
		builder.append(StringUtils.LF);
		builder.append("Perimeter by radius: ").append(nf.format(perimeterByRadio));
		builder.append(StringUtils.LF);
		builder.append("Perimeter by diameter: ").append(nf.format(perimeterByDiameter));
		JOptionPane.showMessageDialog(null, builder.toString(), "Result calc.",
			JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}
}
