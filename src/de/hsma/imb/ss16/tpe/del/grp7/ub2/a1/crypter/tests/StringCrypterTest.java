package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter.*;

public class StringCrypterTest {
	@Test
	public void testAufgabeF() throws CrypterException, InvalidKeyException {
		String expected = "UNDXWIEDERXEINXBLATTXERLEDIGT";
		String klar = "";		
		String botschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
		
		// do xor decrypt
		Crypter cr = CrypterFactory.getCrypter(CrypterType.XOR, "EINSCHLUESSEL");
		StringCrypter strcr = new StringCrypter(cr);
		klar = strcr.entschlüsselnStr(botschaft);
		
		// do caesar decrypt
		cr = CrypterFactory.getCrypter(CrypterType.CAESAR, "V");
		strcr.setCr(cr);
		klar = strcr.entschlüsselnStr(klar);
		
		// do substitution decrypt
		cr = CrypterFactory.getCrypter(
				CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		strcr.setCr(cr);
		klar = strcr.entschlüsselnStr(klar);
		
		assertEquals(expected, klar);
	}

}
