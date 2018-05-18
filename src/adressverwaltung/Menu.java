package adressverwaltung;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	public JMenuBar hauptmenu;

	private JMenuItem printAllAddresses = new JMenuItem("Alle Adressen anzeigen - not done yet");

	public Menu() {

		// JMenu untermenu = new JMenu("Weitere Optionen");

		JMenu dateimenu = new JMenu("Menu");
		dateimenu.add(new NewAddress());
		dateimenu.addSeparator();
		dateimenu.add(printAllAddresses);
		dateimenu.addSeparator();
		dateimenu.add(new PrintAddress());
		dateimenu.addSeparator();
		dateimenu.add(new EditAddress());
		dateimenu.addSeparator();
		dateimenu.add(new DeleteAddress());
		dateimenu.addSeparator();
		dateimenu.add(new AktionBeenden());

		hauptmenu = new JMenuBar();
		hauptmenu.add(dateimenu);
	}

}

class NewAddress extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public NewAddress() {
		super("Adresse anlegen");
	}

	public void actionPerformed(ActionEvent e) {
		new DialogPopup();
	}
}

class PrintAddress extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public PrintAddress() {
		super("Eine Adresse anzeigen");
	}

	public void actionPerformed(ActionEvent e) {
		new DialogPopupPrint(0);
	}
}

class PrintAllAddresses extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public PrintAllAddresses() {
		super("Alle Adressen anzeigen");
	}

	public void actionPerformed(ActionEvent e) {
		new DialogPopupPrint(0);
	}
}

class EditAddress extends AbstractAction {
	
	private AdressDatenbank db = new AdressDatenbank();
	private static final long serialVersionUID = 1L;

	public EditAddress() {
		super("Eine Adresse bearbeiten");
	}

	public void actionPerformed(ActionEvent e) {
		new DialogPopup(db.getAddress(0));
	}
}

class DeleteAddress extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public DeleteAddress() {
		super("Eine Adresse löschen");
	}

	public void actionPerformed(ActionEvent e) {
		new DialogPopup();
	}
}

class AktionBeenden extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public AktionBeenden() {
		super("Beenden");
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}