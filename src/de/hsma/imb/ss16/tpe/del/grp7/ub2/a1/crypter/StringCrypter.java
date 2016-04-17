package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * This class can be used for encrypting/decrypting Strings
 * 
 * @author Gruppe 7
 *
 */
public class StringCrypter {

	private Crypter cr;
	
	/**
	 * Constructor
	 * 
	 * @param crypter  Crypter that should be used
	 */
	public StringCrypter(Crypter crypter) {
		cr = crypter;
	}
	
	/**
	 * This method is used to encrypt a String depending on Crypter
	 * 
	 * @param klartext  text that should be encrypted
	 * @return  encrypted text
	 */
	public String verschlüsselnStr(String klartext) throws CrypterException{
		String result = "";
		for(int i = 0; i < klartext.length(); i++){
			result += cr.verschluesseln(klartext.charAt(i));
		}
		
		return result;
	}
	
	/**
	 * This method is used to decrypt a String depending on Crypter
	 * 
	 * @param cyphertext  text that should be decrypted
	 * @return  decrypted text
	 */
	public String entschlüsselnStr(String cyphertext) throws CrypterException{
		String result = "";
		for(int i = 0; i < cyphertext.length(); i++){
			result += cr.entschluesseln(cyphertext.charAt(i));
		}
		
		return result;
	}
	
	/**
	 * Getter-method for cr
	 * 
	 * @return  attribute cr
	 */
	public Crypter getCr(){
		return cr;
	}
	
	/**
	 * Setter-method for cr
	 * 
	 * @param crypter  new Crypter that should be used
	 */
	public void setCr(Crypter crypter){
		cr = crypter;
	}
}
