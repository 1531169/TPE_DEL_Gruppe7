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
	public static void main(String[] args) {
		CrypterXOR cr = new CrypterXOR(new Key("TESTTTT"));

		// String test ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// String test = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
		String test = "R@AXM";
		String test2 = "";
		String test3 = "";

		for (int i = 0; i < test.length(); i++) {

			test2 += cr.verschluesseln(test.charAt(i));

		}
		System.out.println(test2);
		cr.reset();
		for (int i = 0; i < test.length(); i++) {
			test3 += cr.entschluesseln(test2.charAt(i));
		}
		System.out.println(test3);
		
	}

}
