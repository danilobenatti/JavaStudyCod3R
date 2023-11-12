package oo.composition.challenge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Purchase {
	
	Date date;
	
	List<Item> items = new ArrayList<>();
	
	Purchase(Date date) {
		this.date = date;
	}
	
	Date getDate() {
		return this.date;
	}
	
	void addItem(Product product, int quantity) {
		this.items.add(new Item(product, quantity));
	}
	
	void addItem(String description, double price, int quantity) {
		this.items.add(new Item(new Product(description, price), quantity));
	}
	
	void addItems(List<Item> items) {
		this.items.addAll(items);
	}
	
	double getTotal() {
		return this.items.stream().mapToDouble(Item::getSubTotal).sum();
	}
}
