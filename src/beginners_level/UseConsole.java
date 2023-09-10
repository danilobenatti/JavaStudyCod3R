package beginners_level;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Person;
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
			person.setGender(Character.toUpperCase(scanner.next().charAt(0)));
			log.info("Inform height[Ex. 1.65]: ");
			person.setHeight(scanner.nextFloat());
			log.info("Inform weight[Ex. 68.7}]: ");
			person.setWeight(scanner.nextFloat());
			person.setBornDate(LocalDate.now().minusYears(27));
			person.setDeathDate(LocalDate.now());
		}
		
		String imc = Imc.imcByGender(person.getWeight(), person.getHeight(),
			person.getGender());
		
		Object[] params = { person, person.getAgeWithSymbol(), imc };
		log.log(Level.INFO, "Info: {0}; Age: {1}; IMC = {2}", params);
		
	}
	
}
