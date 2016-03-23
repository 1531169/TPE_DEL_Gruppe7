package tpe.del.grp7.ub1.a3;

import java.text.DecimalFormat;

public class Betrag {
	private long 	 betrag;
	private Waehrung waehrung;
	
	public Betrag(double betrag, Waehrung waehrung) {
		this.betrag	  = (long)(betrag * 100);
		this.waehrung = waehrung;
	}

	public Betrag(long betrag, Waehrung waehrung) {
		this.betrag	  = betrag;
		this.waehrung = waehrung;
	}
	
	int getVorzeichen()
	{
		if(this.betrag >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	Betrag addiere(Betrag b) {
		long result = this.getBetrag();
		if(b != null)
		{
			if(this.getWaehrung().equals(b.getWaehrung())) {
				result += b.getBetrag();
			} else {
				result += b.getWaehrung().umrechnen(b.getBetrag(), this.getWaehrung());
			}
		}
		return new Betrag(result, this.getWaehrung());
	}
	
	Betrag subtrahiere(Betrag b) {
		Betrag temp = new Betrag(-b.getBetrag(), b.getWaehrung());
		return this.addiere(temp);
	}
	
	Betrag multipliziere(double zahl) {
		return new Betrag(this.getBetrag() * zahl, this.getWaehrung());
	}
	
	Betrag multipliziere(int zahl) {
		return this.multipliziere((double)zahl);
	}
	
	Betrag prozent(double p) {
		return new Betrag(calcProzentAndPromille(p, 100), this.getWaehrung());
	}
	
	Betrag promille(double p) {
		return new Betrag(calcProzentAndPromille(p, 1000), this.getWaehrung());
	}
	
	private double calcProzentAndPromille(double p, int div) {
		return this.getBetrag() * p / div;
	}
	
	long getVorkomma() {
		return this.getBetrag() / 100 * this.getVorzeichen();
	}
	
	byte getNachkomma() {
		return (byte)(((double)this.getBetrag()) % 100  * this.getVorzeichen());
	}
	
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("00");
		String vorzeichen = "";
		if(this.getVorzeichen() == -1) {
			vorzeichen = "-";
		}
		return vorzeichen + getVorkomma() + "."
				+ f.format(getNachkomma()) + " " + getWaehrung().getKuerzel();
	}
	
	double getAsDouble() {
		return ((double)this.getBetrag()) / 100;
	}
	
	Waehrung getWaehrung() {
		return this.waehrung;
	}

	long getBetrag() {
		return this.betrag;
	}
}
