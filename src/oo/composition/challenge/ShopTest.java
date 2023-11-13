package oo.composition.challenge;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class ShopTest {
	
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	private static final Locale LOC = Locale.of("pt", "BR");
	static NumberFormat nf = NumberFormat.getCurrencyInstance();
	static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, LOC);
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy", LOC);
		
		Date date1 = Date.from(
				LocalDate.of(2023, 10, 1).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase1 = new Purchase(date1);
		Item item1 = new Item(new Product("Product1 Test", 5.6), 2);
		Item item2 = new Item(new Product("Product2 Test", 2.1), 1);
		purchase1.addItems(Arrays.asList(item1, item2));
		
		Date date2 = Date.from(
				LocalDate.of(2023, 11, 5).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase2 = new Purchase(date2);
		purchase2.addItem(new Product("Product3 Test", 10.9), 1);
		purchase2.addItem("Product4 Test", 7.8, 2);
		
		Date date3 = Date.from(
				LocalDate.of(2023, 11, 25).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase3 = new Purchase(date3);
		purchase3.addItem("Product5 Test", 3.12, 2);
		
		Client client = new Client("Client 1");
		client.addPurchases(Arrays.asList(purchase1, purchase2, purchase3));
		
		System.out.println(sdf.format(purchase1.date));
		System.out.println(df.format(purchase2.date));
		System.out.println(df.format(purchase3.date));
		
		System.out.println(nf.format(client.getTotal()));
		System.out.println(client.getTotalByDate());
		System.out.println(client.getTotalByYearAndMonth());
	}
}
