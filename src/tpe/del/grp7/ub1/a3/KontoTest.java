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
		new Konto(null, Waehrungen.euro);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentExceptionEmptyString() {
		new Konto("", Waehrungen.euro);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorThrowsInvalidArgumentException2() {
		new Konto("Ferly Loic", null);
	}
	
	@Test
	public void testBucheMitNull() {
		double expected = 0.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.euro);
		konto.buche(null);
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}
	
	@Test
	public void testBuche() {
		double expected = 100.0;
		Konto konto = new Konto("Ferly Loic", Waehrungen.euro);
		konto.buche(new Betrag(10000, Waehrungen.euro));
		Assert.assertEquals(expected, konto.saldo(), 0.001);
	}

	@Test
	public void test() {

		Konto tobias = new Konto("Tobias Brückner", franken);

		for (int i = 0; i < 6000; i += 1000) {
			try {
				tobias.buche(new Betrag(i, franken));
				tobias.buche(new Betrag(-i, dollar));
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
			cedric = new Konto(null, euro);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			cedric = new Konto("Redric R.", euro);
			ferly = new Konto("ferly loic", dollar);
		}

		tobias = new Konto("ferly loic", dollar);

		for (int i = 0; i < 5200; i += 100) {
			try {
				ferly.buche(new Betrag(i, dollar));
				ferly.buche(new Betrag(-i, euro));
				tobias.buche(new Betrag(i, dollar));
				tobias.buche(new Betrag(-i, euro));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(tobias.equals(ferly));
		System.out.println(ferly.toString());

		for (int i = 0; i < 5200; i += 100) {
			try {
				cedric.buche(new Betrag(i, euro));
				cedric.buche(new Betrag(-i, franken));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(cedric.toString());

	}

}
