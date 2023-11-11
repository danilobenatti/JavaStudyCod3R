package oo.composition;

import static java.text.NumberFormat.getCurrencyInstance;
import static oo.composition.Order.getTotal;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class OrderTest {
	
	static NumberFormat cfUS = getCurrencyInstance(Locale.of("en", "US"));
	static NumberFormat cfBR = getCurrencyInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		cfBR.setMaximumFractionDigits(1);
		cfBR.setRoundingMode(RoundingMode.HALF_UP);
		
		Order order = new Order();
		order.client = "Johny";
		order.addItem(new Item("Product 1", 20, 7.45));
		order.addItem("Product 2", 12, 3.89);
		order.addItem("Product 3", 3, 18.79);
		Item item = new Item("Product 4", 1, 2.2);
		order.addItems(Arrays.asList(item, new Item("Product 5", 1, 3)));
		
		System.out.println(order.items.size());
		System.out.println(cfBR.format(order.getTotal()));
		System.out.println(cfUS.format(getTotal(order.items)));
	}
	
}
