package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterCaesar implements Crypter {

	private final char[] geheimChar = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private int key = 1;

	CrypterCaesar(Key myKey) {
		// TODO: Validierung
		this.key += getIndex(myKey.getKey().charAt(0));
	}

	private int getKey() {
		return key;
	}

	int getIndex(char key) {
		int index = -1;
		for (int i = 0; i < geheimChar.length; i++) {
			if (geheimChar[i] == key) {
				return index = i;
			}
		}
		return index;
	}

	@Override
	public void reset() {
	}

	@Override
	public char verschluesseln(char klartextZeichen) {
//		char space = ' ';
//		if (klartextZeichen != space) {
			int newIndex = (getIndex(klartextZeichen) + getKey()) % geheimChar.length;
			return geheimChar[newIndex];
//		}
//		return space;

	}

	@Override
	public char entschluesseln(char cypherZeichen) {
		int newIndex = (getIndex(cypherZeichen) - getKey());
		if (newIndex < 0) {
			newIndex = newIndex + geheimChar.length;
		}
		return geheimChar[newIndex];
	}

}
