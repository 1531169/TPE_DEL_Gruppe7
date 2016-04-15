package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import org.junit.Assert;
import org.junit.Test;

public class CrypterXORTest {
	Key myKey = new Key("C");
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'D';
		CrypterXOR cr = new CrypterXOR(myKey);
		char actuals = cr.verschluesseln('A');
		System.out.println(actuals);
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesslen() throws CrypterException{
		char expecteds = 'W';
		CrypterXOR cr = new CrypterXOR(myKey);
		char actuals = cr.entschluesseln('Z');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln() throws CrypterException{
		CrypterXOR cr = new CrypterXOR(myKey);
		cr.verschluesseln('a');
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln() throws CrypterException{
		CrypterXOR cr = new CrypterXOR(myKey);
		cr.entschluesseln('0');
	}
}
