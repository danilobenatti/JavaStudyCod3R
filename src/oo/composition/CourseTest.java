package oo.composition;

import static oo.composition.Student.totalHours;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.joinWith;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CourseTest {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance(
				TimeZone.getTimeZone("America/Sao_Paulo"),
				Locale.of("pt", "BR"));
		
		calendar.set(1947, 11, 10);
		Student s1 = new Student("Jane", Date.from(calendar.toInstant()), null);
		s1.setDateOfDeath(Date.from(Instant.parse("2020-11-03T00:00:00Z")));
		
		calendar.set(1988, 8, 24);
		Student s2 = new Student("Mary", Date.from(calendar.toInstant()), null);
		
		calendar.set(1982, 3, 7);
		Student s3 = new Student("Paul", Date.from(calendar.toInstant()), null);
		s3.studentDeathNow();
		
		Course course1 = new Course("Nature science", 50);
		Course course2 = new Course("Financial Mathematics", 60);
		Course course3 = new Course("Portuguese Language", 75);
		
		course1.addStudent(s1);
		course2.addStudents(new ArrayList<>(Arrays.asList(s1, s2, s3)));
		course3.addStudents(new ArrayList<>(Arrays.asList(s2, s3)));
		
		System.out.println(course1.listStudents() + LF);
		System.out.println(course2.listStudents() + LF);
		System.out.println(course3.listStudents() + LF);
		
		System.out.println(String.format("%s(%s) - %d", s1.name,
				s1.ageWithSymbol(), totalHours(s1)));
		System.out.println(new StringBuilder().append(s2.name)
				.append(String.format("(%s)", s2.ageWithSymbol())).append(" - ")
				.append(totalHours(s2)));
		System.out.println(joinWith(" - ",
				String.format("%s(%s)", s3.name, s3.ageWithSymbol()),
				totalHours(s3)));
	}
}
