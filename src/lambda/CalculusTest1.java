package lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CalculusTest1 {
	
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CalculusTest1.class.getName(),
				"./src/util/log4j2.properties");
		
		Calculus calc1 = new Sum();
		Calculus calc2 = new Multiply();
		
		logger.info(calc1.execute(2, 3));
		logger.info(calc2.execute(2, 3));
	}
	
}
