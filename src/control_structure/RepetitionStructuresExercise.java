package control_structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RepetitionStructuresExercise {
	
	public static void main(String[] args) {
		
		int[] numbersOfBet = new int[] { 34, 1, 50, 10, 57, 15 };
		int[] numbersOfBetPlus = new int[] { 35, 2, 51, 15, 60, 25, 8, 45 };
		int[] numbersOfBetPremium = new int[] { 34, 1, 50, 10, 25, 15, 18, 5,
			52, 8, 20, 30, 28, 45, 33 };
		
		int[] lotteryNumbers = sortition(new Random(), 1, 60, 6);
		
		for (int number : lotteryNumbers) {
			System.out.printf("%d  ", number);
		}
		
		System.out.printf("%nBet Standard(%d): %s", numbersOfBet.length,
			Arrays.asList(resultOfBet(numbersOfBet, lotteryNumbers)));
		System.out.printf("%nBet Plus(%d): %s", numbersOfBetPlus.length,
			Arrays.asList(resultOfBet(numbersOfBetPlus, lotteryNumbers)));
		System.out.printf("%nBet Premium(%d): %s", numbersOfBetPremium.length,
			Arrays.asList(resultOfBet(numbersOfBetPremium, lotteryNumbers)));
		
	}
	
	public static Map<Integer, Boolean> resultOfBet(int[] numbersOfBet,
		int[] lotteryNumbers) {
		Map<Integer, Boolean> result = new HashMap<>();
		for (int j : lotteryNumbers) {
			for (int k : numbersOfBet) {
				if (k == j) {
					result.put(j, true);
					break;
				} else {
					result.put(j, false);
				}
			}
		}
		return result;
	}
	
	public static int[] sortition(Random random, int min, int max, int size) {
		int[] lotteryNumbers = new int[size];
		int i = 0;
		do {
			int number = random.nextInt(min, max + 1);
			if (!checkIfExist(number, lotteryNumbers)) {
				lotteryNumbers[i] = number;
				i++;
			}
		} while (i < lotteryNumbers.length);
		return lotteryNumbers;
	}
	
	public static boolean checkIfExist(int number, int[] numbers) {
		for (int i : numbers)
			if (i == number)
				return true;
		return false;
	}
	
}
