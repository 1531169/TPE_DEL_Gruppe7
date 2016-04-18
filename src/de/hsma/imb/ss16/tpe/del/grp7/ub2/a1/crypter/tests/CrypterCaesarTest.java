package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.*;

public class CrypterCaesarTest {
	Key myKey = new Key("C");
	Crypter cr;
	
	@Before
	public void initCrypter() throws CrypterException, 
		InvalidKeyException {
		cr = CrypterFactory.getCrypter(CrypterType.CAESAR, myKey.getKey());
	}
	
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'D';
		char actuals = cr.verschluesseln('A');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesseln() throws CrypterException{
		char expecteds = 'W';
		char actuals = cr.entschluesseln('Z');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln() throws CrypterException{
		cr.verschluesseln('a');
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln() throws CrypterException{
		cr.entschluesseln('0');
	}
}
