package beginners_level;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import util.Imc;

public class UseConsole {
	
	static Logger log = Logger.getLogger("");
	
	public static void main(String[] args) {
		
		Person person = new Person();
		
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.useLocale(new Locale("en", "US"));
			log.info("Inform name[Ex. Mary]: ");
			person.setName(scanner.next());
			log.info("Inform gender(M/F)[Ex. F]: ");
			person.setGender(scanner.next().charAt(0));
			log.info("Inform height[Ex. 1.65]: ");
			person.setHeight(scanner.nextFloat());
			log.info("Inform weight[Ex. 68.7}]: ");
			person.setWeight(scanner.nextFloat());
		}
		
		String imc = Imc.imcByGender(person.getWeight(), person.getHeight(),
			person.getGender());
		
		Object[] params = { person, imc };
		log.log(Level.INFO, "Info: {0}; IMC = {1}", params);
		
	}
	
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person {
	
	private String name;
	
	private char gender;
	
	private float weight;
	
	private float height;
	
}
