package lambda;

import java.util.function.IntUnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class UnaryOperatorTest {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(UnaryOperatorTest.class.getName(),
				"./src/util/log4j2.properties");
		
		IntUnaryOperator plusTwo = n -> Math.addExact(n, 2);
		
		IntUnaryOperator multiByTwo = n -> Math.multiplyExact(n, 2);
		
		IntUnaryOperator powMath = n -> (int) Math.pow(n, 2);
		
		logger.info(plusTwo.applyAsInt(1));
		logger.info(multiByTwo.applyAsInt(2));
		logger.info(powMath.applyAsInt(3));
		logger.info(plusTwo.andThen(multiByTwo).andThen(powMath).applyAsInt(4));
		logger.info(powMath.compose(multiByTwo).compose(plusTwo).applyAsInt(4));
		
	}
	
}
