package streams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class AverageTest {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(AverageTest.class.getName(),
				"./src/util/log4j2.properties");
		
		Average avg1 = new Average();
		avg1.accept(8.3);
		avg1.accept(6.7);
		
		logger.info(avg1.average());
		
	}
	
}
