package tpe.del.grp7.ub1.a3;

class Konto {

	private String inhaber;
	private Waehrung waehrung;
	private Betrag[] buchungsListe = new Betrag[1000];
	private int index = 0;

	public Konto(String inhaber, Waehrung waehrung) {
		this.inhaber = inhaber;
		this.waehrung = waehrung;
	}

	public String getInhaber() {
		return inhaber;
	}

	public Waehrung getWaehrung() {
		return waehrung;
	}

	public void buche(Betrag betrag) {

		if (index > 999) {
			System.out.println("Fehler: größte Anzahl von Buchungen erreicht !!!");
		} else {
			if (!waehrung.equals(betrag.getWaehrung())) {

				long newBetrag = waehrung.umrechnen(betrag.getBetrag(), waehrung);
				buchungsListe[index++] = new Betrag(newBetrag, waehrung);

			} else {
				buchungsListe[index++] = betrag;
			}
		}
	}

	double saldo() {
		long saldo = 0;
		for (int i = 0; i < index; i++) {
			saldo = saldo + buchungsListe[i].getBetrag();
		}
		return (double)saldo/100;

	}

	void gebuehren() {

	}

	public String toString() { // erzeugt ein String für den Aufzug.
		
		String kontoAufzug = "Kontoinhaber: " + inhaber + "\nWährung: " + waehrung.getName() + "\n------------\n";
	
	// Hier wird die Liste unserer Buchungen vom Anfang bis zum Index durchglaufen und die Werte in kontoAufzug geschrieben.
		
		for (int i = 0; i < index; i++) {
			kontoAufzug = buchungsListe[i].toString() + "\n";
		}
		
		kontoAufzug = "------------\n" + "Saldo: " + saldo() + waehrung.getKuerzel();
		return kontoAufzug;
	}
}
