package beginners_level;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import lombok.Getter;

public class CalculatorChallenge {
	
	public static void main(String[] args) {
		
		Operation[] operations = { Operation.ADD, Operation.SUB, Operation.MULT,
			Operation.DIV };
		Operation initValue = Operation.ADD;
		Operation op = (Operation) showInputDialog(null, "Select an operation",
			"Operation", QUESTION_MESSAGE, null, operations, initValue);
		
		var num1 = new BigDecimal(showInputDialog(null, "Info 1º number",
			"1º Number", QUESTION_MESSAGE).replace(',', '.'));
		
		var num2 = new BigDecimal(showInputDialog(null, "Info 2º number",
			"2º Number", QUESTION_MESSAGE).replace(',', '.'));
		
		var result = switch (op.getCode()) {
			case 0 -> num1.add(num2);
			case 1 -> num1.subtract(num2);
			case 2 -> num1.multiply(num2);
			case 3 -> num1.divide(num2);
			default -> BigDecimal.ZERO;
		};
		StringBuilder builder = new StringBuilder().append(op.name()).append(LF)
			.append("Code:").append(SPACE).append(op.getCode()).append(LF)
			.append("Desc:").append(SPACE).append(op.getDescription())
			.append(LF).append("Symbol:").append(SPACE).append(op.getSymbol())
			.append(LF).append(String.format("(%s) %.2f %s %.2f = %.2f",
				op.getDescription(), num1, op.getSymbol(), num2, result));
		System.out.println(builder);
		JOptionPane.showMessageDialog(null, builder);
	}
	
}

@Getter
enum Operation {
	ADD(0, "Addition", '\u002B'), SUB(1, "Subtraction", '\u002D'),
	MULT(2, "Multiplication", '\u00D7'), DIV(3, "Division", '\u00F7');
	
	private int code;
	private String description;
	private char symbol;
	
	private Operation(int code, String description, char symbol) {
		this.code = code;
		this.description = description;
		this.symbol = symbol;
	}
	
	public static Operation toEnum(int code) {
		for (Operation operation : Operation.values()) {
			if (code == operation.getCode()) {
				return operation;
			}
		}
		throw new IllegalArgumentException("Invalid code operation: " + code);
	}
	
	@Override
	public String toString() {
		/**
		 * this.name().toLowerCase();
		 */
		return String.format("%s (%c)", getDescription(), getSymbol());
	}
}
