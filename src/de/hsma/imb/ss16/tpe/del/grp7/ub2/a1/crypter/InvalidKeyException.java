package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

@SuppressWarnings("serial")
class InvalidKeyException extends Exception {
	
	public InvalidKeyException (){	
	}

	public InvalidKeyException(String string) {
		super(string);
	}
	
	@Override
	public String getMessage(){
		return super.getMessage() + ".InvalidKeyException";
	}

}
