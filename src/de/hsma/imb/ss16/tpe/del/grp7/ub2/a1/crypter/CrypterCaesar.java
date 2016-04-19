package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Crypter which can encrypt or decrypt using the caesar method.
 * 
 * @author Gruppe 7
 *
 */
class CrypterCaesar implements Crypter {

	/**
	 * Contains the key for the encryption.
	 */
	private int key;
	/**
	 * Is the index of the (first) letter in the given key.
	 */
	private static final int FIRST_INDEX = 0;
	/**
	 * Is the shift to change the indexer for the calculation.
	 */
	private static final int SHIFT_INDEX = 1;
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
	 * Contructs the CrypterCaesar with the given key.
	 * 
	 * @param myKey
	 *            Key which is use the encrypt or decrypt
	 * @throws CrypterException
	 *             will be thrown if the key is not valid
	 */
	public CrypterCaesar(Key myKey) throws CrypterException {
		if(myKey == null) {
			throw new CrypterException(EX_STRING_NO_KEY);
		}
		// create initial index
		this.key = SHIFT_INDEX + getIndex(myKey.getKey().charAt(FIRST_INDEX));
	}
	
	/**
	 * Returns the key of the encryption.
	 * 
	 * @return key 
	 */
	private int getKey() {
		return key;
	}
	
	/**
	 * Returns the index of a letters the {@link CrypterCaesar#LETTERS array}.
	 * If the array doesn't contain the letter, an exception will be thrown.
	 * 
	 * @param letter
	 *            to search in letters array
	 * @return index of the letter in the array
	 * @throws CrypterException
	 *             will be thrown if letters array doesn't contain the given
	 *             letter.
	 */
	private int getIndex(char letter) throws CrypterException {
		for (int i = 0; i < LETTERS.length; i++) {
			if (LETTERS[i] == letter) {
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
		int index = getIndex(klartextZeichen);
		int newIndex = (index + getKey()) % LETTERS.length;
		return LETTERS[newIndex];
	}

	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		int index = getIndex(cypherZeichen);
		int newIndex = (index - getKey());
		if (newIndex < 0) {
			newIndex = newIndex + LETTERS.length;
		}
		return LETTERS[newIndex];
	}
}