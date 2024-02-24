package lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CalculusTest2 {
	
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CalculusTest2.class.getName(),
				"./src/util/log4j2.properties");
		
		Calculus calc1 = (x, y) -> x + y;
		Calculus calc2 = (x, y) -> x * y;
		
		logger.info(calc1.execute(2, 3));
		logger.info(calc2.execute(2, 3));
		
		logger.info(calc1::text);
		logger.info(Calculus::other);
	}
}
