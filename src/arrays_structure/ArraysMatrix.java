package arrays_structure;

import static java.lang.Float.parseFloat;

import java.util.Locale;
import java.util.Scanner;

public class ArraysMatrix {
	
	private static final Locale LOCALE = Locale.of("pt", "BR");
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		float[][] students;
		/**
		 * float[][] students = { { Students }, { Grades } };
		 */
		
		try (Scanner sc = new Scanner(System.in).useLocale(LOCALE)) {
			System.out.println("How many students?");
			int numberOfStudents = Integer.parseInt(sc.next().strip());
			System.out.println("How many grades per student?");
			int numberOfGrades = Integer.parseInt(sc.next().strip());
			
			students = new float[numberOfStudents][numberOfGrades];
			
			int i = 0;
			for (float[] student : students) {
				System.out.printf("Student %d%n", i + 1);
				int j = 0;
				for (float grade : student) {
					System.out.printf("Grade %d: ", j + 1);
					students[i][j] = parseFloat(sc.next().replace(',', '.'));
					j++;
				}
				i++;
			}
		}
		
		int i = 0;
		var avgTotal = 0F;
		for (float[] student : students) {
			int j = 0;
			var sum = 0F;
			for (float grade : student) {
				sum += grade;
				j++;
			}
			var avgByStudent = (j > 0) ? sum / j : sum;
			avgTotal += avgByStudent;
			System.out.printf("Student %d average = %.1f%n", i + 1,
				avgByStudent);
			i++;
		}
		
		System.out.printf("Geral average = %.1f", avgTotal / ((i > 0) ? i : 1));
		
	}
	
}
