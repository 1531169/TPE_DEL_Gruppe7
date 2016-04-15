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
	private String key;

	/**
	 * Constructs a key with a given key.
	 * 
	 * @param key
	 *            used for encode
	 */
	Key(String key) {
		this.key = key;
	}

	/**
	 * Give the stored key back.
	 * 
	 * @return stored key
	 */
	String getKey() {
		return key;
	}
}