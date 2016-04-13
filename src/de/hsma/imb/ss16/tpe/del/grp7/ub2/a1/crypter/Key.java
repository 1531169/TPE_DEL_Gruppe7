package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Stores the key for the different encodings.
 * 
 * @author Gruppe 7
 *
 */
class Key {

	/**
	 * Key for the encodings.
	 */
	private String myKey;

	/**
	 * Constructs a Key with a given key.
	 * 
	 * @param myKeyString
	 *            used for encode
	 */
	Key(String myKeyString) {
		this.myKey = myKeyString;
	}

	/**
	 * Give the stored key back.
	 * 
	 * @return stored key
	 */
	String getKey() {
		return myKey;
	}
}