package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterFactory {

	public static Crypter getCrypter(CrypterType type, String key) throws CrypterException, InvalidKeyException{
		String upcKey = key.toUpperCase();
		Key myKey = new Key(upcKey);
		
		switch(type) {
			case CAESAR: 
				if(KeyValidator.validKeyCaesar(upcKey)){
					return getCaesar(myKey);
				}				
			case SUBSTITUTION:
				if(KeyValidator.validKeySubst(upcKey)){
					return getSubst(myKey);
				}
			case XOR:
				if(KeyValidator.validKeyXOR(upcKey)){
					return getXOR(myKey);
				}				
			default:
				return null;
		}
	}
	
	private static Crypter getCaesar(Key myKey) throws CrypterException{
		return new CrypterCaesar(myKey);
	}
	
	private static Crypter getSubst(Key myKey) throws CrypterException{
		return new CrypterSubstitution(myKey);
	}
	
	private static Crypter getXOR(Key myKey) throws CrypterException{
		return new CrypterXOR(myKey);
	}
	
}
