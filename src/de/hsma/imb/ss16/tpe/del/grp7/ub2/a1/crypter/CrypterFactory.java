package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * This class handles the implemented encryptions and is implemented 
 * on the factory design pattern.
 * 
 * @author Gruppe 7
 */
class CrypterFactory {

	/**
	 * Creates an crypter object depending on the given crypter type and
	 * validates the key for the different cryptions.
	 * 
	 * @param type
	 *            selects the cryption
	 * @param key
	 *            contains the key for the cryption
	 * @return crypter object
	 * @throws CrypterException
	 * @throws InvalidKeyException
	 */
	public static Crypter getCrypter(CrypterType type, String key) throws CrypterException, InvalidKeyException {
		String upcKey = key.toUpperCase();
		Key myKey = new Key(upcKey);

		switch (type) {
		case CAESAR:
			if (KeyValidator.validKeyCaesar(upcKey)) {
				return getCaesar(myKey);
			}
			break;
		case SUBSTITUTION:
			if (KeyValidator.validKeySubst(upcKey)) {
				return getSubst(myKey);
			}
			break;
		case XOR:
			if (KeyValidator.validKeyXOR(upcKey)) {
				return getXOR(myKey);
			}
			break;
		}
		// type contains no implemented cryption or null
		return null;
	}

	/**
	 * Creates a crypter object which can encode text by caesar encryption.
	 * 
	 * @param myKey
	 *            will be used to encode
	 * @return crypter object
	 * @throws CrypterException
	 */
	private static Crypter getCaesar(Key myKey) throws CrypterException {
		return new CrypterCaesar(myKey);
	}

	/**
	 * Creates a crypter object which can encode text by substitution
	 * encryption.
	 * 
	 * @param myKey
	 *            will be used to encode
	 * @return crypter object
	 * @throws CrypterException
	 */
	private static Crypter getSubst(Key myKey) throws CrypterException {
		return new CrypterSubstitution(myKey);
	}

	/**
	 * Creates a crypter object which can encode text by xor encryption.
	 * 
	 * @param myKey
	 *            will be used to encode
	 * @return crypter object
	 * @throws CrypterException
	 */
	private static Crypter getXOR(Key myKey) throws CrypterException {
		return new CrypterXOR(myKey);
	}
}