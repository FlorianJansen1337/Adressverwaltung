package adressverwaltung;

public class Adresse {
	
	public static String adressenUeberschrift[] = new String[] { "Vorname: ", "Nachname: ", "Straﬂe: ", "Hausnummer: ", "PLZ: ", "Ort: " };
	
	public final String vorname, nachname, straﬂe, hausnummer, plz, ort;
	
	public Adresse(String vorname, String nachname, String straﬂe, String hausnummer, String plz, String ort) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.straﬂe = straﬂe;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}

	public String getAddress(int i) {
		switch (i) {
		case 0:
			return vorname;
		case 1:
			return nachname;
		case 2:
			return straﬂe;
		case 3:
			return hausnummer;
		case 4:
			return plz;
		case 5:
			return ort;
		default:
			return null;
		}
	}

}