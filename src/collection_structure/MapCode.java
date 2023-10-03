package collection_structure;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class MapCode {
	
	public static void main(String[] args) {
		
		Customer cli1 = Customer.customerBuilder().id(10).name("Paul").build();
		Customer cli2 = Customer.customerBuilder().id(20).name("John").build();
		Customer cli3 = Customer.customerBuilder().id(30).name("Cloe")
			.bornDate(LocalDate.now().minusYears(35)).build();
		cli3.killPerson();
		
		Map<Integer, Customer> map = new HashMap<>();
		
		map.put(1, cli1);
		map.put(2, cli2);
		map.put(3, cli3);
		
		map.forEach((k, v) -> System.out.println(k + "=" + v));
		
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println(map.toString());
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		
		System.out.println(map.get(1));
		System.out.println(map.containsKey(2));
		System.out.println(map.containsValue(cli3));
		
		for (int key : map.keySet()) {
			System.out.println(key);
		}
		
		for (Customer cutomer : map.values()) {
			System.out.println(cutomer);
		}
		
		for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Customer value = entry.getValue();
			System.out.println(key + " - " + value);
			
		}
		
	}
	
}
