package de.hsma.imb.ss16.tpe.del.grp7.ub4;

class Zug {
	private int geschwindigkeit;
	private char name;
	
	public Zug() {
	}
	
	/**
	 * @return the geschwindigkeit
	 */
	int getGeschwindigkeit() {
		return geschwindigkeit;
	}

	/**
	 * @param geschwindigkeit the geschwindigkeit to set
	 */
	void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	/**
	 * @return the name
	 */
	char getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	void setName(char name) {
		this.name = name;
	}
}