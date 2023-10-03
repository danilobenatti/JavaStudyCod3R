package beginners_level;

import static model.Customer.customerBuilder;

import java.time.LocalDate;

import model.Customer;

public class EqualsHashCode {
	
	public static void main(String[] args) {
		
		var c1 = customerBuilder().id(1).name("John W.").email("john@mail.com")
			.bornDate(LocalDate.now().minusYears(47)).deathDate(LocalDate.now())
			.build();
		
		var c2 = c1;
		c2.setName("John Wick");
		c2.setEmail("jhon99@mail.com");
		c2.setGoodPayer(false);
		
		var c3 = new Customer();
		c3.setId(1);
		c3.setName("Jhon Wick");
		c3.setEmail("jhon@email.com");
		
		System.out.printf("1) %s%n%n", c1);
		System.out.printf("2) %s%n%n", c2);
		System.out.printf("3) %s%n%n", c3);
		
		System.out.printf("c1 == c2? %s%n", c1 == c2);
		System.out.printf("c1 equals c2? %s%n%n", c1.equals(c2));
		
		System.out.printf("c3 == c1? %s%n", c3 == c1);
		System.out.printf("c3 equals 1? %s%n%n", c3.equals(c1));
		
		System.out.printf("c3 == c2? %s%n", c3 == c2);
		System.out.printf("c3 equals c2? %s%n%n", c3.equals(c2));
	}
	
}
