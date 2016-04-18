package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * The class CrypterException is a form of Throwable and a subclass of Exception
 * and will be thrown whether an error occurs in the encodings.
 * 
 * @author Gruppe 7
 *
 */
@SuppressWarnings("serial")
public class CrypterException extends Exception {

	/**
	 * Constructs an ArithmeticException with no detail message.
	 */
	public CrypterException() {
	}

	/**
	 * Constructs an CrypterException with the specified detail message.
	 * 
	 * @param string
	 *            the detail message
	 */
	public CrypterException(String string) {
		super(string);
	}
}
