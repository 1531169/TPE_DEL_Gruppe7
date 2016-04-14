package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * This class validates the strings for the different encodings and will
 * be used by the encodings. If there is an invalid key it throws an 
 * exception.
 * 
 * @author Gruppe 7
 *
 */
class KeyValidator {
	
	/**
	 * Contains the complete letters.
	 */
	private static final char[] LETTERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * Validates a key accordings the caesar encoding.
	 * 
	 * @param key
	 *            key to validate
	 * @return true if key is valid otherwise false
	 * @throws InvalidKeyException
	 */
	public static boolean validKeyCaesar(String key) throws InvalidKeyException {
		if (key.length() != 1) {
			throw new InvalidKeyException(
					"Für die Caesar-Verschlüsselung darf der Schlüssel nur aus einem Zeichen bestehen!");
		} else if (!isLetter(key.charAt(0))) {
			throw new InvalidKeyException("Das Zeichen muss ein Buchstabe sein!");
		} else {
			return true;
		}
	}

	public static boolean validKeySubst(String key) throws InvalidKeyException {
		if (key.length() != LETTERS.length) {
			throw new InvalidKeyException("Der Schlüssel muss 26 Zeichen lang sein!");
		}
		if (doubledLetter(key)) {
			throw new InvalidKeyException("Kein Buchstabe darf doppelt vorkommen");
		}
		return true;
	}

	public static boolean validKeyXOR(String key) throws InvalidKeyException {
		// Implementation not done yet
		return true;
	}

	private static boolean isLetter(char c) {
		for (char i : LETTERS) {
			if (i == c) {
				return true;
			}
		}
		return false;
	}

	private static boolean doubledLetter(String text) {
		char[] checker = LETTERS.clone();
		char c;
		int counter = 0;
		boolean checked = false;

		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			for (char x : checker) {
				if (x == c) {
					checker[counter] = ' ';
					checked = true;
				}
				counter++;
			}
			if (!checked) {
				return true;
			}
			checked = false;
			counter = 0;
		}

		return false;
	}
	
	/*
	 * ----------------------------------------
	 * Neue Implementierung
	 * ----------------------------------------
	 */
	private final static String REGEX_A_TO_Z = "[a-zA-Z]+";
	private KeySettings settings;
	
	public KeyValidator() {
		
	}
	
	public KeyValidator(KeySettings settings) {
		this.settings = settings;
	}
	
	public void setSettings(KeySettings settings) {
		this.settings = settings;
	}
	
	public KeySettings getSettings() {
		return this.settings;
	}
	
	boolean hastCorrectLength(String key) {
		if(hasMinLength(key) && hasMaxLength(key)) {
			return true;
		}
		return false;
	}
	
	boolean hasMaxLength(String key) {
		if(!getSettings().isMaxLengthRequired()) {
			return true;
		} else {
			if(key.length() <= getSettings().getMaxLength()) {
				return true;
			}
			return false;
		}
	}
	
	boolean hasMinLength(String key) {
		if(!getSettings().isMinLengthRequired()) {
			return true;
		} else {
			if(key.length() >= getSettings().getMinLength()) {
				return true;
			}
			return false;
		}
	}
	
	boolean isLetterAZ(String key) {
		return key.matches(settings.getRegexAllowedLetters());
	}
}
