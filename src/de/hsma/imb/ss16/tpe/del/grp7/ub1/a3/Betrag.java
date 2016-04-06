package de.hsma.imb.ss16.tpe.del.grp7.ub1.a3;

import java.text.DecimalFormat;

 /**
  * This class contains an amount in a specific currency and
  * offers methods to calculations.
  * 
  * @author	Cedric
  */
public class Betrag {
	/**
	 * Contains the amount and the last two digits are the decimals.
	 */
	private long betrag;
	/**
	 * Contains the currency of the amount.
	 */
	private Waehrung waehrung;
	
	/**
	 * Contructor for the class Betrag.
	 * @param betrag	amount, will be calculated to long
	 * @param waehrung	currency of the amount
	 */
	public Betrag(double betrag, Waehrung waehrung) throws IllegalArgumentException {
		if(waehrung == null) {
			throw new IllegalArgumentException("waehrung can't be null");
		}
		this.betrag	= (long)(betrag * 100);
		this.waehrung = waehrung;
	}

	/**
	 * Contructor for the class Betrag.
	 * @param betrag	amount, last two digits are the decimals
	 * @param waehrung	currency of the amount
	 */
	public Betrag(long betrag, Waehrung waehrung) throws IllegalArgumentException {
		if(waehrung == null) {
			throw new IllegalArgumentException("waehrung can't be null");
		}
		this.betrag = betrag;
		this.waehrung = waehrung;
	}
	
	/**
	 * Checks whether the amount is positiv or negativ
	 * @return	1 if positiv and -1 if amount negativ
	 */
	int getVorzeichen()
	{
		if(getBetrag() >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/**
	 * Add other amount to this amount but doesn't change this object.
	 * @param b		amount to add
	 * @return		result of calculation as Betrag
	 */
	Betrag addiere(Betrag b) {
		long result = getBetrag();
		if(b != null)
		{
			if(getWaehrung().equals(b.getWaehrung())) {
				result += b.getBetrag();
			} else {
				result += b.getWaehrung().umrechnen(b.getBetrag(), getWaehrung());
			}
		}
		return new Betrag(result, getWaehrung());
	}
	
	/**
	 * Subtract other amount from this amount but doesn't change this object.
	 * @param b		amount to subtract
	 * @return		result of calculation as Betrag
	 */
	Betrag subtrahiere(Betrag b) {
		if(b == null) {
			return addiere(null);
		}
		return addiere(new Betrag(-(b.getBetrag()), b.getWaehrung()));
	}
	
	/**
	 * Multiplied the amount with a double.
	 * @param zahl	operand for the multiplication
	 * @return		result of calculation as Betrag
	 */
	Betrag multipliziere(double zahl) {
		return new Betrag(getAsDouble() * zahl, getWaehrung());
	}
	
	/**
	 * Multiplied the amount with an integer.
	 * @param zahl	operand for the multiplication
	 * @return		result of calculation as Betrag
	 */
	Betrag multipliziere(int zahl) {
		return this.multipliziere((double)zahl);
	}
	
	/**
	 * Calculates a given percentage from the amount.
	 * @param p		percentage as double
	 * @return		result of calculation as Betrag
	 */
	Betrag prozent(double p) {
		return new Betrag(calcProzentAndPromille(p, 100), getWaehrung());
	}
	
	/**
	 * Calculates a given promille rate from the amount.
	 * @param p		promille rate as double
	 * @return		result of calculation as Betrag
	 */
	Betrag promille(double p) {
		return new Betrag(calcProzentAndPromille(p, 1000), getWaehrung());
	}
	
	/**
	 * Multiplied this amount with a double and divide it by a given number.
	 * @param p		factor for calculation
	 * @param div	divider for calculation
	 * @return		result of the formula
	 */
	private double calcProzentAndPromille(double p, int div) {
		return getAsDouble() * p / div;
	}
	
	/**
	 * Calculates the numbers before the decimal point.
	 * @return		amount without decimals
	 */
	long getVorkomma() {
		return getBetrag() / 100 * getVorzeichen();
	}
	
	/**
	 * Calculates the decimals of the amount.
	 * @return		decimals of the amount
	 */
	byte getNachkomma() {
		return (byte)(((double)getBetrag()) % 100  * getVorzeichen());
	}
	
	/**
	 * Converts the amount to an double with not more than two digits.
	 * @return		amount in decimal format
	 */
	double getAsDouble() {
		return ((double)getBetrag()) / 100;
	}
	
	/**
	 * Getter for the currency.
	 * @return		currency of amount
	 */
	Waehrung getWaehrung() {
		return this.waehrung;
	}

	/**
	 * Getter for the amount
	 * @return		amount, last two digits are the decimals
	 */
	long getBetrag() {
		return this.betrag;
	}
	
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("00");
		String vorzeichen = "";
		if(getVorzeichen() == -1) {
			vorzeichen = "-";
		}
		return vorzeichen + getVorkomma() + "."
				+ f.format(getNachkomma()) + " " + getWaehrung().getKuerzel();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (betrag ^ (betrag >>> 32));
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
		Betrag other = (Betrag) obj;
		if (betrag != other.betrag)
			return false;
		if (waehrung == null) {
			if (other.waehrung != null)
				return false;
		} else if (!waehrung.equals(other.waehrung))
			return false;
		return true;
	}
}
