package tpe.del.grp7.ub1.a3;

/**
 * In dieser Klasse liegen die Daten zu einer Währung.
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
	 * Methode, mit der man Beträge von einer Währung in eine andere umrechnen kann.
	 * 
	 * @param betrag  Übergebener Betrag
	 * @param waehrung  Übergebene Zielwährung
	 * @return gibt den umgerechneten Betrag als long zurück
	 */
	public long umrechnen(long betrag, Waehrung waehrung) {
		double temp = betrag * this.getKurs();
		temp = temp / waehrung.getKurs();
		long result = (long) temp;
		return result;		
	}
		
	/**
	 * Getter-Methode für name
	 * 
	 * @return gibt Instanzvariable name zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter-Methode für kuerzel
	 * 
	 * @return gibt Instanzvariable kuerzel zurück
	 */
	public String getKuerzel() {
		return kuerzel;
	}

	/**
	 * Getter-Methode für kurs
	 * 
	 * @return gibt Instanzvariable kurs zurück
	 */
	public double getKurs() {
		return kurs;
	}
	
	/**
	 * Methode, die die Informationen zur Währung als String zurückgibt.
	 * 
	 * @Override
	 * @return gibt ebendiesen String zurück
	 */
	public String toString() {
		return name + " [" + kuerzel + "] 1 " + kuerzel + " = " + kurs + " $";
	}
	
	/**
	 * Methode, die einen Hash-Wert über das Objekt berechnet.
	 * 
	 * @Override
	 * @return gibt Hash-Wert zurück 
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
	 * @return gibt Auskunft über die Gleichheit der beiden Objekten in Form von true oder false
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
