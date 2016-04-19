package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Crypter which can encrypt or decrypt using the substitution method.
 * 
 * @author Gruppe 7
 *
 */
class CrypterSubstitution implements Crypter {
	/**
	 * Contains the given key as char array.
	 */
	private char[] myKey;
	/**
	 * Exception message if the letter is not allowed for this 
	 * encryption.
	 */
	private static final String EX_STRING_INVALID_LETTER = 
			"The given letters is not allowed for the Crypter.";
	/**
	 * Contains all allowed letters for the substitution encryption.
	 */
	private static final char[] LETTERS = {
			'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 
			'M', 'N', 'O', 'P', 'Q', 'R', 
			'S', 'T', 'U', 'V', 'W', 'X', 
			'Y', 'Z' };
	/**
	 * Exception message if no key was set.
	 */
	private static final String EX_STRING_NO_KEY = 
			"Given key is null.";

	/**
	 * Constructs a new CrypterSubstitution and set direclty the key.
	 * 
	 * @param myKey
	 *            key for encryption
	 * @throws CrypterException will be thrown if key is null
	 */
	public CrypterSubstitution(Key myKey) throws CrypterException {
		if(myKey == null) {
			throw new CrypterException(EX_STRING_NO_KEY);
		}
		this.myKey = myKey.getKey().toCharArray();
	}

	/**
	 * Returns the index of a letters in the array. If the array doesn't 
	 * contain the letter, an exception will be thrown.
	 * 
	 * @param letter
	 *            to search in the array
	 * @param array
	 *            array where letter will be searched
	 * @return index of the letter in the array
	 * @throws CrypterException
	 *             will be thrown if array doesn't contain the given letter.
	 */
	int getIndex(char letter, char[] array) throws CrypterException {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == letter) {
				return i;
			}
		}
		throw new CrypterException(EX_STRING_INVALID_LETTER);
	}

	@Override
	public void reset() {
	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		int index = getIndex(klartextZeichen, LETTERS);
		return myKey[index];
	}

	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		int index = getIndex(cypherZeichen, myKey);
		return LETTERS[index];
	}
}
