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
		klar = strcr.entschluesselnStr(botschaft);
		
		// do caesar decrypt
		cr = CrypterFactory.getCrypter(CrypterType.CAESAR, "V");
		strcr.setCr(cr);
		klar = strcr.entschluesselnStr(klar);
		
		// do substitution decrypt
		cr = CrypterFactory.getCrypter(
				CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		strcr.setCr(cr);
		klar = strcr.entschluesselnStr(klar);
		
		assertEquals(expected, klar);
	}
	
	@Test
	public void testAufgabeFReverse() throws CrypterException, InvalidKeyException {
		String expected = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
		String geheim = "";
		String botschaft = "UNDXWIEDERXEINXBLATTXERLEDIGT";
		
		//do substitution encrypt 
		Crypter cr = CrypterFactory.getCrypter(
				CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		StringCrypter strcr = new StringCrypter(cr);
		geheim = strcr.verschluesselnStr(botschaft);
		
		//do caesar encrypt
		cr = CrypterFactory.getCrypter(CrypterType.CAESAR, "V");
		strcr.setCr(cr);
		geheim = strcr.verschluesselnStr(geheim);
		
		//do xor encrypt
		cr = CrypterFactory.getCrypter(CrypterType.XOR, "EINSCHLUESSEL");
		strcr.setCr(cr);
		geheim = strcr.verschluesselnStr(geheim);
		
		assertEquals(expected, geheim);
	}

}
