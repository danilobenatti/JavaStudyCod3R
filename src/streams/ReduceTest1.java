package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ReduceTest1 {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ReduceTest1.class.getName(),
				"./src/util/log4j2.properties");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		BinaryOperator<Integer> sum = (x, n) -> x + n;
		
		DoubleBinaryOperator multi = (x, n) -> x * n;
		
		DoubleBinaryOperator div = (x, n) -> x / n;
		
		Optional<Integer> total = numbers.parallelStream().reduce(sum);
		logger.info(total.isPresent() ? total.get() : 0);
		
		logger.info(numbers.stream().reduce(100, sum));
		logger.info(numbers.parallelStream().reduce(100, sum));
		
		numbers.stream().filter(n -> n % 2 == 0).reduce(sum)
				.ifPresent(n -> logger.info(n));
		
		numbers.stream().filter(n -> n % 2 != 0).reduce(sum)
				.ifPresent(n -> logger.info(n));
		
		numbers.stream().mapToDouble(Number::doubleValue).filter(n -> n <= 2)
				.reduce(div).ifPresent(n -> logger.info(n));
		
		numbers.stream().mapToDouble(Number::doubleValue).filter(n -> n >= 2)
				.reduce(multi).ifPresent(n -> logger.info(n));
		
	}
	
}
