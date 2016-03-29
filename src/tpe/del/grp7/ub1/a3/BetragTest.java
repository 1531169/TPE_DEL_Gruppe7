package tpe.del.grp7.ub1.a3;

import org.junit.*;

public class BetragTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentException() {
		new Betrag(12345678, null);
	}
	
	@Test 
	public void testContructorNotThrowsInvalidArgumentException() {
		boolean thrown = false;
		
		try {
			new Betrag(1234, new Waehrung("Test", "T", 0.1234));
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		
		Assert.assertFalse(thrown);
	}
	
	@Test
	public void testConstructorRightConversionInLong() {
		long expected = 23440;
		long actual = new Betrag(234.4, Waehrungen.FRANKEN).getBetrag();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testConstructorRightWaehrungen() {
		Waehrung expected = Waehrungen.DOLLAR;
		Betrag b = new Betrag(2345, Waehrungen.DOLLAR);
		Waehrung actual = b.getWaehrung();
		Assert.assertEquals(expected, actual);
	}
	
	
	
	@Test
	public void testGetVorzeichenWithPosLong() {
		int expected = 1;
		Betrag b = new Betrag(123456, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithNegLong() {
		int expected = -1;
		Betrag b = new Betrag(-123456, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithPosDouble() {
		int expected = 1;
		Betrag b = new Betrag(123456.23, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithNegDouble() {
		int expected = -1;
		Betrag b = new Betrag(-546.23, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithZeroDouble() {
		int expected = 1;
		Betrag b = new Betrag(0.00000, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGetVorzeichenWithZeroLong() {
		int expected = 1;
		Betrag b = new Betrag(0000, Waehrungen.EURO);
		int actual = b.getVorzeichen();
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testAddiereNull() {
		long expected = 1000;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag result = b.addiere(null);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testAddiereMitGleichenWaehrungen() {
		long expected = 1120;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.EURO);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testAddiereMitVerschWaehrungen() {
		long expected = 1094;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.DOLLAR);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testAddiereMitVerschWaehrungen2() {
		long expected = 1002;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.RUBEL);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testAddiereMitGleichenWaehrungenNeg() {
		long expected = 1000;
		Betrag b = new Betrag(1200, Waehrungen.EURO);
		Betrag c = new Betrag(-200, Waehrungen.EURO);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testAddiereMitVerschWaehrungenNeg() {
		long expected = 998;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(-120, Waehrungen.RUBEL);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	
	@Test
	public void testSubtrahiereNull() {
		long expected = 1000;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag result = b.subtrahiere(null);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testSubtrahiereMitGleichenWaehrungen() {
		long expected = 1000;
		Betrag b = new Betrag(1120, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.EURO);
		Betrag result = b.subtrahiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testSubtrahiereMitVerschWaehrungen() {
		long expected = 1094;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.DOLLAR);
		Betrag result = b.addiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testSubtrahiereMitVerschWaehrungen2() {
		long expected = 1000;
		Betrag b = new Betrag(1002, Waehrungen.EURO);
		Betrag c = new Betrag(120, Waehrungen.RUBEL);
		Betrag result = b.subtrahiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testSubtrahiereMitGleichenWaehrungenNeg() {
		long expected = 1200;
		Betrag b = new Betrag(1000, Waehrungen.EURO);
		Betrag c = new Betrag(-200, Waehrungen.EURO);
		Betrag result = b.subtrahiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testSubtrahiereMitVerschWaehrungenNeg() {
		long expected = 1000;
		Betrag b = new Betrag(998, Waehrungen.EURO);
		Betrag c = new Betrag(-120, Waehrungen.RUBEL);
		Betrag result = b.subtrahiere(c);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testMultiplizierePos() {
		long expected = 2500;
		Betrag b = new Betrag(1000, Waehrungen.FRANKEN);
		Betrag result = b.multipliziere(2.5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testMultipliziereNeg() {
		long expected = 5000;
		Betrag b = new Betrag(1000, Waehrungen.FRANKEN);
		Betrag result = b.multipliziere(5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testMultipliziereNull() {
		long expected = 0;
		Betrag b = new Betrag(1000, Waehrungen.FRANKEN);
		Betrag result = b.multipliziere(0);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testProzentPos() {
		long expected = 105;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.prozent(10.5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testProzentNeg() {
		long expected = -105;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.prozent(-10.5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testProzentNull() {
		long expected = 0;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.prozent(0);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testPromillePos() {
		long expected = 10;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.promille(10.5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testPromilleNeg() {
		long expected = -10;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.promille(-10.5);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testPromilleNull() {
		long expected = 0;
		Betrag b = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag result = b.promille(0);
		Assert.assertEquals(expected, result.getBetrag());
	}
	
	@Test
	public void testGetVorkommaPos() {
		long expected = 14356;
		Betrag b = new Betrag(14356.45, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getVorkomma());
	}
	
	@Test
	public void testGetVorkommaNeg() {
		long expected = 14356;
		Betrag b = new Betrag(-14356.50, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getVorkomma());
	}
	
	@Test
	public void testGetVorkommaNull() {
		long expected = 0;
		Betrag b = new Betrag(0.9, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getVorkomma());
	}
	
	@Test
	public void testGetNachkommaPos() {
		int expected = 45;
		Betrag b = new Betrag(14356.45, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getNachkomma());
	}
	
	@Test
	public void testGetNachkommaNeg() {
		int expected = 50;
		Betrag b = new Betrag(-14356.50, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getNachkomma());
	}
	
	@Test
	public void testGetNachkommaNull() {
		long expected = 90;
		Betrag b = new Betrag(0.9, Waehrungen.RUBEL);
		Assert.assertEquals(expected, b.getNachkomma());
	}
	
	@Test
	public void testGetAsDoublePos() {
		double expected = 0.9;
		Betrag b = new Betrag(90, Waehrungen.RUBEL);
		double actual = b.getAsDouble();
		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testGetAsDoubleNeg() {
		double expected = -0.9;
		Betrag b = new Betrag(-90, Waehrungen.RUBEL);
		double actual = b.getAsDouble();
		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testGetAsDoubleNull() {
		double expected = 0;
		Betrag b = new Betrag(0, Waehrungen.RUBEL);
		double actual = b.getAsDouble();
		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void testToStringPos() {
		String expected = "100.00 €";
		Betrag b = new Betrag(10000, Waehrungen.EURO);
		String actual = b.toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testToStringNeg() {
		String expected = "-10.00 €";
		Betrag b = new Betrag(-1000, Waehrungen.EURO);
		String actual = b.toString();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testToStringNull() {
		String expected = "0.00 CHF";
		Betrag b = new Betrag(0, Waehrungen.FRANKEN);
		String actual = b.toString();
		Assert.assertEquals(expected, actual);
	}
}
