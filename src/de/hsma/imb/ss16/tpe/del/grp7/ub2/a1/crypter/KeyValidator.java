package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * This class validates the strings for the different encodings and will be used
 * by the encodings. If there is an invalid key it throws an exception.
 * 
 * @author Gruppe 7
 *
 */
class KeyValidator {
	/**
	 * The value specifies that there is no minimum of maximum.
	 */
	private static final int KEY_ANY_SIZE_VALUE = -1;
	/**
	 * Specifies that the length for the keys for CaesarCrypter
	 * has a minimum length of one letter.
	 */
	private static final int CAESAR_MIN_LENGTH = 1;
	/**
	 * Specifies that the length for the keys for CaesarCrypter
	 * has a maximum length of one letter.
	 */
	private static final int CAESAR_MAX_LENGTH = 1;
	/**
	 * Specifies that the length for the keys for SubstitutionCrypter
	 * has a minimum length of 26 letters.
	 */
	private static final int SUBSTITUTION_MIN_LENGTH = 26;
	/**
	 * Specifies that the length for the keys for SubstitutionCrypter 
	 * has a maximum length of 26 letters.
	 */
	private static final int SUBSTITUTION_MAX_LENGTH = 26;
	/**
	 * Specifies that the length for the keys for XORCrypter has
	 * a minimum length of one letter.
	 */
	private static final int XOR_MIN_LENGTH = 1;
	/**
	 * Specifies that the length for the keys for XORCrypter has no
	 * maximum.
	 */
	private static final int XOR_MAX_LENGTH = -1;
	/**
	 * This const. specifies whether a key can contain every letter 
	 * only one time.
	 */
	private static final int KEY_MAX_COUNT_DUPLICATE_LETTERS = 1;
	/**
	 * Regular expression to look whether a key contains only 
	 * letters from A-Z in upper case form.
	 */
	private static final String REGEX_LETTER_A_TO_Z = "[A-Z]+";
	/**
	 * Contains the german alphabet letters in upper case form. Special 
	 * letters are not inside.
	 */
	private static final char[] LETTERS = { 
			'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 
			'M', 'N', 'O', 'P', 'Q', 'R', 
			'S', 'T', 'U', 'V', 'W', 'X', 
			'Y', 'Z' };
	/**
	 * Exceptions message if the length of the array is not in the 
	 * right length.
	 */
	private static final String EX_STRING_INVALID_LENGTH = 
			"Size of key is not valid.";
	/**
	 * Exception message if key contains letters which are not 
	 * in the array of {@link KeyValidator#LETTERS LETTERS}.
	 */
	private static final String EX_STRING_INVALID_LETTERS = 
			"Key doesn't contain only upper case letters from A-Z.";
	/**
	 * Exception message if duplicate letters are in the key.
	 */
	private static final String EX_STRING_DUPLICATE_LETTERS = 
			"Key contains duplicate letters.";

	/**
	 * Depending on the CrypterType; this method will call the validating method
	 * for the specified encryption and returns the result.
	 * 
	 * @param key
	 *            key to check
	 * @param type
	 *            CrypterType for which crypter the key will be checked
	 * @return true if the key is valid for the specific crypter
	 * @throws InvalidKeyException
	 *             will be thrown if the key is not valid.
	 */
	static boolean isValid(String key, CrypterType type) throws InvalidKeyException {
		switch (type) {
		case CAESAR:
			return isValidByLengthAndLetters(key, 
					CAESAR_MIN_LENGTH, CAESAR_MAX_LENGTH);
		case SUBSTITUTION:
			return isValidByLengthAndLetters(key, 
					SUBSTITUTION_MIN_LENGTH, SUBSTITUTION_MAX_LENGTH)
					&& !hasDuplicateLetter(key);
		case XOR:
			return isValidByLengthAndLetters(key, 
					XOR_MIN_LENGTH, XOR_MAX_LENGTH);
		}
		return false;
	}

	/**
	 * Checks key for Caesar Crypter. See in method:
	 * {@link KeyValidator#isValidByLengthAndLetters(String, int, int)
	 * isValidByLengthAndLetters}
	 * 
	 * @param key
	 *            key to check
	 * @return true if key is valid for Caesar Crpyter
	 * @throws InvalidKeyException
	 *             will be thrown if key is out of range or if the key contains
	 *             non allowed letters
	 */
	static boolean isValidCaesarKey(String key) 
			throws InvalidKeyException {
		return isValidByLengthAndLetters(key, 
				CAESAR_MIN_LENGTH, CAESAR_MAX_LENGTH);
	}

