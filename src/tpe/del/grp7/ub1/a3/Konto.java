package tpe.del.grp7.ub1.a3;

/**
 * in dieser Klasse werden gezeigt, wie die Daten in einem Konto behandelt werden.  
 * 
 * @author Groupe 7
 *@version 22.03.2016
 */

class Konto {

	private String inhaber;
	private Waehrung waehrung;
	private Betrag[] buchungsListe = new Betrag[1000];
	private int index = 0;

	/**
	 * Konstruktor
	 * 
	 * @param inhaber  entsprechend Instanzvariable
	 * @param waehrung  entsprechend Instanzvariable
	 */
	public Konto(String inhaber, Waehrung waehrung) {
		this.inhaber = inhaber;
		this.waehrung = waehrung;
	}
	
	/**
	 * Methode, die den Namen des Kontoinhabers zur�ckgibt.
	 * 
	 * @return inhaber gibt den Namen als String zur�ck.
	 */
	public String getInhaber() {
		return inhaber;
	}

	/**
	 * Methode, die die Weahrung zur�ckgibt.
	 * 
	 * @return weahrung gibt die Waehrung als Waehrung zur�ck.
	 */
	public Waehrung getWaehrung() {
		return waehrung;
	}
	
	/**
	 * Mit dieser Methode, koennen Betraege auf das Konto gebucht werden (positive wie negative).
	 * Wenn der gebuchte Betrag in einer anderen Fremdwaehrung erfolgt, d. h. in einer Waehrung,
	 * die von der Kontowahrung abweicht, wird der Betrag automatisch 
	 * zum jeweiligen Wechselkurs in die Kontowaehrung umgerechnet..
	 * 
	 * @param betrag wird in das Array buchungsListe gespeichert. 
	 */

	public void buche(Betrag betrag) {
		
		// hier wird gepr�ft, ob die Buchungsliste voll ist (1000 Buchungen m�glich).
		if (index > 999) {
			System.out.println("Fehler: gr��te Anzahl von Buchungen erreicht !!!");
		} else {
			
			// hier wird gepr�ft, ob es einen Unterschied von Waehrung gibt.
			if (!waehrung.equals(betrag.getWaehrung())) {
				
				// falls ja, wird den betrag in die richtige Waehrung umrechnet 
				// und in einer Buchungsliste gespeichert.
				long newBetrag = waehrung.umrechnen(betrag.getBetrag(), waehrung);
				buchungsListe[index++] = new Betrag(newBetrag, waehrung);

			} else {
				buchungsListe[index++] = betrag;
			}
		}
	}
	
/**
 * Mit der Methode saldo() kann man das Saldo auf dem Konto abfragen.
 * 
 * @return result gibt das Resultat als double zur�ck. 
 */
	public double saldo() {
		long saldo = 0;
		
		// durch diese Schleife wird die Buchungsliste durchgelaufen 
		// und die Betraege sommiert.
		
		for (int i = 0; i < index; i++) {
			saldo = saldo + buchungsListe[i].getBetrag();
		}
		double result = (double) saldo / 100;
		return result;

	}

	public long gebuehren(double promilleZahl) {

		double abzug = 0;

		abzug = saldo() * promilleZahl / 1000;
		// hier wird das Vorzeichen
		if (saldo() < 0) {
			buchungsListe[index++] = new Betrag((long) abzug, waehrung);
			return (long) abzug;
		} else {
			buchungsListe[index++] = new Betrag(-(long) abzug, waehrung);
			return -(long) abzug;
		}
	}

	public String toString() { // erzeugt ein String f�r den Kontoauszug.

		String kontoAuszug = "Kontoinhaber: " + inhaber + "\nW�hrung: " + waehrung.getName() + "\n------------\n";

		// Hier wird die Liste unserer Buchungen vom Anfang bis zum Index
		// durchglaufen und die Werte in kontoAuszug geschrieben.

		for (int i = 0; i < index; i++) {
			kontoAuszug = kontoAuszug + buchungsListe[i].toString() + "\n";
		}
		kontoAuszug = kontoAuszug + "------------\n" + "Saldo: " + saldo() + waehrung.getKuerzel();
		return kontoAuszug;
	}
}
