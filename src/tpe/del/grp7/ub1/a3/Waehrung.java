package tpe.del.grp7.ub1.a3;

/**
 * In dieser Klasse liegen die Daten zu einer W�hrung.
 * 
 * @author Gruppe 7
 * @version 20.03.2016
 */

class Waehrung {

	private String name;
	private String kuerzel;
	private double kurs;
	
	/**
	 * Konstruktor
	 * 
	 * @param name  entsprechend Instanzvariable
	 * @param kuerzel  entsprechend Instanzvariable
	 * @param kurs  entsprechend Instanzvariable
	 */
	public Waehrung(String name, String kuerzel, double kurs) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.kurs = kurs;
	}

	/**
	 * Methode, mit der man Betr�ge von einer W�hrung in eine andere umrechnen kann.
	 * 
	 * @param betrag  �bergebener Betrag
	 * @param waehrung  �bergebene Zielw�hrung
	 * @return gibt den umgerechneten Betrag als long zur�ck
	 */
	public long umrechnen(long betrag, Waehrung waehrung) {
		double temp = betrag * this.getKurs();
		temp = temp / waehrung.getKurs();
		long result = (long) temp;
		return result;		
	}
		
	/**
	 * Getter-Methode f�r name
	 * 
	 * @return gibt Instanzvariable name zur�ck
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter-Methode f�r kuerzel
	 * 
	 * @return gibt Instanzvariable kuerzel zur�ck
	 */
	public String getKuerzel() {
		return kuerzel;
	}

	/**
	 * Getter-Methode f�r kurs
	 * 
	 * @return gibt Instanzvariable kurs zur�ck
	 */
	public double getKurs() {
		return kurs;
	}
	
	/**
	 * Methode, die die Informationen zur W�hrung als String zur�ckgibt.
	 * 
	 * @Override
	 * @return gibt ebendiesen String zur�ck
	 */
	public String toString() {
		// TO-DO: Ausgabe des Wechselkurses mit vier Nachkommastellen
		return name + " [" + kuerzel + "] 1 " + kuerzel + " = " + kurs + " $";
	}
	
	/**
	 * Methode, die einen Hash-Wert �ber das Objekt berechnet.
	 * 
	 * @Override
	 * @return gibt Hash-Wert zur�ck 
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
	 * Methode, die den Inhalt eines Objekts mit einem anderen vergleicht.
	 * 
	 * @Override
	 * @param obj  Objekt, mit dem verglichen wird
	 * @return gibt Auskunft �ber die Gleichheit der beiden Objekten in Form von true oder false
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