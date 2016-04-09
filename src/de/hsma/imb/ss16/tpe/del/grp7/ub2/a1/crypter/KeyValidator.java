package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class KeyValidator {
	
	private static final char[] LETTERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	public static boolean validKeyCaesar(String key) throws InvalidKeyException{		
		if(key.length() != 1){
			throw new InvalidKeyException("F�r die Caesar-Verschl�sselung darf der Schl�ssel nur aus einem Zeichen bestehen!");
		}
		else if(!isLetter(key.charAt(0))){
			throw new InvalidKeyException("Das Zeichen muss ein Buchstabe sein!");
		}
		else{
			return true;
		}
	}
	
	public static boolean validKeySubst(String key) throws InvalidKeyException{
		if(key.length() != LETTERS.length){
			throw new InvalidKeyException("Der Schl�ssel muss 26 Zeichen lang sein!");
		}
		if(doubledLetter(key)){
			throw new InvalidKeyException("Kein Buchstabe darf doppelt vorkommen");
		}
		return true;
	}
	
	public static boolean validKeyXOR(String key) throws InvalidKeyException{
		//Implementation not done yet
		return true;
	}
	
	private static boolean isLetter(char c){
		for(char i: LETTERS){
			if(i == c){
				return true;
			}
		}
		return false;
	}
	
	private static boolean doubledLetter(String text){
		char[] checker = LETTERS.clone();
		char c;
		int counter = 0;
		boolean checked = false;
				
		for(int i = 0; i < text.length(); i++){
			c = text.charAt(i);
			for(char x: checker){
				if(x == c){
					checker[counter] = ' ';
					checked = true;
				}
				counter++;
			}
			if(!checked){
				return true;
			}
			checked = false;
			counter = 0;
		}
		
		return false;
	}
	
}
