package tpe.del.grp7.ub1.a3;

/**
 * this class show you how the data will be handled in an account
 * 
 * @author Groupe 7
 * @version 03/22/2016  
 */

class Konto {

	private String inhaber;
	private Waehrung waehrung;
	private Betrag[] buchungsListe = new Betrag[10];
	private int index = 0;

	/**
	 * constructor
	 *
	 * @param inhaber
	 *            Corresponding instance variable
	 * @param waehrung
	 *            Corresponding instance variable
	 */

	public Konto(String inhaber, Waehrung waehrung) {
		if (inhaber == null || waehrung == null) {
			throw new IllegalArgumentException("inhaber or waehrung can't be null");
		}
		this.inhaber = inhaber;
		this.waehrung = waehrung;
	}

	/**
	 * Method that returns the name of the account holder.
	 *
	 * @return inhaber gives the name as a string.
	 */
	public String getInhaber() {
		return inhaber;
	}

	/**
	 * * Method that returns the currency.
	 * 
	 * @return waehrung is the currency back as waehrung object.
	 */
	public Waehrung getWaehrung() {
		return waehrung;
	}

	/**
	 * With this method, amounts can be posted to the account (Positive and
	 * negative). If the amount recorded in another Foreign currency takes
	 * place(in a currency that differs to the accounts currency) the amount is
	 * automatically converted to the prevailing rate in the accounts currency.
	 *
	 * @param betrag
	 *            Is stored in the account.
	 */

	public void buche(Betrag betrag) {

		if (this.getWaehrung() == null) {
			throw new IllegalArgumentException("waehrung des Kontos unbekannt !!!");
		}
		/*
		 * hier wird geprüft, ob die Buchungsliste voll ist (10 Buchungen
		 * möglich).
		 */
		if (index > 9) {
			throw new IllegalArgumentException("Fehler: größte Anzahl von Buchungen erreicht !!!");
		} else {

			// hier wird geprüft, ob es einen Unterschied von Waehrung gibt.
			if (!waehrung.equals(betrag.getWaehrung())) {

				/*
				 * falls ja, wird den betrag in die richtige Waehrung umrechnet
				 * und in einer Buchungsliste gespeichert.
				 */

				long newBetrag = betrag.getWaehrung().umrechnen(betrag.getBetrag(), waehrung);
				buchungsListe[index++] = new Betrag(newBetrag, waehrung);
			} else {
				buchungsListe[index++] = betrag;
			}
		}
	}

	/**
	 * The method saldo() can query the balance on the account.
	 * 
	 * @return result is the result back as double.
	 */
	public double saldo() {
		Betrag saldo = new Betrag(0, waehrung);

		/*
		 * Durch diese Schleife wird die Buchungsliste bis zum Index
		 * durchgelaufen und die Betraege sommiert.
		 */

		for (int i = 0; i < index; i++) {
			saldo = saldo.addiere(buchungsListe[i]);
		}

		double result = (double) saldo.getBetrag() / 100;
		return result;

	}

	/**
	 * Use the method gebueren (...) the bank can automatically deduct a certain
	 * permillage of fees from the account.
	 * 
	 * @param promilleZahl
	 * @return fees which will be deducted from the account as long .
	 */

	public long gebuehren(double promilleZahl) {
		if (index > 9) {
			throw new IllegalArgumentException("Gebuehrenabzug unmöglich. Buchungsliste voll !!!");
		} else {

			double abzug = 0;
			abzug = saldo() * promilleZahl / 1000;
			// hier wird den abzug negiert und aus dem konto abgezogen.
			if (saldo() < 0) {
				buchungsListe[index++] = new Betrag((long) abzug, waehrung);
				return (long) abzug;
			} else {
				buchungsListe[index++] = new Betrag(-(long) abzug, waehrung);
				return -(long) abzug;
			}
		}
	}

	@Override
	public String toString() { // erzeugt ein String für den Kontoauszug.

		String kontoAuszug = "Kontoinhaber: " + inhaber + "\nWährung: " + waehrung.getName() + "\n------------\n";

		/*
		 * Hier wird die Liste unserer Buchungen vom Anfang bis zum Index
		 * durchglaufen und die Werte in kontoAuszug geschrieben.
		 */
		for (int i = 0; i < index; i++) {
			kontoAuszug += buchungsListe[i].toString() + "\n";
		}

		return kontoAuszug + "------------\n" + "Saldo: " + saldo() + " " + waehrung.getKuerzel();
	}

	@Override
	public boolean equals(Object obj) {

		Konto kt = (Konto) obj;
		if (this.inhaber == kt.inhaber && this.getWaehrung().equals(kt.getWaehrung()) && this.index == kt.index) {

			boolean list = true;
			Betrag[] listA = this.buchungsListe;
			Betrag[] listB = kt.buchungsListe;

			for (int i = 0; i < index && list == true; i++) {
				if (listA[i].getBetrag() != listB[i].getBetrag()) {
					list = false;
				}
			}
			return list;
		}
		return false;
	}

}
