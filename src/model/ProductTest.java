package model;

import static java.text.DateFormat.FULL;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;
import static java.text.DateFormat.getDateInstance;
import static java.text.NumberFormat.getCurrencyInstance;
import static java.time.Instant.parse;
import static java.util.Date.from;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

public class ProductTest {
	
	static final Locale LOCALE = Locale.of("pt", "BR");
	
	static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
	
	static DateFormat df = DateFormat.getDateTimeInstance(MEDIUM, FULL, LOCALE);
	
	static NumberFormat nf = NumberFormat.getNumberInstance(LOCALE);
	
	static String dateFormatted(Date date) {
		return getDateInstance(SHORT, LOCALE).format(date);
	}
	
	public static void main(String[] args) {
		
		Product.discount = 0.2;
		
		var p1 = new Product();
		p1.name = "Product n\u00BA 1";
		p1.price = 150.8;
		p1.weight = 1.8f;
		p1.manufactureDate = from(parse("2023-09-19T00:00:00.00-03:00"));
		p1.setCubicVolume(10.5f, 20.9f, 30.1f);
		p1.setValidity(365L); // 365 days
		
		float[] sidesP2 = new float[] { 15, 15, 30 };
		var p2 = new Product("Product n\u00BA 2", 89.56, 2.5f, sidesP2,
			Date.from(parse("2023-12-01T00:00:00.00Z")), null);
		p2.setValidity(18); // 18 months
		
		Product p3 = new Product();
		p3.name = "Product n\u00BA 3";
		p3.manufactureDate = from(Instant.now().atZone(ZoneId.systemDefault())
			.minusYears(2).toInstant());
		p3.setValidity(Year.of(1)); // 1 year
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.printf("%s", StringUtils.join(p1.name).concat(":")
			.concat(SPACE).concat(p1.toString()).concat(LF));
		System.out.printf("%s", StringUtils.join(p2.name).concat(":")
			.concat(SPACE).concat(p2.toString()).concat(LF));
		System.out.printf("%s", StringUtils.join(p3.name).concat(":")
			.concat(SPACE).concat(p3.toString()).concat(LF));
		
		List<Double> shoppingCart = new ArrayList<>();
		shoppingCart.add(p1.getPriceWithDiscount());
		shoppingCart.add(p2.getPriceWithDiscount(0.15));
		shoppingCart.add(p2.getPriceWithDiscount());
		shoppingCart.add(p3.getPriceWithDiscount());
		
		double total = shoppingCart.stream().mapToDouble(i -> i).sum();
		System.out.printf("%n%s%n", getCurrencyInstance().format(total));
		
		System.out.printf("%n%s", Instant.now().atZone(ZONE_ID));
		System.out.printf("%n%s%n%n", df.format(Date.from(Instant.now())));
		
		nf.setMaximumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_EVEN);
		
		System.out.println(String.format("Volume p1: %s%c",
			nf.format(p1.getCubicVolume()), Character.valueOf('\u33A4')));
		System.out.println(String.format("Volume p1: %.2f%s",
			p1.getCubicVolume(), CharUtils.toString('\u33A4')));
		System.out.println(String.format("Weight p1: %.2f%s", p1.weight,
			CharUtils.toString('\u338F')));
		
		String msgFactureP1 = "Facture p1: %s%n";
		System.out.printf(msgFactureP1, p1.manufactureDate.toInstant());
		System.out.printf(msgFactureP1, p1.manufactureDate);
		System.out.printf(msgFactureP1, dateFormatted(p1.manufactureDate));
		
		String msgP1 = "Validity p1: %s%n";
		System.out.printf(msgP1, p1.validityDate);
		System.out.printf(msgP1, p1.validityDate.toInstant().atZone(ZONE_ID));
		System.out.printf(msgP1.concat(LF), dateFormatted(p1.validityDate));
		
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		
		System.out.println(String.format("Volume p2: %s%c",
			nf.format(p2.getCubicVolume()), Character.valueOf('\u33A4')));
		System.out.println(String.format("Volume p2: %.2f%c",
			p2.getCubicVolume(p2.sides), CharUtils.toChar('\u33A4')));
		System.out.println(String.format("Weight p2: %.2f%c", p2.weight,
			CharUtils.toChar('\u338F')));
		
		String msgFactureP2 = "Facture p2: %s%n";
		System.out.printf(msgFactureP2,
			LocalDate.ofInstant(p2.manufactureDate.toInstant(), ZONE_ID));
		System.out.printf(msgFactureP2, p2.manufactureDate);
		System.out.printf(msgFactureP2, dateFormatted(p2.manufactureDate));
		
		String msgP2 = "Validity p2: %s%n";
		System.out.printf(msgP2, p2.validityDate);
		System.out.printf(msgP2, p2.validityDate.toInstant().atZone(ZONE_ID));
		System.out.printf(msgP2, dateFormatted(p2.validityDate));
	}
	
}
