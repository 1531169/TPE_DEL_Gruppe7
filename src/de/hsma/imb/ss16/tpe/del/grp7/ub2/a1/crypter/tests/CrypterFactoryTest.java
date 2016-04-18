package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.*;

public class CrypterFactoryTest {

	@Test
	public void testGetCrypter() {
		Exception e = null;
		try {
			CrypterFactory.getCrypter(null, "");
		} catch (CrypterException ex) {
			e = ex;
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			e = ex;
		}
		assertTrue(e != null);
	}

}