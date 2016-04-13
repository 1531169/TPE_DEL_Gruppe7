package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

/**
 * Grundlegendes Interface, um Verschlüsselung durchzuführen. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschlüsseln (über die
 * {@link #verschluesseln(char)} Methode) und wieder entschlüsseln (über die
 * {@link #entschluesseln(char)} Methode).
 *
 * Der Eingabetext, der Zeichenweise übergeben wird ({@literal klarTextZeichen}
 * ) darf nur aus den Groß-Buchstaben A-Z bestehen. Kleinbuchstaben werden in
 * Großbuchstaben umgewandelt, alle anderen Zeichen führen zu einer Ausnahme.
 *
 * Zwischen den beiden Methoden muss bei gleichem Schlüssel folgendes gelten:
 * {@code zeichen == decrypt(encrypt(zeichen))}.
 */
public interface Crypter {

	/**
	 * Setzt die Verschlüsselung zurück. Diese Methode ist bei einigen Verfahren
	 * sinnvoll, bei denen eine Position im Schlüssel verwaltet wird, da diese
	 * beim Wechsel von Ver- auf Entschlüsselung zurückgesetzt werden muss.
	 */
	public void reset();

	/**
	 * Verschlüsselt das gegebene Zeichen.
	 *
	 * @param klartextZeichen
	 *            Zeichen, das verschlüsselt werden soll.
	 *
	 * @return verschlüsseltes Zeichen.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	public char verschluesseln(char klartextZeichen) throws CrypterException;

	/**
	 * Entschlüsselt das gegebenen Zeichen.
	 *
	 * @param cypherTextZeichen
	 *            Zeichen, das entschlüsselt werden soll.
	 *
	 * @return entschlüsseltes Zeichen.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	public char entschluesseln(char cypherZeichen) throws CrypterException;
}