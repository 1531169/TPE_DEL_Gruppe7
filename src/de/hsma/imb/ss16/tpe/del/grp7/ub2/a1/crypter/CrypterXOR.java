package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Crypter which can encrypt or decrypt using the XOR method.
 * 
 * @author Gruppe 7
 *
 */
class CrypterXOR implements Crypter {

	/**
	 * Contains the key for the encryption.
	 */
	private String myKey;
	/**
	 * First letter of the allowed letter range in the charset.
	 */
	private static final int MINIMUM = '@';
	/**
	 * Last letter of the allowed letter range in the charset.
	 */
	private static final int MAXIMUM = '_';
	/**
	 * Specifies the index to calculate the index of 
	 * the letter (used for encryption or decryption) in the key.
	 */
	private int index = 0;
	/**
	 * Exception message if no key was set.
	 */
	private static final String EX_STRING_NO_KEY = 
			"Given key is null.";

	/**
	 * Contructs the XORCrypter with the given key.
	 * 
	 * @param myKey
	 *            is used for the encryption/decryption
	 * @throws CrypterException	will be thrown if key is null
	 */
	public CrypterXOR(Key myKey) throws CrypterException {
		if(myKey == null) {
			throw new CrypterException(EX_STRING_NO_KEY);
		}
		this.myKey = myKey.getKey();
	}

	@Override
	public void reset() {
		index = 0;
	}

	@Override
	public char verschluesseln(char klartextZeichen) 
			throws CrypterException {
		if (klartextZeichen < MINIMUM || klartextZeichen > MAXIMUM) {
			throw new CrypterException("letter not allowed");
		}

		int firstOp = klartextZeichen - MINIMUM;
		int secondOp = myKey.charAt(index % myKey.length()) - MINIMUM;
		int value = firstOp ^ secondOp;
		
		index++;
		return (char) (value + MINIMUM);
	}

	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		return verschluesseln(cypherZeichen);
	}

}
