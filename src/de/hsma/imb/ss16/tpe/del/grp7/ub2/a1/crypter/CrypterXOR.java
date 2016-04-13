package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;


public class CrypterXOR implements Crypter {

	private String myKey;
	private String geheimText;
	private static final char[] klarChar = { '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_' };

	public CrypterXOR(Key myKey) throws CrypterException {
		
		this.myKey = myKey.getKey();
		this.geheimText = createGeheimText(); 
	}
	
	private String createKeyText(String text){
		String keyText = "";
		int i = 0;
		while(i < klarChar.length) {
			for (int j = 0; j < text.length() && i < klarChar.length; j++) {
				keyText = keyText + text.charAt(j);
				i++;
			}
		}
		System.out.println(keyText);
		return keyText;
	}
	
	private String createGeheimText() throws CrypterException{
		String geheim = "";
		for(int i = 1; i < klarChar.length-6; i++ ){
			geheim = geheim + verschluesseln(klarChar[i]);
		}
		System.out.println(geheim);
		return geheim;
		
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
		int index2 = getIndex(myKey.charAt(0)) ;
		return klarChar[index^index2];
	}

	public static void main (String []args) throws CrypterException{
	CrypterXOR test = new CrypterXOR(new Key("QWERTZUIOPASDFGHJKLYXCVBNM"));
	String text = "PUFVQ\\RAFZJ_IHHX[Y_MMUAZW";
	for(int i = 0; i < text.length(); i++){
		System.out.print(test.entschluesseln(text.charAt(i)));
		System.out.println();
	}
	char t;
	System.out.println(t = test.verschluesseln('D'));
	System.out.println(test.entschluesseln(t));
}
	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		
		char zeichen = '0';
		for(int i = 1; i < 27;i++  ){
			if(verschluesseln(klarChar[i]) == cypherZeichen){
				return klarChar[i];
			}
		}
		return zeichen;
		
//		while(zeichen != cypherZeichen){
//			zeichen = geheimText.charAt(++i); 
//		}
//		
//		int index = getIndex(cypherZeichen);
//		System.out.println("index = " + index);
//		int index2 = getIndex(myKey.charAt(i));
//		System.out.println("index2 = " + index2);
//		return klarChar[index^index2];
	}

}
