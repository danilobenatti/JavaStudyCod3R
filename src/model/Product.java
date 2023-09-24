package model;

import static java.text.DateFormat.getDateInstance;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Product {
	
	String name;
	
	double price;
	
	static double discount = 0.1;
	
	float weight;
	
	float xSize;
	
	float ySize;
	
	float zSize;
	
	float[] sides = new float[] { this.xSize, this.ySize, this.zSize };
	
	Date manufactureDate;
	
	Date validityDate;
	
	Product() {
		this(1, 1, 1);
	}
	
	Product(String name, double price, float weight, float[] sides,
		Date manufactureDate, Date validityDate) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.sides = sides;
		this.manufactureDate = manufactureDate;
		this.validityDate = validityDate;
	}
	
	Product(float xSize, float ySize, float zSize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
		this.sides = new float[] { xSize, ySize, zSize };
	}
	
	double getPriceWithDiscount() {
		return this.price * (1 - discount);
	}
	
	double getPriceWithDiscount(double discount) {
		return this.price * (1 - discount);
	}
	
	void setValidity(long days) {
		// assume that 1 day = 8,64e+7 milliseconds
		final double oneDayMilli = 8.64E7;
		this.validityDate = new Date(
			(long) (this.manufactureDate.getTime() + (days * oneDayMilli)));
	}
	
	void setValidity(int months) {
		// assume that 1 month = 2,628e+9 milliseconds
		final double oneMonthMilli = 2.628E9;
		this.validityDate = new Date(
			(long) (this.manufactureDate.getTime() + (months * oneMonthMilli)));
	}
	
	void setCubicVolume(float xSize, float ySize, float zSize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
		this.sides = new float[] { xSize, ySize, zSize };
	}
	
	float getCubicVolume() {
		if (sides != null) {
			xSize = sides[0];
			ySize = sides[1];
			zSize = sides[2];
		}
		return xSize * ySize * zSize;
	}
	
	float getCubicVolume(float[] sides) {
		float cubicVolume = 1;
		for (float side : sides)
			cubicVolume *= side;
		return cubicVolume;
	}
	
	@Override
	public String toString() {
		var df = getDateInstance(DateFormat.SHORT, Locale.of("pt", "BR"));
		StringBuilder sb = new StringBuilder();
		sb.append("Product [name=");
		sb.append(name);
		sb.append(", price=");
		sb.append(price);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", sides=");
		sb.append(Arrays.toString(sides));
		sb.append(", manufactureDate=");
		sb.append(manufactureDate != null ? df.format(manufactureDate) : null);
		sb.append(", validityDate=");
		sb.append(validityDate != null ? df.format(validityDate) : null);
		sb.append("]");
		return sb.toString();
	}
	
}
