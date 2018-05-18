package adressverwaltung;

import java.util.*;

public class AdressverwaltungMain {

	static public Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		AdressverwaltungUI ui = new AdressverwaltungUI();
		AdressDatenbank db = new AdressDatenbank();
		boolean beenden = false;

		while (!beenden) {

			System.out.println("Menüpunkt auswählen:\n 1 - Adresse anlegen\n 2 - Alle Adresssen anzeigen\n "
					+ "3 - eine Adresse anzeigen\n 4 - eine Adresse bearbeiten\n 5 - eine Adresse löschen\n"
					+ " 9 - Beenden");
			int auswahl = ui.readInteger();
			int zeile;
			switch (auswahl) {
			case 1:
				Adresse address = ui.addressInput();
				db.newAddress(address);
				break;
			case 2:
				ui.printAllAddresses();
				break;
			case 3:
				zeile = ui.selectRow();
				ui.printAddress(zeile);
				break;
			case 4:
				zeile = ui.selectRow();
				ui.edit(zeile);
				break;
			case 5:
				zeile = ui.selectRow();
				db.deleteAddress(zeile);
				break;
			case 9:
				beenden = true;
				System.out.println("shutting down");
				break;
			default:
				System.out.println("falsche Zahl");
				break;
			}
		}
		scanner.close();
	}
}