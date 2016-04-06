package de.hsma.imb.ss16.tpe.del.grp7.ub1.a3;

import java.util.ArrayList;

/**
 * this class show you how the data will be handled in an account
 * 
 * @author Groupe 7
 * @version 03/22/2016  
 */

class Konto {
	private String inhaber;
	private Waehrung waehrung;
	private ArrayList<Betrag> buchungsListe = new ArrayList<>();

	/**
	 * constructor
	 *
	 * @param inhaber
	 *            Corresponding instance variable
	 * @param waehrung
	 *            Corresponding instance variable
	 */

	public Konto(String inhaber, Waehrung waehrung) {
		if (inhaber == null || inhaber == "" || waehrung == null) {
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
	String getInhaber() {
		return inhaber;
	}

	/**
	 * * Method that returns the currency.
	 * 
	 * @return waehrung is the currency back as waehrung object.
	 */
	Waehrung getWaehrung() {
		return waehrung;
	}

	/**
	 * With this method, amounts can be posted to the account (Positive and
	 * negative). If the amount recorded in another Foreign currency takes
	 * place(in a currency that differs to the accounts currency) the amount is
	 * automatically converted to the prevailing rate in the accounts currency.
	 *
	 * @param betrag
	 *            amount to book in account
	 */
	void buche(Betrag betrag) {
		// if there is
		if (betrag != null) {
			if (betrag.getBetrag() != 0) {
				// hier wird geprüft, ob es einen Unterschied von Waehrung gibt.
				if (getWaehrung().equals(betrag.getWaehrung())) {
					buchungsListe.add(betrag);
				} else {
					/*
					 * falls ja, wird den betrag in die richtige Waehrung
					 * umrechnet und in einer Buchungsliste gespeichert.
					 */
					long newBetrag = betrag.getWaehrung().umrechnen(betrag.getBetrag(), getWaehrung());
					buchungsListe.add(new Betrag(newBetrag, getWaehrung()));
				}
			}
		}
	}

	/**
	 * The method saldo() can query the balance on the account.
	 * 
	 * @return result is the result back as double.
	 */
	double saldo() {
		Betrag sum = new Betrag(0, getWaehrung());
		/*
		 * Hier wird die Liste unserer Buchungen vom Anfang bis Ende durchlaufen
		 * und die Werte addiert.
		 */
		for (Betrag b : buchungsListe) {
			sum = sum.addiere(b);
		}
		return sum.getAsDouble();
	}

	/**
	 * Use the method gebueren (...) the bank can automatically deduct a certain
	 * permillage of fees from the account.
	 * 
	 * @param promilleZahl
	 * @return fees which will be deducted from the account as long .
	 */
	long gebuehren(double promilleZahl) {
		Betrag saldo = new Betrag(saldo(), getWaehrung());
		long gebuehr = saldo.promille(promilleZahl).getBetrag();
		if (gebuehr > 0) {
			gebuehr *= -1;
		}
		buchungsListe.add(new Betrag(gebuehr, getWaehrung()));
		return gebuehr;
	}

	@Override
	public String toString() { // erzeugt ein String für den Kontoauszug.

		String kontoAuszug = "Kontoinhaber: " + inhaber + "\nWährung: " + getWaehrung().getName() + "\n------------\n";

		/*
		 * Hier wird die Liste unserer Buchungen vom Anfang bis Ende durchlaufen
		 * und die Werte in kontoAuszug geschrieben.
		 */
		for (Betrag b : buchungsListe) {
			kontoAuszug += b.toString() + "\n";
		}

		return kontoAuszug + "------------\n" + "Saldo: " + saldo() + " " + getWaehrung().getKuerzel();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buchungsListe == null) ? 0 : buchungsListe.hashCode());
		result = prime * result + ((inhaber == null) ? 0 : inhaber.hashCode());
		result = prime * result + ((waehrung == null) ? 0 : waehrung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Konto other = (Konto) obj;
		if (buchungsListe == null) {
			if (other.buchungsListe != null)
				return false;
		} else if (!buchungsListe.equals(other.buchungsListe))
			return false;
		if (inhaber == null) {
			if (other.inhaber != null)
				return false;
		} else if (!inhaber.equals(other.inhaber))
			return false;
		if (waehrung == null) {
			if (other.waehrung != null)
				return false;
		} else if (!waehrung.equals(other.waehrung))
			return false;
		return true;
	}
}
