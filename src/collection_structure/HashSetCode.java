package collection_structure;

import static model.Customer.customerBuilder;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Customer;

public class HashSetCode {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(HashSetCode.class.getName(),
				"./src/util/log4j2.properties");
		
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
		
		logger.info(customers.contains(customer));
	}
	
}
