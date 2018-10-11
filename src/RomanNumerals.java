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
		
	
	
	public int convertToInteger(final String numbers) {
		
		int sum = 0;
		int index = 0;
		int countI = 0;
		int countX = 0;
		int countC = 0;
		int countM = 0;
		int countV = 0;
		int countL = 0;
		int countD = 0;
				
		while (index < numbers.length()) {
			
			char nextChar = '\n';
			
			if (index + 1 < numbers.length()) {
				nextChar = numbers.charAt(index + 1);
			}
			
			switch (numbers.charAt(index)) {
				case I: 
					countI++;
					if (sumMarkI(nextChar) == 0) {
						return -1;
					} else {
						sum += sumMarkI(nextChar);
					}
					break;
				case V:
					countV++;
					if (sumMarkV(nextChar) == 0) {
						return -1;
					} else {
						sum += sumMarkV(nextChar);
					}
					break;
				case X:
					countX++;
					if (sumMarkX(nextChar) == 0) {
						return -1;
					} else {
						sum += sumMarkX(nextChar);
					}
					break;
				case L:
					countL++;
					if (sumMarkL(nextChar) == 0) {
						return -1;
					} else {
						sum += sumMarkL(nextChar);
					}
					break;
				case C:
					countC++;
					if (sumMarkC(nextChar) == 0) {
						return -1;
					} else {
						sum += sumMarkC(nextChar);
					}
					break;
				case D:
					countD++;
					if (nextChar != '\n' && 
						nextChar == M) {
						return -1;
					} else {
						sum += 500;
					}
					break;
				case M:
					countM++;
					sum += 1000;
					break;
				default:
					return -1;
			}
		
			index++;
		}	
			
		if (countI > 3 || countX > 3 || countC > 3 || countM > 3) {
			return -1;
		}
		
		if (countV > 1 || countL > 1 || countD > 1) {
			return -1;
		}
		
		return sum;
	}
	
	private int sumMarkI(final char character) {
		
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
				return 0;
				
			default: 
				sum += 1;
				break;
		}
		
		return sum;
	}
			
	private int sumMarkV(final char character) {
		
		int sum = 0;
		
		switch (character) {
			case X:
			case L:
			case C:
			case D:
			case M:
				return 0;
			default: 
				sum += 5;
				break;
		}
		
		return sum;
	}
	
	private int sumMarkX(final char character) {
		
		int sum = 0;
		
		switch (character) {
			case L:
			case C:
				sum -= 10;
				break;
			case D:
			case M:
				return 0;
			default: 
				sum += 10;
				break;
		}
		
		return sum;
	}
	
	private int sumMarkL(final char character) {
		
		int sum = 0;
		
		switch (character) {
			case C:
			case D:
			case M:
				return 0;	
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
			
		
		
