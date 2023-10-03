package collection_structure;

import static model.Customer.customerBuilder;

import java.util.HashSet;

import model.Customer;

public class HashSetCode {
	
	public static void main(String[] args) {
		
		HashSet<Customer> customers = new HashSet<>();
		
		var cli1 = customerBuilder().id(1).name("Cloe").email("cloe@mail.com")
			.build();
		var cli2 = customerBuilder().id(2).name("Mary").email("mary@pmail.rt")
			.build();
		var cli3 = customerBuilder().id(3).name("Peter").email("retep@kmail.yp")
			.build();
		
		customers.add(cli1);
		customers.add(cli2);
		customers.add(cli3);
		
		Customer customer = customerBuilder().id(1).name("Cloe")
			.email("cloe@mail.com").build();
		
		System.out.println(customers.contains(customer));
	}
	
}
