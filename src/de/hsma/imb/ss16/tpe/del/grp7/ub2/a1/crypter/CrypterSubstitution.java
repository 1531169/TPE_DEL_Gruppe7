package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

class CrypterSubstitution implements Crypter {

	private static final char [] klartext =  {'A','B','C','D','E','F','G','H','I'
											 ,'J','K','L','M','N','O','P','Q','R'
											 ,'S','T','U','V','W','X','Y','Z'
											 };
	
	public CrypterSubstitution(char klarBuchstabe, Key myKey) {
		
	}
	
	@Override
	public void reset() {
		
		
	}

	@Override
	public char verschluesseln(char klartextZeichen) throws CrypterException {
		
		return 0;
	}

	@Override
	public char entschluesseln(char cypherZeichen) throws CrypterException {
		
		return 0;
	}

}
