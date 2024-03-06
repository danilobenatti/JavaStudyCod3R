package streams;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 * 
 * @author danil
 * @since JDK21
 * @see
 */
public class ReduceTest2 {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ReduceTest2.class.getName(),
				"./src/util/log4j2.properties");
		
		ReduceTest2 ex2 = new ReduceTest2();
		
		Student std1 = ex2.new Student("Bia", 'F', 16, 9.5);
		Student std2 = ex2.new Student("Luna", 'F', 18, 9.0);
		Student std3 = ex2.new Student("Ariel", 'F', 18, 7.0);
		Student std4 = ex2.new Student("Gui", 'M', 17, 10.0);
		Student std5 = ex2.new Student("Peter", 'M', 16, 5.0);
		Student std6 = ex2.new Student("Claus", 'M', 18, 6.0);
		Student std7 = ex2.new Student("Ariel", 'F', 16, 6.0);
		Student std8 = ex2.new Student("Joy", 'M', 17, 10.0);
		
		List<Student> list = Arrays.asList(std1, std2, std3, std4, std5, std6,
				std7, std8);
		
		Predicate<Student> studentFemale = p -> p.getGender() == 'F';
		
		Predicate<Student> studentMale = p -> p.getGender() == 'M';
		
		Predicate<Student> approved = s -> s.getScore() >= 7.5;
		
		Function<Student, Double> score = s -> s.getScore();
		
		BinaryOperator<Double> sum = Double::sum;
		
		list.stream().filter(approved).map(score).reduce(sum)
				.ifPresent(s -> log.info(s));
		
		log.info(list.stream().filter(approved).count());
		
		log.info(list.stream().filter(approved)
				.collect(Collectors.averagingDouble(Student::getScore)));
		
		log.info(list.stream().filter(s -> s.getGender() == 'F')
				.collect(Collectors.averagingDouble(Student::getAge)));
		
		log.info(list.stream().filter(s -> s.getGender() == 'M')
				.collect(Collectors.averagingDouble(Student::getAge)));
		
		log.printf(Level.INFO, "Average age of female students: %.2f",
				list.stream().filter(studentFemale).map(Student::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		log.printf(Level.INFO, "Average score of female students: %.2f", list
				.stream().filter(studentFemale).map(Student::getScore)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		log.printf(Level.INFO, "Average age of male students: %.2f",
				list.stream().filter(studentMale).map(Student::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		log.printf(Level.INFO, "Average score of male students: %.2f", list
				.stream().filter(studentMale).map(Student::getScore)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		Map<Character, List<String>> namesByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors
						.mapping(Student::getName, Collectors.toList())));
		namesByGender.entrySet().forEach(s -> log.printf(Level.INFO, "%s", s));
		
		Map<Character, List<Student>> mapStudy = list.stream()
				.collect(groupingBy(Student::getGender, mapping(
						s -> ex2.new Student(s.getName(), s.getAge(),
								s.getScore()),
						collectingAndThen(toList(), x -> x.stream()
								.sorted(Comparator.comparing(Student::getName)
										.thenComparing(Student::getAge)
										.reversed())
								.collect(toList())))));
		mapStudy.entrySet().forEach(s -> log.info(s));
		
		Map<Character, List<String>> namesByGenderSorted = list.stream()
				.collect(groupingBy(Student::getGender,
						mapping(s -> s.getName().concat("(" + s.getAge() + ")"),
								collectingAndThen(toList(), s -> s.stream()
										.sorted().toList().reversed()))));
		namesByGenderSorted.entrySet().forEach(s -> log.info(s));
		
		Map<Character, Double> avgAgeByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingInt(Student::getAge)));
		avgAgeByGender.entrySet().forEach(s -> log.info(s));
		
		Map<Character, Double> avgScoreByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingDouble(Student::getScore)));
		avgScoreByGender.entrySet().forEach(s -> log.info(s));
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
