package adressverwaltung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogPopupPrint extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	AdressDatenbank db = new AdressDatenbank();
	AdressverwaltungUI ui = new AdressverwaltungUI();

	private JButton quitButton;

	public DialogPopupPrint(int adressenZeile) {
		int anzahlFelder = Adresse.adressenUeberschrift.length;
		Adresse address = new Adresse(null, null, null, null, null, null);

		JPanel text = new JPanel();
		JPanel text2 = new JPanel();
		JPanel buttons = new JPanel();
		quitButton = new JButton("OK");

		this.setLayout(new BorderLayout());
		text.setLayout(new GridLayout(anzahlFelder, 1));
		text2.setLayout(new GridLayout(anzahlFelder, 1));
		buttons.setLayout((new GridLayout(1, 2)));

		address = db.getAddress(adressenZeile);
		
		for (int i = 0; i < anzahlFelder; i++) {
			text.add(new JLabel(Adresse.adressenUeberschrift[i]));
			System.out.println(address.getAddress(i));
			text2.add(new JLabel(address.getAddress(i)));
		}
		quitButton.addActionListener(this);
		
		buttons.add(quitButton, BorderLayout.SOUTH);

		this.add(text, BorderLayout.WEST);
		this.add(text2, BorderLayout.EAST);
		this.add(buttons, BorderLayout.SOUTH);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setModal(true);
		
		ui.printAllAddresses();

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quitButton) {
			this.setVisible(false);
		}
	}
}
