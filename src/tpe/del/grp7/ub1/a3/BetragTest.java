package tpe.del.grp7.ub1.a3;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class BetragTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentException() {
		new Betrag(12345678L, null);
	}
	
	@Test 
	public void testContructorNotThrowsInvalidArgumentException() {
		boolean thrown = false;
		
		try {
			new Betrag(1234L, new Waehrung("Test", "T", 0.1234));
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		
		Assert.assertFalse(thrown);
	}
	
	@Test
	public void testConstructorRightConversionInLong() {
		long expected = 23440;
		long actual = new Betrag(234.4, Waehrungen.franken).getBetrag();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testConstructorRightWaehrungen() {
		Waehrung expected = Waehrungen.dollar;
		Betrag b = new Betrag(2345L, Waehrungen.dollar);
		Waehrung actual = b.getWaehrung();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithPosLong() {
		int expected = 1;
		Betrag b = new Betrag(123456L, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithNegLong() {
		int expected = -1;
		Betrag b = new Betrag(-123456L, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithPosDouble() {
		int expected = 1;
		Betrag b = new Betrag(123456.23, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithNegDouble() {
		int expected = -1;
		Betrag b = new Betrag(-546.23, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithZeroDouble() {
		int expected = 1;
		Betrag b = new Betrag(0.00000, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithZeroLong() {
		int expected = 1;
		Betrag b = new Betrag(0000L, Waehrungen.euro);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
}
