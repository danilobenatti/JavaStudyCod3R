package control_structure;

import model.Customer;
import model.Employed;
import model.Person;

public class StructureSwitch {
	
	public static void main(String[] args) {
		
		Employed e1 = new Employed();
		e1.setName("John");
		Customer c1 = new Customer();
		c1.setName("Peter");
		
		System.out.println(whoIs(e1));
		System.out.println(whoIs(c1));
	}
	
	@SuppressWarnings("preview")
	private static String whoIs(Person person) {
		return switch (person) {
			case Employed e -> new StringBuilder().append("Is Employed: ")
				.append(e.getName()).toString();
			case Customer c -> new StringBuilder().append("Is Customer: ")
				.append(c.getName()).toString();
			default -> "Unknown";
		};
	}
	
}
