package de.hsma.imb.ss16.tpe.del.grp7.ub4;

import java.util.ArrayList;

class Strecke {
	
	private int laenge = 0;
	private ArrayList<Block> bloecke;
	
	Strecke() {
		this.bloecke = new ArrayList<Block>();
	}
	
	void addBlock(Block block) {
		// TODO: check null
		bloecke.add(block);
		setLaenge(getLaenge() + block.getLaenge());
	}
	
	

	/**
	 * @return the laenge
	 */
	int getLaenge() {
		return laenge;
	}

	/**
	 * @param laenge the laenge to set
	 */
	void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	/**
	 * @return the bloecke
	 */
	ArrayList<Block> getBloecke() {
		return bloecke;
	}

	/**
	 * @param bloecke the bloecke to set
	 */
	void setBloecke(ArrayList<Block> bloecke) {
		this.bloecke = bloecke;
	}
}