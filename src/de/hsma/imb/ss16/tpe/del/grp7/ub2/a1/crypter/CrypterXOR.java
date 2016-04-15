package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

public class CrypterXOR implements Crypter {

	private String myKey;
	private static final int MINIMUM = '@';
	private static final int MAXIMUM = '_';
	private int index = 0;

	public CrypterXOR(Key myKey) {
		this.myKey = myKey.getKey();
	}

	@Override
	public void reset() {
		index = 0;
	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		
		if (klartextZeichen < MINIMUM || klartextZeichen > MAXIMUM) {
			throw new CrypterException("letter not allowed");
		}

		int value = 0;
		value = (int) (klartextZeichen - MINIMUM) ^ (myKey.charAt((index) % myKey.length()) - MINIMUM);
		index++;
		return (char) (value + MINIMUM);
	}

	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		return verschluesseln(cypherZeichen);
	}

}
