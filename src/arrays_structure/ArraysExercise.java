package arrays_structure;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ArraysExercise {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ArraysExercise.class.getName(),
				"./src/util/log4j2.properties");
		
		double[] grades = new double[4];
		grades[0] = 7.9;
		grades[1] = 8;
		grades[2] = 6.7;
		grades[3] = 9.7;
		
		logger.info(() -> Arrays.toString(grades));
		
		var total = 0.0;
		for (var grade : grades)
			total += grade;
		logger.info(total);
		
		logger.info(total / grades.length);
		
		var sum = 0F;
		for (int i = 0; i < grades.length; i++)
			sum += (float) grades[i];
		logger.info(sum);
		logger.info(sum / grades.length);
		
		double[] gradesStudentA = { 6.9, 8.9, 5.5, 10 };
		var totalStudentA = 0F;
		for (int i = 0; i < gradesStudentA.length; i++)
			totalStudentA += gradesStudentA[i];
		logger.info(totalStudentA);
		logger.info(totalStudentA / gradesStudentA.length);
		
		var gradesStudentB = new double[] { 5.6, 8, 7.5, 9.2 };
		var totalStudentB = 0F;
		for (int i = 0; i < gradesStudentB.length; i++)
			totalStudentB += gradesStudentB[i];
		logger.info(totalStudentB);
		logger.info(totalStudentB / gradesStudentB.length);
		
	}
	
}
