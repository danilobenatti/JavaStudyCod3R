package util;


/**
 * Class for calculating the Body Mass Index (BMI). Based on the individual's
 * weight, height and gender.
 * 
 * @author danil
 *
 */
public class Imc {
	
	private Imc() {
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI).
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @return value Double BMI value.
	 */
	public static double calcImc(float weight, float height) {
		double value = 0;
		if (weight > 0 && height > 0)
			value = weight / Math.pow(height, 2);
		return value;
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI) by the
	 * individual's gender.
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @param sex    Gender of the person, male or female only.
	 * @return info BMI calculation information.
	 * @throws info NullPointException
	 * @since 1.0
	 */
	public static String imcByGender(float weight, float height, char sex) {
		return switch (sex) {
			case 'f', 'F' -> femaleImc(calcImc(weight, height));
			case 'm', 'M' -> maleImc(calcImc(weight, height));
			default -> null;
		};
	}
	
	/**
	 * Method that returns information about the BMI calculation for females.
	 * 
	 * @param value Calculated BMI.
	 * @return info BMI calculation information for women.
	 */
	public static String femaleImc(double value) {
		String info = null;
		if (value < 19.1) {
			info = String.format("[%.2f] under weight.", value);
		} else if (value > 19.2 && value < 25.8) {
			info = String.format("[%.2f] at ideal weight.", value);
		} else if (value > 25.9 && value < 27.3) {
			info = String.format("[%.2f] a little overweight.", value);
		} else if (value > 27.4 && value < 32.3) {
			info = String.format("[%.2f] over ideal weight.", value);
		} else {
			info = String.format("[%.2f] obesity.", value);
		}
		return info;
	}
	
	/**
	 * Method that returns information about the BMI calculation for males.
	 * 
	 * @param value Calculated BMI.
	 * @return info BMI calculation information for men.
	 */
	public static String maleImc(double value) {
		String info = null;
		if (value < 20.7) {
			info = String.format("[%.2f] under weight.", value);
		} else if (value > 20.8 && value < 26.4) {
			info = String.format("[%.2f] at ideal weight.", value);
		} else if (value > 26.5 && value < 27.8) {
			info = String.format("[%.2f] a little overweight.", value);
		} else if (value > 27.9 && value < 31.1) {
			info = String.format("[%.2f] over ideal weight.", value);
		} else {
			info = String.format("[%.2f] obesity.", value);
		}
		return info;
	}
	
}
