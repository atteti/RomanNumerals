import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void testConverToIntegerWithSingleMark() {
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
	public void testConverToIntegerWithMoreThanSingleMark() {
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
	public void testConverToIntegerWithTooManyMarkIorXorCorM() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("IIII"));
		assertEquals(-1, numerals.convertToInteger("XXXX"));
		assertEquals(-1, numerals.convertToInteger("CCCC"));
		assertEquals(-1, numerals.convertToInteger("MMMM"));
	}
	
	@Test
	public void testConverToIntegerWithTooManySameMarkVorLorD() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("VV"));
		assertEquals(-1, numerals.convertToInteger("LL"));
		assertEquals(-1, numerals.convertToInteger("DD"));
	}
	
	@Test
	public void testConverToIntegerNextToMarkI() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("IL"));
		assertEquals(-1, numerals.convertToInteger("IC"));
		assertEquals(-1, numerals.convertToInteger("ID"));
		assertEquals(-1, numerals.convertToInteger("IM"));
		assertEquals(4, numerals.convertToInteger("IV"));
		assertEquals(9, numerals.convertToInteger("IX"));
		assertEquals(2, numerals.convertToInteger("II"));
	}
	
	@Test
	public void testConverToIntegerNextToMarkX() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("XD"));
		assertEquals(-1, numerals.convertToInteger("XM"));
		assertEquals(40, numerals.convertToInteger("XL"));
		assertEquals(90, numerals.convertToInteger("XC"));
		assertEquals(20, numerals.convertToInteger("XX"));
		assertEquals(11, numerals.convertToInteger("XI"));
		assertEquals(15, numerals.convertToInteger("XV"));
	}
	
	@Test
	public void testConverToIntegerNextToMarkV() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("VV"));
		assertEquals(-1, numerals.convertToInteger("VX"));
		assertEquals(-1, numerals.convertToInteger("VL"));
		assertEquals(-1, numerals.convertToInteger("VC"));
		assertEquals(-1, numerals.convertToInteger("VD"));
		assertEquals(-1, numerals.convertToInteger("VM"));
		assertEquals(6, numerals.convertToInteger("VI"));
	}
	
	@Test
	public void testConverToIntegerNextToMarkL() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("LL"));
		assertEquals(-1, numerals.convertToInteger("LC"));
		assertEquals(-1, numerals.convertToInteger("LD"));
		assertEquals(-1, numerals.convertToInteger("LM"));
		assertEquals(51, numerals.convertToInteger("LI"));
		assertEquals(55, numerals.convertToInteger("LV"));
		assertEquals(60, numerals.convertToInteger("LX"));
		
	}
	
	@Test
	public void testConverToIntegerNextToMarkD() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("DD"));
		assertEquals(-1, numerals.convertToInteger("DM"));
		assertEquals(501, numerals.convertToInteger("DI"));
		assertEquals(510, numerals.convertToInteger("DX"));
		assertEquals(550, numerals.convertToInteger("DL"));
		assertEquals(600, numerals.convertToInteger("DC"));
		assertEquals(550, numerals.convertToInteger("DL"));
		
	}
	
	@Test
	public void testConverToIntegerWithOtherMarksThanRomanNumbers() {
		RomanNumerals numerals = new RomanNumerals();
		assertEquals(-1, numerals.convertToInteger("ABCD"));
		assertEquals(-1, numerals.convertToInteger("It works fine!"));
	}
}
