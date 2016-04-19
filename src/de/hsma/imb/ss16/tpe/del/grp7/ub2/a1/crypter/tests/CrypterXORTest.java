package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.*;

public class CrypterXORTest {
	Key myKey;
	Crypter cr;
	
	@Before
	public void initCrypter() throws CrypterException, 
		InvalidKeyException {
		myKey = new Key("TPERULES");
		cr = CrypterFactory.getCrypter(CrypterType.XOR, myKey.getKey());
	}
	
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'U';
		char actuals = cr.verschluesseln('A');
		assertEquals(expecteds, actuals);
	}
	
	@Test
	public void testEntschluesslen() throws CrypterException{
		char expecteds = 'N';
		char actuals = cr.entschluesseln('Z');
		assertEquals(expecteds, actuals);
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
