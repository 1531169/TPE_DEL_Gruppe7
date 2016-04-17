package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

public class Main {
	
	public static void main(String[] args) throws CrypterException, InvalidKeyException {
		String klar = "";		
		String botschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
		
		// do xor decrypt
		Crypter cr = CrypterFactory.getCrypter(CrypterType.XOR, "EINSCHLUESSEL");
		StringCrypter strcr = new StringCrypter(cr);
		klar = strcr.entschl�sselnStr(botschaft);
		
		// do caesar decrypt
		cr = CrypterFactory.getCrypter(CrypterType.CAESAR, "V");
		strcr.setCr(cr);
		klar = strcr.entschl�sselnStr(klar);
		
		// do substitution decrypt
		cr = CrypterFactory.getCrypter(
				CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		strcr.setCr(cr);
		klar = strcr.entschl�sselnStr(klar);
		
		// show end result
		System.out.println(klar);
	}
}
