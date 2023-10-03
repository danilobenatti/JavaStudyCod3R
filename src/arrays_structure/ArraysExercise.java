package arrays_structure;

import java.util.Arrays;

public class ArraysExercise {
	
	public static void main(String[] args) {
		
		double[] grades = new double[4];
		grades[0] = 7.9;
		grades[1] = 8;
		grades[2] = 6.7;
		grades[3] = 9.7;
		
		System.out.println(Arrays.toString(grades));
		
		var total = 0.0;
		for (var grade : grades)
			total += grade;
		System.out.println(total);
		
		System.out.println(total / grades.length);
		
		var sum = 0F;
		for (int i = 0; i < grades.length; i++)
			sum += (float) grades[i];
		System.out.println(sum);
		System.out.println(sum / grades.length);
		
		double[] gradesStudentA = { 6.9, 8.9, 5.5, 10 };
		var totalStudentA = 0F;
		for (int i = 0; i < gradesStudentA.length; i++)
			totalStudentA += gradesStudentA[i];
		System.out.println(totalStudentA);
		System.out.println(totalStudentA / gradesStudentA.length);
		
		var gradesStudentB = new double[] { 5.6, 8, 7.5, 9.2 };
		var totalStudentB = 0F;
		for (int i = 0; i < gradesStudentB.length; i++)
			totalStudentB += gradesStudentB[i];
		System.out.println(totalStudentB);
		System.out.println(totalStudentB / gradesStudentB.length);
		
	}
	
}
