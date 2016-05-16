package de.hsma.imb.ss16.tpe.del.grp7.ub4;

class Block {
	
	private int laenge;
	private Zug zug;
	private Signal signal;
	/**
	 * Describes the current position of the train in this block.
	 */
	private int position;
	
	Block() {
	}

	Block(int laenge) {
		this.laenge = laenge;
	}
	
	int getLaenge() {
		return this.laenge;
	}
	
	void setLaenge(int laenge) {
		this.laenge = laenge;
	}
	
	
	
	
	/**
	 * @return the zug
	 */
	Zug getZug() {
		return zug;
	}

	/**
	 * @param zug the zug to set
	 */
	void setZug(Zug zug) {
		this.zug = zug;
	}

	/**
	 * @return the signal
	 */
	Signal getSignal() {
		return signal;
	}

	/**
	 * @param signal the signal to set
	 */
	void setSignal(Signal signal) {
		this.signal = signal;
	}

	/**
	 * @return the position
	 */
	int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	void setPosition(int position) {
		this.position = position;
	}
}