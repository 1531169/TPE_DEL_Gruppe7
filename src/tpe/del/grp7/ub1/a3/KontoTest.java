package tpe.del.grp7.ub1.a3;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Loic Donkeng
 *
 */

public class KontoTest extends Waehrungen {
	
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
	public void testBucheMitNull() {
		double expected = 0.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(null);
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBuche() {
		double expected = 100.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.EURO);
		konto.buche(new Betrag(10000, Waehrungen.EURO));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}

	@Test
	public void test() {

		Konto tobias = new Konto("Tobias Brückner", FRANKEN);

		for (int i = 0; i < 6000; i += 1000) {
			try {
				tobias.buche(new Betrag(i, FRANKEN));
				tobias.buche(new Betrag(-i, DOLLAR));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		try {
			tobias.gebuehren(50);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			
		}

		System.out.println(tobias.equals(tobias));
		System.out.println(tobias.toString());

		Konto ferly;
		Konto cedric;

		try {
			ferly = new Konto("ferly loic", null);
			cedric = new Konto(null, EURO);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			cedric = new Konto("Redric R.", EURO);
			ferly = new Konto("ferly loic", DOLLAR);
		}

		tobias = new Konto("ferly loic", DOLLAR);

		for (int i = 0; i < 5200; i += 100) {
			try {
				ferly.buche(new Betrag(i, DOLLAR));
				ferly.buche(new Betrag(-i, EURO));
				tobias.buche(new Betrag(i, DOLLAR));
				tobias.buche(new Betrag(-i, EURO));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(tobias.equals(ferly));
		System.out.println(ferly.toString());

		for (int i = 0; i < 5200; i += 100) {
			try {
				cedric.buche(new Betrag(i, EURO));
				cedric.buche(new Betrag(-i, FRANKEN));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(cedric.toString());

	}

}
