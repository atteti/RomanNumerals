import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestRomanNumerals {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testConverToIntegerWithSingleMark() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(1, numerals.convertToInteger("I"));
		assertEquals(5, numerals.convertToInteger("V"));
		assertEquals(10, numerals.convertToInteger("X"));
		assertEquals(50, numerals.convertToInteger("L"));
		assertEquals(100, numerals.convertToInteger("C"));
		assertEquals(500, numerals.convertToInteger("D"));
		assertEquals(1000, numerals.convertToInteger("M"));
	}
	
	@Test
	public void testConverToIntegerWithMoreThanSingleMark() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(3, numerals.convertToInteger("III"));
		assertEquals(4, numerals.convertToInteger("IV"));
		assertEquals(6, numerals.convertToInteger("VI"));
		assertEquals(13, numerals.convertToInteger("XIII"));
		assertEquals(60, numerals.convertToInteger("LX"));
		assertEquals(80, numerals.convertToInteger("LXXX"));
		assertEquals(90, numerals.convertToInteger("XC"));
		assertEquals(110, numerals.convertToInteger("CX"));
		assertEquals(600, numerals.convertToInteger("DC"));
		assertEquals(704, numerals.convertToInteger("DCCIV"));
		assertEquals(1984, numerals.convertToInteger("MCMLXXXIV"));
		assertEquals(2014, numerals.convertToInteger("MMXIV"));
		assertEquals(3199, numerals.convertToInteger("MMMCXCIX"));
	}
	
	@Test
	public void testConverToIntegerWithTooManyI() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("IIII");
	}
	
	@Test
	public void testConverToIntegerWithTooManyX() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("XXXX");
	}
	
	@Test
	public void testConverToIntegerWithTooManyC() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("CCCC");
	}
	
	@Test
	public void testConverToIntegerWithTooManyM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("MMMM");
	}
	
	@Test
	public void testConverToIntegerWithTooManyV() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("VV");
	}
	
	@Test
	public void testConverToIntegerWithTooManyL() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("LL");
	}
	
	@Test
	public void testConverToIntegerWithTooManyD() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("too many roman numbers I, X, C, M, V, L or D");
		numerals.convertToInteger("DD");
	}
	
	@Test
	public void testConverToIntegerNextToMarkI() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(4, numerals.convertToInteger("IV"));
		assertEquals(9, numerals.convertToInteger("IX"));
		assertEquals(2, numerals.convertToInteger("II"));
	}
	
	@Test
	public void testConverToIntegerIL() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to I");
		numerals.convertToInteger("IL");
	}
	
	@Test
	public void testConverToIntegerIC() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to I");
		numerals.convertToInteger("IC");
	}
	
	@Test
	public void testConverToIntegerID() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to I");
		numerals.convertToInteger("ID");
	}
	
	@Test
	public void testConverToIntegerIM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to I");
		numerals.convertToInteger("IM");
	}
	
	@Test
	public void testConverToIntegerNextToMarkX() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(40, numerals.convertToInteger("XL"));
		assertEquals(90, numerals.convertToInteger("XC"));
		assertEquals(20, numerals.convertToInteger("XX"));
		assertEquals(11, numerals.convertToInteger("XI"));
		assertEquals(15, numerals.convertToInteger("XV"));
	}
	
	@Test
	public void testConverToIntegerXD() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to X");
		numerals.convertToInteger("XD");
	}
	
	@Test
	public void testConverToIntegerXM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to X");
		numerals.convertToInteger("XM");
	}
	
	@Test
	public void testConverToIntegerNextToMarkV() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(6, numerals.convertToInteger("VI"));
	}
	
	@Test
	public void testConverToIntegerVX() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to V");
		numerals.convertToInteger("VX");
	}
	
	@Test
	public void testConverToIntegerVL() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to V");
		numerals.convertToInteger("VL");
	}
	
	@Test
	public void testConverToIntegerVC() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to V");
		numerals.convertToInteger("VC");
	}
	
	@Test
	public void testConverToIntegerVD() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to V");
		numerals.convertToInteger("VD");
	}
	
	@Test
	public void testConverToIntegerVM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to V");
		numerals.convertToInteger("VM");
	}
	
	@Test
	public void testConverToIntegerNextToMarkL() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(51, numerals.convertToInteger("LI"));
		assertEquals(55, numerals.convertToInteger("LV"));
		assertEquals(60, numerals.convertToInteger("LX"));
	}
	
	@Test
	public void testConverToIntegerLC() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to L");
		numerals.convertToInteger("LC");
	}
	
	@Test
	public void testConverToIntegerLD() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to L");
		numerals.convertToInteger("LD");
	}
	
	@Test
	public void testConverToIntegerLM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to L");
		numerals.convertToInteger("LM");
	}
	
	@Test
	public void testConverToIntegerNextToMarkD() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(501, numerals.convertToInteger("DI"));
		assertEquals(510, numerals.convertToInteger("DX"));
		assertEquals(550, numerals.convertToInteger("DL"));
		assertEquals(600, numerals.convertToInteger("DC"));
		assertEquals(550, numerals.convertToInteger("DL"));
	}
	
	@Test
	public void testConverToIntegerDM() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, next to D");
		numerals.convertToInteger("DM");
	}
	
	@Test
	public void testConverToIntegerWithOtherMarksThanRomanNumbers() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, not a roman number");
		numerals.convertToInteger("ABCD");
	}
	
	@Test
	public void testConverToIntegerWithOtherMarksThanRomanNumbers2() throws RomanNumeralsException {
		RomanNumerals numerals = new RomanNumerals();
		thrown.expect(RomanNumeralsException.class);
	    thrown.expectMessage("Invalid argument, not a roman number");
		numerals.convertToInteger("It works fine!");
	}
}
