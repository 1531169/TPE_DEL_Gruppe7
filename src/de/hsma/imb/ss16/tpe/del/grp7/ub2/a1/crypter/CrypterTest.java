package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import org.junit.Assert;
import org.junit.Test;

public class CrypterTest {
	@Test
	public void testVerschluesseln(Crypter Crypt, Key myKey, 
			char expecteds, char letter) throws CrypterException {
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		char actuals = cr.verschluesseln(letter);
		Assert.assertEquals(expecteds, actuals);
	}

	@Test
	public void testEntschluesslen(Crypter Crypt, Key myKey, 
			char expecteds, char letter) throws CrypterException {
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		char actuals = cr.entschluesseln(letter);
		Assert.assertEquals(expecteds, actuals);
	}

	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln(Crypter Crypt, 
			Key myKey, char letter) throws CrypterException {
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		cr.verschluesseln(letter);
	}

	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln(Crypter Crypt, 
			Key myKey, char letter) throws CrypterException {
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		cr.entschluesseln(letter);
	}
}
