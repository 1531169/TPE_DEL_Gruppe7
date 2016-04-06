package de.hsma.imb.ss16.tpe.del.grp7.ub1.a3;

import java.text.DecimalFormat;

/**
 * In this class there is the data of a currency.
 * 
 * @author Gruppe 7
 * @version 20.03.2016
 */

class Waehrung {

	private String name;
	private String kuerzel;
	private double kurs;
	
	/**
	 * Constructor
	 * 
	 * @param name  equivalent to attribute
	 * @param kuerzel  equivalent to attribute
	 * @param kurs  equivalent to attribute
	 */
	public Waehrung(String name, String kuerzel, double kurs) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.kurs = kurs;
	}

	/**
	 * With this method amounts of one currency can be converted to another.
	 * 
	 * @param betrag  passed amount
	 * @param waehrung  passed target currency
	 * @return returns converted amount as type long
	 */
	public long umrechnen(long betrag, Waehrung waehrung) {
		long result = betrag;
		if(!this.equals(waehrung)){
			double temp = betrag * this.getKurs();
			temp = temp / waehrung.getKurs();
			result = (long) temp;
		}
		return result;		
	}
		
	/**
	 * Getter-method for name
	 * 
	 * @return return attribute name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter-method for kuerzel
	 * 
	 * @return returns attribute kuerzel
	 */
	public String getKuerzel() {
		return kuerzel;
	}

	/**
	 * Getter-method for kurs
	 * 
	 * @return returns attribute kurs
	 */
	public double getKurs() {
		return kurs;
	}
	
	/**
	 * This method returns information about an object of this class as a String.
	 * 
	 * @Override
	 * @return returns this String
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0000");
		return name + " [" + kuerzel + "] 1 " + kuerzel + " = " + df.format(kurs) + " $";
	}
		
	/**
	 * This method calculates a hash value over the object
	 * 
	 * @Override
	 * @return returns hash value 
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * This method compares two objects content.
	 * 
	 * @Override
	 * @param obj  the object that is compared with
	 * @return returns true or false depending on whether the compared objects are equal or not
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		if (Double.doubleToLongBits(kurs) != Double.doubleToLongBits(other.kurs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
