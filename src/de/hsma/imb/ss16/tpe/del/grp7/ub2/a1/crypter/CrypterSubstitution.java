package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterSubstitution implements Crypter {

	private String myKey;
	private static final String klarText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public CrypterSubstitution(Key myKey) throws CrypterException {

		int festLaenge = 26;
		if (myKey.getKey().length() != festLaenge) {
			throw new CrypterException("Der Schlüssel ist ungeeignet!");
		}
		this.myKey = myKey.getKey();
	}
	int getIndex(char key,String text) {
		int defaultIndex = -1;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == key) {
				return i;
			}
		}
		return defaultIndex;
	}

	@Override
	public void reset() {

	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		return myKey.charAt(getIndex(klartextZeichen,klarText));
	}
	
	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		return klarText.charAt(getIndex(cypherZeichen, myKey));
		
	}

}
