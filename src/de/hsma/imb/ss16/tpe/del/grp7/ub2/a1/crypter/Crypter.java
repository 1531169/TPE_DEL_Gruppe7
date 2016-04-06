package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;


public interface Crypter {

	public void reset();

	public char verschluesseln(char klartextZeichen) throws CrypterException;

	public char entschluesseln(char cypherZeichen) throws CrypterException;
}
