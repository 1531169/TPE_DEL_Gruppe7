package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterSubstitution implements Crypter {

	private char[] myKey;
	private static final String DEFAULT_TEXT = "letter not allowed";
	private static final char[] LETTERS = 
		{ 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' 
		};

	public CrypterSubstitution(Key myKey) throws CrypterException {
		this.myKey = myKey.getKey().toCharArray();
	}
	int getIndex(char letter, char[] array) throws CrypterException {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == letter) {
				return i;
			}
		}
		throw new CrypterException(DEFAULT_TEXT);
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