	/**
	 * Checks key for Substitution Crypter. See in method:
	 * {@link KeyValidator#isValidByLengthAndLetters(String, int, int)
	 * isValidByLengthAndLetters} and
	 * {@link KeyValidator#hasDuplicateLetter(String) hasDuplicateLetter}
	 * 
	 * @param key
	 *            key to check
	 * @return true if key is valid for Caesar Crpyter
	 * @throws InvalidKeyException
	 *             will be thrown if key is out of range, if the key contains
	 *             non allowed letters or has duplicate letters
	 */
	static boolean isValidSubstitutionKey(String key) 
			throws InvalidKeyException {
		if (hasDuplicateLetter(key)) {
			throw new InvalidKeyException(
					EX_STRING_DUPLICATE_LETTERS);
		}
		return isValidByLengthAndLetters(key, 
				SUBSTITUTION_MIN_LENGTH, SUBSTITUTION_MAX_LENGTH);
	}

	/**
	 * Checks key for XOR Crypter. See in method:
	 * {@link KeyValidator#isValidByLengthAndLetters(String, int, int)
	 * isValidByLengthAndLetters}
	 * 
	 * @param key
	 *            key to check
	 * @return true if key is valid for XOR Crpyter
	 * @throws InvalidKeyException
	 *             will be thrown if key is out of range or if the key contains
	 *             non allowed letters
	 */
	static boolean isValidXORKey(String key) 
			throws InvalidKeyException {
		return isValidByLengthAndLetters(key, 
				XOR_MIN_LENGTH, XOR_MAX_LENGTH);
	}

	/**
	 * Checks whether the key is in the specified length of "min" and "max" and
	 * has only upper case letters from A to Z.
	 * 
	 * @param key
	 *            key to check
	 * @param min
	 *            set minimum length
	 * @param max
	 *            set maximum length
	 * @return true if key is valid according the given range and the contained
	 *         letters
	 * @throws InvalidKeyException
	 *             will be thrown if key is out of range or if the key contains
	 *             non allowed letters
	 */
	static boolean isValidByLengthAndLetters(String key, int min, int max) 
			throws InvalidKeyException {
		if (!isLengthCorrect(key, min, max)) {
			throw new InvalidKeyException(EX_STRING_INVALID_LENGTH);
		}
		if (!isLetterAZ(key)) {
			throw new InvalidKeyException(EX_STRING_INVALID_LETTERS);
		}
		return true;
	}

	/**
	 * Checks if the length of the key is between minimum and maximum. If
	 * <code>min = -1</code> or <code>max = -1</code>; you will say that there
	 * is no minimum or maximum.
	 * 
	 * @param key
	 *            key to check
	 * @param min
	 *            set the minimum length
	 * @param max
	 *            set the maximum length
	 * @return true if length is in range; otherwise false
	 */
	static boolean isLengthCorrect(String key, int min, int max) {
		if (hasMinLength(key, min) && hasMaxLength(key, max)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the length of the key is over the minium or the minimum.
	 * 
	 * @param key
	 *            key to check
	 * @param min
	 *            specified minimum length and -1 specifies that there is no
	 *            minimum length
	 * @return true if the key is in the right length
	 */
	static boolean hasMinLength(String key, int min) {
		return hasLength(key, min, false);
	}

	/**
	 * Checks whether the length of the key is under the maximum or the maximum.
	 * 
	 * @param key
	 *            key to check
	 * @param max
	 *            specified maximum length and -1 specifies that there is no
	 *            maximum length
	 * @return true if the key is in the right length
	 */
	static boolean hasMaxLength(String key, int max) {
		return hasLength(key, max, true);
	}

	/**
	 * Checks the length of the key on maximum if <code>isMax = true</code>
	 * otherwise it will check the length on minimum if
	 * <code>isMax = false</code>.
	 * 
	 * @param key
	 *            key to check
	 * @param rangeParam
	 *            length for max or min depending on boolean isMax
	 * @param isMax
	 *            boolean which decide beetween checking for maximum or minimum
	 * @return true if the length is over minimum or under maximum. Otherwise
	 *         false
	 */
	private static boolean hasLength(String key, int rangeParam, 
			boolean isMax) {
		// any size allowed
		if (rangeParam <= KEY_ANY_SIZE_VALUE) {
			return true;
		}
		// maximum
		if (key.length() <= rangeParam && isMax) {
			return true;
		}
		// minimum
		if (key.length() >= rangeParam && !isMax) {
			return true;
		}
		return false;
	}

	/**
	 * Checks whether the key only contains upper case letters from a to z.
	 * 
	 * @param key
	 *            key to check
	 * @return true if its only letters
	 */
	static boolean isLetterAZ(String key) {
		return key.matches(REGEX_LETTER_A_TO_Z);
	}

	/**
	 * Check a key whether it has duplicate letters in it.
	 * 
	 * @param key
	 *            key to check
	 * @return true if it has duplicate letters otherwise false
	 */
	static boolean hasDuplicateLetter(String key) {
		int counter = 0;
		for (char c : key.toCharArray()) {
			// search letter in string
			for (char letter : LETTERS) {
				if (letter == c) {
					counter++;
				}

				// if any letter multiple in string => stop
				if (counter > KEY_MAX_COUNT_DUPLICATE_LETTERS) {
					return true;
				}
			}
			counter = 0;
		}

		return false;
	}
}
