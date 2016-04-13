package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import java.util.Stack;


public class CrypterXOR implements Crypter {

	private String myKey;
	private Stack<Character> hilftext = new Stack<Character>();
	private static final char[] klarChar = { '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_' };
	
	
	public CrypterXOR(Key myKey){
		this.myKey = myKey.getKey();
		
	}

	private int getIndex(char key) {
		int defaultIndex = -1;
		for (int i = 0; i < klarChar.length; i++) {
			if (klarChar[i] == key) {
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
		
		int index = getIndex(klartextZeichen);
		int verschiebung = index-1;
		char letterOfKey = myKey.charAt(verschiebung%myKey.length()) ;
		hilftext.push(letterOfKey);
		int index2 = getIndex(letterOfKey);
		return klarChar[index^index2];
	}

	public static void main (String []args) throws CrypterException{
	CrypterXOR test = new CrypterXOR(new Key("TOBIASDDGFDJF"));
	String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String text2 = "";
	String text3 = "";
	for(int i = 0; i < text.length(); i++){
		text2 += test.verschluesseln(text.charAt(i));
	}
	System.out.println(text2);
	
	for(int i = text2.length()-1; i >= 0 ; i--){
		text3 = test.entschluesseln(text2.charAt(i))+text3;
	}
	System.out.println(text3);
}
	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		char letterOfKey = hilftext.pop();		
//		System.out.print("["+letterOfKey);
//		System.out.println(cypherZeichen + "]");
		char holdLetter = klarChar[getIndex(cypherZeichen)^getIndex(letterOfKey)];
		return holdLetter;
	}

}
