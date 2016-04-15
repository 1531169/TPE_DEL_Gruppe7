package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * This class validates the strings for the different encodings and will be used
 * by the encodings. If there is an invalid key it throws an exception.
 * 
 * @author Gruppe 7
 *
 */
class KeyValidator {
	private static final int KEY_ANY_SIZE_VALUE = -1;
	private static final int CAESAR_MIN_LENGTH = 1;
	private static final int CAESAR_MAX_LENGTH = 1;
	private static final int SUBSTITUTION_MIN_LENGTH = 26;
	private static final int SUBSTITUTION_MAX_LENGTH = 26;
	private static final int XOR_MIN_LENGTH = 1;
	private static final int XOR_MAX_LENGTH = -1;
	private static final String REGEX_LETTER_A_TO_Z = "[A-Z]+";
	private static final char[] LETTERS = {
			'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 
			'M', 'N', 'O', 'P', 'Q', 'R', 
			'S', 'T', 'U', 'V', 'W', 'X', 
			'Y', 'Z' };
	private static final String EX_STRING_INVALID_LENGTH = 
			"Size of key is not valid.";
	private static final String EX_STRING_INVALID_LETTERS =
			"Key doesn't contain only upper case letters from A-Z.";

	static boolean isValid(String key, CrypterType type) 
			throws InvalidKeyException {
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

	static boolean isValidCaesarKey(String key) 
			throws InvalidKeyException {
		return isValidByLengthAndLetters(key, 
				CAESAR_MIN_LENGTH, CAESAR_MAX_LENGTH);
	}

	static boolean isValidSubstitutionKey(String key) 
			throws InvalidKeyException {
		return isValidByLengthAndLetters(key, 
				SUBSTITUTION_MIN_LENGTH, SUBSTITUTION_MAX_LENGTH) 
				&& !hasDuplicateLetter(key);
	}

	static boolean isValidXORKey(String key) throws InvalidKeyException {
		return isValidByLengthAndLetters(key, 
				XOR_MIN_LENGTH, XOR_MAX_LENGTH);
	}
	
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

	static boolean isLengthCorrect(String key, int min, int max) {
		if (hasMinLength(key, min) && hasMaxLength(key, max)) {
			return true;
		}
		return false;
	}

	static boolean hasMinLength(String key, int min) {
		return hasLength(key, min, false);
	}

	static boolean hasMaxLength(String key, int max) {
		return hasLength(key, max, true);
	}

	private static boolean hasLength(String key, int rangeParam, boolean isMax) {
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
	 *            is to check
	 * @return true if its only letters
	 */
	static boolean isLetterAZ(String key) {
		return key.matches(REGEX_LETTER_A_TO_Z);
	}
	
	static boolean hasDuplicateLetter(String key) {
		int counter = 0;
		for (char c : key.toCharArray()) {
			// search letter in string
			for (char letter : LETTERS) {
				if (letter == c) {
					counter++;
				}
				
				// if any letter multiple in string => stop
				if(counter > 1) {
					return true;
				}
			}
			counter = 0;
		}

		return false;
	}
}
