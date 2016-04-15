package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import org.junit.Assert;
import org.junit.Test;

public class CrypterSubstitutionTest {
	
	Key myKey = new Key("CYQAXWSEDVRFBTGNZHMUJIKOLP");
	@Test
	public void testVerschluesseln() throws CrypterException{
		char expecteds = 'C';
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		char actuals = cr.verschluesseln('A');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesslen() throws CrypterException{
		char expecteds = 'A';
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		char actuals = cr.entschluesseln('C');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharVerschluesseln() throws CrypterException{
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		cr.verschluesseln('a');
	}
	@Test(expected = CrypterException.class)
	public void notAllowedCharEntschluesseln() throws CrypterException{
		CrypterSubstitution cr = new CrypterSubstitution(myKey);
		cr.entschluesseln('a');
	}
}
