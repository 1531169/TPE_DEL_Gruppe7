package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

public class Main {

	public static void main(String[] args) throws CrypterException, InvalidKeyException {
		
		String klar = "";		
		String botschaft = "SS\\RMOUG\\XR\\K_HDPJY]T\\XP\\^B\\_";
		StringCrypter strcr = new StringCrypter(CrypterFactory.getCrypter(CrypterType.XOR, "EINSCHLUESSEL"));
		klar = strcr.entschlüsselnStr(botschaft);
		strcr.setCr(CrypterFactory.getCrypter(CrypterType.CAESAR, "V"));
		klar = strcr.entschlüsselnStr(klar);
		strcr.setCr(CrypterFactory.getCrypter(CrypterType.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ"));
		klar = strcr.entschlüsselnStr(klar);
		System.out.println(klar);
		
	}

}
