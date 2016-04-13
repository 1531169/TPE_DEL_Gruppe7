package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

public class CrypterXOR implements Crypter {

	private String myKey;
	private static final int DIFFERENCEVALUE = '@';
	private int index = 0;

	public CrypterXOR(Key myKey) {
		this.myKey = myKey.getKey();
	}

	@Override
	public void reset() {
		index = 0;
	}

	@Override
	public char verschluesseln(char klartextZeichen) {
		int value = 0;
		value = (int) (klartextZeichen - DIFFERENCEVALUE) ^ (myKey.charAt((index) % myKey.length()) - DIFFERENCEVALUE);
		index++;
		return (char) (value + DIFFERENCEVALUE);
	}

	@Override
	public char entschluesseln(char cypherZeichen) {
		return verschluesseln(cypherZeichen);
	}

}
