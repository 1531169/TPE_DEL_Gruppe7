package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

@SuppressWarnings("serial")
class CrypterException extends Exception {

	public CrypterException (){	
	}

	public CrypterException(String string) {
	super(string);
	}
	public String getMessage(){
		return "CrypterException";
	}
}
