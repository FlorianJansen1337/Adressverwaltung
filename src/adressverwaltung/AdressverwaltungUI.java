package adressverwaltung;

import java.util.Scanner;

public class AdressverwaltungUI {

	static AdressDatenbank db = new AdressDatenbank();
	static String adressenUeberschrift[] = new String[] { "Vorname", "Nachname", "Straße", "Hausnummer", "PLZ", "Ort" };
	static private Scanner scanner = AdressverwaltungMain.scanner;

	public void printAddress(int x) {
		if (db.getAnzahl() == 0) {
			System.out.println("Liste leer");
			return;
		}

		if (x >= 0 && x <= db.getMaxIndex()) {
			Adresse adresse = db.getAddress(x);
			int i = 0;
			while (i < AdressDatenbank.MAX_COLUMNS - 1) {
				System.out.print(adressenUeberschrift[i] + ": " + adresse.getAddress(i) + ", ");
				i++;
			}
			System.out.println(adressenUeberschrift[i] + ": " + adresse.getAddress(i));
			i++;
		} else {
			System.out.println("Zahl zu groß");
		}
	}

	public void printAllAddresses() {
		if (db.getAnzahl() == 0) {
			System.out.println("Liste leer");
			return;
		}
		
		int i = 0;
		while (i < db.getAnzahl()) {
			printAddress(i);
			i++;
		}
		System.out.print("\n");
	}

	public int selectRow() {
		System.out.println("Welche Adresse (Zeile)?");
		int zeile = readInteger();
		zeile--;
		return zeile;
	}

	public Adresse addressInput() {
		String[] values = new String[AdressDatenbank.MAX_COLUMNS];
		
		for (int i=0; i<adressenUeberschrift.length; i++) {
			System.out.println(adressenUeberschrift[i] + " eingeben");
			values[i] = scanner.nextLine();
		}
		
		return new Adresse(values[0], values[1], values[2], values[3], values[4], values[5]);
	}

	public int readInteger() {
		boolean correct = false;
		int auswahl = 0;
		while (!correct) {
			try {
				auswahl = scanner.nextInt();
				correct = true;
			} catch (Exception e) {
				System.out.println("nur Zahlen eingeben");
			}
			scanner.nextLine();
		}
		return auswahl;
	}

	public void edit(int i) {
		boolean fortsetzen = true;
		while (fortsetzen) {
			System.out.println("zu ändernde Adresse: ");
			printAddress(i);
			if (i > db.getMaxIndex() || db.getAnzahl() == 0) {
				return;
			}
			System.out.println("Bestätigen mit 'Y' Abbruch mit 'N'");
			String helper = scanner.nextLine();
			helper = helper.toUpperCase();
			if (helper.equals("Y")) {
				db.editAddress(i, addressInput());
				System.out.println("geänderte Adresse: ");
				printAddress(i);
				fortsetzen = false;
			} else if (helper.equals("N")) {
				fortsetzen = false;
			} else {
				System.out.println("Nur 'Y' und 'N'");
			}
		}

	}
}
