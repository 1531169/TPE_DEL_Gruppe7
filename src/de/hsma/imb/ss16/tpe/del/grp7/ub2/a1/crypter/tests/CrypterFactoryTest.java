package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.CrypterException;
import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.CrypterFactory;
import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.CrypterType;
import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.InvalidKeyException;

public class CrypterFactoryTest {

	@Test (expected = CrypterException.class)
	public void testCrypterTypeIsNull() throws CrypterException, 
			InvalidKeyException {
		CrypterFactory.getCrypter(null, "");
	}
	
	@Test (expected = InvalidKeyException.class)
	public void testKeyIsNull() throws CrypterException, 
			InvalidKeyException {
		CrypterFactory.getCrypter(CrypterType.CAESAR, null);
	}
	
	@Test (expected = InvalidKeyException.class)
	public void testKeyIsEmpty() throws CrypterException, 
			InvalidKeyException {
		CrypterFactory.getCrypter(CrypterType.CAESAR, "");
	}
}