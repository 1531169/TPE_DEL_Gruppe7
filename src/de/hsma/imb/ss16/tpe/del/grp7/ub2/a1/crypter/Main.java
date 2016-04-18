package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Starts the programm to encrypt the message in the excercicse.
 * 
 * @author Gruppe 7
 *
 */
public class Main {
	
	public static void main(String[] args) throws CrypterException, InvalidKeyException {
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
		
		// show end result
		System.out.println(klar);
	}
}
