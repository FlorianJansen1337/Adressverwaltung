package adressverwaltung;

import java.util.*;

public class AdressDatenbank {

	public static final int MAX_COLUMNS = 6;

	private static Map<Integer, Adresse> adressenDBHM = new HashMap<>();

	public int getAnzahl() {
		return adressenDBHM.size();
	}

	public int getMaxIndex() {
		return getAnzahl() - 1;
	}

	public void newAddress(Adresse address) {
		editAddress(adressenDBHM.size(), address);
	}

	public void editAddress(int i, Adresse adresse) {
		adressenDBHM.put(i, adresse);
	}

	public Adresse getAddress(int i) {
		return adressenDBHM.get(i);
	}

	public void deleteAddress(int i) {
		adressenDBHM.remove(i);
	}
}
