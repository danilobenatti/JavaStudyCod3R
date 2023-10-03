package model;

import static java.text.DateFormat.getDateInstance;

import java.text.DateFormat;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

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
	
	public Product() {
		this(1, 1, 1);
	}
	
	public Product(String name, double price, float weight, float[] sides,
		Date manufactureDate, Date validityDate) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.sides = sides;
		this.manufactureDate = manufactureDate;
		this.validityDate = validityDate;
	}
	
	public Product(float xSize, float ySize, float zSize) {
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
	
	/**
	 * @deprecated new code
	 * @param days
	 */
	@Deprecated(since = "1.0", forRemoval = true)
	public void setValidity_(long days) {
		// assume that 1 day = 8,64e+7 milliseconds
		final double oneDayMilli = 8.64E7;
		this.validityDate = new Date(
			(long) (this.manufactureDate.getTime() + (days * oneDayMilli)));
	}
	
	public void setValidity(long days) {
		this.validityDate = Date
			.from(this.manufactureDate.toInstant().plus(days, ChronoUnit.DAYS));
	}
	
	/**
	 * @deprecated new code
	 * @param months
	 */
	@Deprecated(since = "1.0", forRemoval = true)
	public void setValidity_(int months) {
		// assume that 1 month = 2,628e+9 milliseconds
		final double oneMonthMilli = 2.628E9;
		this.validityDate = new Date(
			(long) (this.manufactureDate.getTime() + (months * oneMonthMilli)));
	}
	
	public void setValidity(int months) {
		this.validityDate = Date.from(this.manufactureDate.toInstant()
			.atZone(ZoneId.systemDefault()).plusMonths(months).toInstant());
		
	}
	
	public void setValidity(Year year) {
		this.validityDate = Date.from(
			this.manufactureDate.toInstant().atZone(ZoneId.systemDefault())
				.plusYears(year.getValue()).toInstant());
	}
	
	public Date getValidityDateByDays(long days) {
		return Date
			.from(this.manufactureDate.toInstant().plus(days, ChronoUnit.DAYS));
	}
	
	public Date getValidityDateByMonths(int months) {
		return Date.from(this.manufactureDate.toInstant()
			.atZone(ZoneId.systemDefault()).plusMonths(months).toInstant());
	}
	
	public boolean validityDateIsOk() {
		if (this.validityDate != null) {
			return Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS))
				.compareTo(this.validityDate) < 0;
		}
		return false;
	}
	
	public void setCubicVolume(float xSize, float ySize, float zSize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
		this.sides = new float[] { xSize, ySize, zSize };
	}
	
	public float getCubicVolume() {
		if (sides != null) {
			xSize = sides[0];
			ySize = sides[1];
			zSize = sides[2];
		}
		return xSize * ySize * zSize;
	}
	
	public float getCubicVolume(float[] sides) {
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
		sb.append(", validityDateIsOk=");
		sb.append(validityDateIsOk());
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name);
	}
	
}
