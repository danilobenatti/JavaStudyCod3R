package oo.composition.challenge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Client {
	
	String name;
	
	List<Purchase> purchases = new ArrayList<>();
	
	Client(String name) {
		this.name = name;
	}
	
	void addPurchase(Purchase purchases) {
		this.purchases.add(purchases);
	}
	
	void addPurchases(List<Purchase> purchases) {
		this.purchases.addAll(purchases);
	}
	
	double getTotal() {
		return this.purchases.stream().mapToDouble(p -> p.getTotal()).sum();
	}
	
	Map<Date, Double> getTotalByDate() {
		return this.purchases.stream()
				.collect(Collectors.groupingBy(Purchase::getDate,
						Collectors.summingDouble(Purchase::getTotal)));
	}
}
