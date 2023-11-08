package oo.composition;

import static java.text.NumberFormat.getCurrencyInstance;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class OrderTest {
	
	static NumberFormat cfUS = getCurrencyInstance(
			new Locale.Builder().setLanguage("en").setRegion("US").build());
	static NumberFormat cfBR = getCurrencyInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		cfBR.setMaximumFractionDigits(2);
		cfBR.setRoundingMode(RoundingMode.HALF_EVEN);
		
		Order order = new Order();
		order.client = "Johny";
		order.addItem(new Item("Product 1", 20, 7.45));
		order.addItem("Product 2", 12, 3.89);
		order.addItem("Product 3", 3, 18.79);
		order.addItems(new ArrayList<>(Arrays.asList(
				new Item("Product 4", 1, 2.2), new Item("Product 5", 1, 3))));
		
		System.out.println(order.items.size());
		System.out.println(cfBR.format(order.getTotal()));
		System.out.println(cfUS.format(Order.getTotal(order.items)));
	}
	
}
