package collection_structure;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Product;

public class ArrayListCode {
	
	private static final ZoneId ZONEID = ZoneId.of("America/Sao_Paulo");
	
	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<>();
		
		Product p1 = new Product("Product Test 1", 10.5, 5.0f,
			new float[] { 5, 4, 3 }, Date.from(Instant.now()), null);
		p1.setValidity(365L);
		
		Date manufactured2YearAgo = Date.from(
			LocalDate.now().minusYears(2).atStartOfDay(ZONEID).toInstant());
		
		Product p2 = new Product("Product Test 2", 15.5, 7.5f,
			new float[] { 7, 8, 9 }, manufactured2YearAgo, null);
		p2.setValidity(24);
		
		Product p3 = new Product("Product Test 3", 15.5, 7.5f,
			new float[] { 9, 5, 2 }, manufactured2YearAgo, null);
		p3.setValidity(Year.of(1));
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		System.out.println(products.contains(p1));
		System.out.println(products.get(0));
		System.out.println(products.get(1));
		System.out.println(products.get(2));
		
		System.out.println(products.remove(p1));
		
		for (Product product : products) {
			System.out.printf("%n%s", product);
		}
		System.out.print("\n\n" + products.remove(0));
		
	}
	
}
