package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import org.junit.Assert;
import org.junit.Test;

public class CrypterCaesarTest {
	Key myKey = new Key("C");
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'D';
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.verschluesseln('A');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesslen() throws CrypterException{
		char expecteds = 'W';
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.entschluesseln('Z');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln() throws CrypterException{
		CrypterCaesar cr = new CrypterCaesar(myKey);
		cr.verschluesseln('a');
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln() throws CrypterException{
		CrypterCaesar cr = new CrypterCaesar(myKey);
		cr.entschluesseln('0');
	}
}
