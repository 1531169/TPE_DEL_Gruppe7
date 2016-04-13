package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * The class InvalidKeyException is a form of Throwable and a subclass of
 * Exception and will be thrown whether an error occurs during the validation of
 * the keys for the encodings.
 * 
 * @author Gruppe 7
 *
 */
class InvalidKeyException extends Exception {

	/**
	 * Constructs an InvalidKeyException with no detail message.
	 */
	public InvalidKeyException() {
	}

	/**
	 * Constructs an InvalidKeyException with the specified detail message.
	 * 
	 * @param string
	 *            the detail message
	 */
	public InvalidKeyException(String string) {
		super(string);
	}
}
