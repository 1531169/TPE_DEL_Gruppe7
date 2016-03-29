package tpe.del.grp7.ub1.a3;

import org.junit.*;

/**
 * 
 * @author Gruppe 7
 *
 */

public class KontoTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentExceptionNullString() {
		new Konto(null, Waehrungen.EURO);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentExceptionEmptyString() {
		new Konto("", Waehrungen.EURO);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentExceptionNullWaehrung() {
		new Konto("Loic Cedric Tobias", null);
	}
	
	@Test
	public void testBucheNull() {
		double expected = 0.0;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.EURO);
		konto.buche(null);
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBuchePos() {
		double expected = 100.0;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.EURO);
		konto.buche(new Betrag(10000, Waehrungen.EURO));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBucheNeg() {
		double expected = -100.0;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.EURO);
		konto.buche(new Betrag(-10000, Waehrungen.EURO));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBucheNegSaldoNull() {
		double expected = -8.70;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.EURO);
		konto.buche(new Betrag(-1000, Waehrungen.DOLLAR));
		konto.buche(new Betrag(-100, Waehrungen.FRANKEN));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testGebuehrenSaldoPos() {
		long expected = -1000;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.DOLLAR);
		konto.buche(new Betrag(1000.00, Waehrungen.DOLLAR));
		Assert.assertEquals(expected, konto.gebuehren(10), 0.001);
	}
	
	@Test
	public void testGebuehrenSaldoNeg() {
		long expected = -1000;
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.DOLLAR);
		konto.buche(new Betrag(-1000.00, Waehrungen.DOLLAR));
		Assert.assertEquals(expected, konto.gebuehren(10), 0.001);
	}
	@Test
	public void testToString() {
		Konto konto = new Konto("Loic Cedric Tobias", Waehrungen.DOLLAR);
		konto.buche(new Betrag(100000.00, Waehrungen.YEN));
		konto.buche(new Betrag(-10.00, Waehrungen.EURO));
		konto.gebuehren(10);
		System.out.println(konto.toString());
	}
	
}
