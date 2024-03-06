package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ReduceTest3 {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ReduceTest3.class.getName(),
				"./src/util/log4j2.properties");
		
		ReduceTest3 ex3 = new ReduceTest3();
		
		Student std1 = ex3.new Student("Bia", 'F', 16, 9.5);
		Student std2 = ex3.new Student("Luna", 'F', 18, 9.0);
		Student std3 = ex3.new Student("Ariel", 'F', 18, 7.0);
		Student std4 = ex3.new Student("Gui", 'M', 17, 10.0);
		Student std5 = ex3.new Student("Peter", 'M', 16, 5.0);
		Student std6 = ex3.new Student("Claus", 'M', 18, 6.0);
		Student std7 = ex3.new Student("Ariel", 'F', 16, 6.0);
		Student std8 = ex3.new Student("Joy", 'M', 17, 10.0);
		
		List<Student> list = Arrays.asList(std1, std2, std3, std4, std5, std6,
				std7, std8);
		
		Predicate<Student> approved = s -> s.getScore() >= 7.5;
		
		Function<Student, Double> score = s -> s.getScore();
		
		BiFunction<Average, Double, Average> calculeAvg = (average, value) -> {
			average.accept(value);
			return average;
		};
		
		BinaryOperator<Average> combine = Average::combine;
		
		Average result = list.stream().filter(approved).map(score)
				.reduce(new Average(), calculeAvg, combine);
		log.info(result::average);
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	public class Student {
		private String name;
		private char gender;
		private int age;
		private double score;
		
		public Student(String name, int age, double score) {
			this.name = name;
			this.age = age;
			this.score = score;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Student [");
			builder.append(name);
			builder.append(", ");
			builder.append(age);
			builder.append(", ");
			builder.append(score);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
