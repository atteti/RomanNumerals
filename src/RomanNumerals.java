import java.util.List;
import java.util.ArrayList;

public class RomanNumerals {
	
	private static final char I = 'I';
	private static final char V = 'V';
	private static final char X = 'X';
	private static final char L = 'L';
	private static final char C = 'C';
	private static final char D = 'D';
	private static final char M = 'M';
	private static final int MAX_COUNT_I_X_C_M = 3;
	private static final int MAX_COUNT_V_L_D = 1;
	
	public int convertToInteger(final String numbers) throws RomanNumeralsException {
		
		int sum, index, countI, countX, countC, countM, countV, countL, countD;
		sum = index = countI = countX = countC = countM = countV = countL = countD = 0;
					
		while (index < numbers.length()) {
			
			char nextChar = '\n';
			
			if (index + 1 < numbers.length()) {
				nextChar = numbers.charAt(index + 1);
			}
			
			switch (numbers.charAt(index)) {
				case I: 
					countI++;
					sum += sumMarkI(nextChar);
					break;
				case V:
					countV++;
					sum += sumMarkV(nextChar);
					break;
				case X:
					countX++;
					sum += sumMarkX(nextChar);
					break;
				case L:
					countL++;
					sum += sumMarkL(nextChar);
					break;
				case C:
					countC++;
					sum += sumMarkC(nextChar);
					break;
				case D:
					countD++;
					if (nextChar == M) {
						throw new RomanNumeralsException("Invalid argument, next to D");
					} else {
						sum += 500;
					}
					break;
				case M:
					countM++;
					sum += 1000;
					break;
				default:
					throw new RomanNumeralsException("Invalid argument, not a roman number");
			}
		
			index++;
			checkCountsOfRomanNumbers(countI, countX, countC, countM, countV, countL, countD);
		}	
		
		return sum;
	}
	
	private void checkCountsOfRomanNumbers(int I, int X, int C, int M, int V, int L, int D) throws RomanNumeralsException {
		if (I > MAX_COUNT_I_X_C_M || X > MAX_COUNT_I_X_C_M || 
			C > MAX_COUNT_I_X_C_M || M > MAX_COUNT_I_X_C_M || 
			V > MAX_COUNT_V_L_D || L > MAX_COUNT_V_L_D || D > MAX_COUNT_V_L_D) {
			throw new RomanNumeralsException("Invalid argument, too many roman numbers I, X, C, M, V, L or D");
		}
	}
	
	private int sumMarkI(final char character) throws RomanNumeralsException {
		
		int sum = 0;
		
		switch (character) {
			case V:
			case X:
				sum -= 1;
				break;
			case L:
			case C:
			case D:
			case M:
				throw new RomanNumeralsException("Invalid argument, next to I");
			default: 
				sum += 1;
				break;
		}
		
		return sum;
	}
			
	private int sumMarkV(final char character) throws RomanNumeralsException {
		
		int sum = 0;
		
		switch (character) {
			case X:
			case L:
			case C:
			case D:
			case M:
				throw new RomanNumeralsException("Invalid argument, next to V");
			default: 
				sum += 5;
				break;
		}
		
		return sum;
	}
	
	private int sumMarkX(final char character) throws RomanNumeralsException {
		
		int sum = 0;
		
		switch (character) {
			case L:
			case C:
				sum -= 10;
				break;
			case D:
			case M:
				throw new RomanNumeralsException("Invalid argument, next to X");
			default: 
				sum += 10;
				break;
		}
		
		return sum;
	}
	
	private int sumMarkL(final char character) throws RomanNumeralsException {
		
		int sum = 0;
		
		switch (character) {
			case C:
			case D:
			case M:
				throw new RomanNumeralsException("Invalid argument, next to L");	
			default: 
				sum += 50;
				break;
		}
		
		return sum;
	}
	
	private int sumMarkC(final char character) {
		
		int sum = 0;
		
		switch (character) {
			case D:
			case M:
				sum -= 100;
				break;	
			default: 
				sum += 100;
				break;
		}
		
		return sum;
	}
}
			
		
		
