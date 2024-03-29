package exception.custom_exception_b;

import static exception.custom_exception_b.ValidationB.validStudent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;

public class ValidationTestB {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ValidationTestB.class.getName(),
				"./src/util/log4j2.properties");
		try {
			validStudent(new Student("   ", 'F', 16, 9.5));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		try {
			validStudent(new Student("Test", 'F', 16, -9.5));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		try {
			validStudent(new Student("Test", 'F', 16, 11));
		} catch (EmptyStringException | OutRangeNumberException
				| IllegalArgumentException e) {
			log.error(e.getMessage());
		}
		
		log.info("Validation it's working!");
	}
	
}
