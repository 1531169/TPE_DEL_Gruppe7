package tpe.del.grp7.ub1.a3;

import org.junit.*;

/**
 * 
 * @author Loic Donkeng
 *
 */

public class KontoTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentException() {
		new Konto(null, Waehrungen.EURO);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentExceptionEmptyString() {
		new Konto("", Waehrungen.EURO);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentException2() {
		new Konto("Ferly Loic", null);
	}
	
	@Test
	public void testBucheNull() {
		double expected = 0.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(null);
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBuchePos() {
		double expected = 100.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(new Betrag(10000, Waehrungen.EURO));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBucheNeg() {
		double expected = -100.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(new Betrag(-10000, Waehrungen.EURO));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBucheNegSaldoNull() {
		double expected = -8.70;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(new Betrag(-1000, Waehrungen.DOLLAR));
		konto.buche(new Betrag(-100, Waehrungen.FRANKEN));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
}
