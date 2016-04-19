package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * This class handles the implemented encryptions and is implemented on the
 * factory design pattern.
 * 
 * @author Gruppe 7
 */
public class CrypterFactory {
	/**
	 * Exception message if given key is null. 
	 */
	private static final String EX_STRING_NO_KEY =
			"Given key is null.";
	/**
	 * Exception message if given key is not valid.
	 */
	private static final String EX_STRING_INVALID_KEY = 
			"The given key is not valid.";
	/**
	 * Exception message if the given KeyType is null.
	 */
	private static final String EX_STRING_NO_KEY_TYPE = 
			"The given type is null.";
	
	/**
	 * Creates an crypter object depending on the given crypter type and
	 * validates the key for the different cryptions.
	 * 
	 * @param type
	 *            selects the cryption
	 * @param key
	 *            contains the key for the cryption
	 * @return Crypter which contains the hidden encryption object
	 * @throws CrypterException
	 * @throws InvalidKeyException
	 */
	public static Crypter getCrypter(CrypterType type, String key)
			throws CrypterException, InvalidKeyException {
		if(key == null) {
			throw new InvalidKeyException(EX_STRING_NO_KEY);
		}
		
		if(type == null) {
			throw new CrypterException(EX_STRING_NO_KEY_TYPE);
		}
		
		key = key.toUpperCase();
		// check by type
		if (!KeyValidator.isValid(key, type)) {
			throw new InvalidKeyException(EX_STRING_INVALID_KEY);
		}
		
		Key myKey = new Key(key);
		
		switch (type) {
		case CAESAR:
			return new CrypterCaesar(myKey);
		case SUBSTITUTION:
			return new CrypterSubstitution(myKey);
		case XOR:
			return new CrypterXOR(myKey);
		}
		// type contains no implemented cryption or null
		return null;
	}
}