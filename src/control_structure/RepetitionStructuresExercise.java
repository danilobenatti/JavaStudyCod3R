package control_structure;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import lombok.Getter;

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
		
		Bet bet = (Bet) showInputDialog(null, "What type of bet?",
			"Betting type", QUESTION_MESSAGE, null,
			new Bet[] { Bet.STANDARD, Bet.PLUS, Bet.PREMIUM }, Bet.STANDARD);
		
		String message = new StringBuilder("Inform ").append(bet.getSize())
			.append(" numbers: ")
			.append("\nWith comma separator, Ex. 10, 8, 50...")
			.append("\nLottery numbers between 1 to 60")
			.append("\nNon-repeating numbers").toString();
		String[] userBet = showInputDialog(null, message, bet.getType(),
			QUESTION_MESSAGE).strip().replace(SPACE, EMPTY).split(",");
		
		int[] numbersUserBet = Stream.of(userBet).mapToInt(Integer::parseInt)
			.distinct().toArray();
		
		System.out.printf("%nBet Standard(%d): %s", numbersOfBet.length,
			Arrays.asList(resultOfBet(numbersOfBet, lotteryNumbers)));
		System.out.printf("%nBet Plus(%d): %s", numbersOfBetPlus.length,
			Arrays.asList(resultOfBet(numbersOfBetPlus, lotteryNumbers)));
		System.out.printf("%nBet Premium(%d): %s", numbersOfBetPremium.length,
			Arrays.asList(resultOfBet(numbersOfBetPremium, lotteryNumbers)));
		System.out.printf("%nBet User(%d): %s", numbersUserBet.length,
			Arrays.asList(resultOfBet(numbersUserBet, lotteryNumbers)));
		
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

@Getter
enum Bet {
	
	STANDARD(1, "Standard", 6), PLUS(2, "Plus", 8), PREMIUM(3, "Permium", 15);
	
	private int code;
	private String type;
	private int size;
	
	Bet(int code, String type, int size) {
		this.code = code;
		this.type = type;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", getType(), getSize());
	}
}
