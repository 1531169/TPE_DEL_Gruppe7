package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.*;

public class CrypterSubstitutionTest {
	
	Key myKey;
	Crypter cr;
	
	@Before
	public void initCrypter() throws CrypterException, 
		InvalidKeyException {
		myKey = new Key("CYQAXWSEDVRFBTGNZHMUJIKOLP");
		cr = CrypterFactory.getCrypter(CrypterType.SUBSTITUTION, 
				myKey.getKey());
	}
	
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'C';
		char actuals = cr.verschluesseln('A');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesslen() throws CrypterException{
		char expecteds = 'A';
		char actuals = cr.entschluesseln('C');
		Assert.assertEquals(expecteds, actuals);
	}
	
	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln() throws CrypterException{
		cr.verschluesseln('a');
	}
	
	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln() throws CrypterException{
		cr.entschluesseln('a');
	}
}
