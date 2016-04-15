package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterCaesar implements Crypter {
	
	private int key = 1;
	private static final String DEFAULT_TEXT = "letter not allowed";
	private static final char[] LETTERS = 
		{ 
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' 
		};
	

	public CrypterCaesar(Key myKey) throws CrypterException {
		this.key += getIndex(myKey.getKey().charAt(0));
	}
	private int getKey() {
		return key;
	}
	private int getIndex(char letter) throws CrypterException {
		for (int i = 0; i < LETTERS.length; i++) {
			if (LETTERS[i] == letter) {
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