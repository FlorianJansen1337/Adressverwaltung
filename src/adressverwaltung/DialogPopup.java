package adressverwaltung;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogPopup extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	AdressDatenbank db = new AdressDatenbank();

	public Adresse address = new Adresse(null, null, null, null, null, null);

	private JButton confirmButton;
	private JButton quitButton;

	private JTextField fieldVorname;
	private JTextField fieldNachname;
	private JTextField fieldStraﬂe;
	private JTextField fieldHnr;
	private JTextField fieldPlz;
	private JTextField fieldOrt;
	
	public DialogPopup(Adresse adresse) {
		initDialog();
		this.fieldVorname.setText(adresse.vorname);
		this.fieldNachname.setText(adresse.nachname);
		this.fieldStraﬂe.setText(adresse.straﬂe);
		this.fieldHnr.setText(adresse.hausnummer);
		this.fieldPlz.setText(adresse.plz);
		this.fieldOrt.setText(adresse.ort);

		this.setVisible(true);
	}
	
	public DialogPopup() {
		initDialog();
		this.setVisible(true);
	}

	private void initDialog() {
		int anzahlFelder = Adresse.adressenUeberschrift.length;

		JPanel text = new JPanel();
		JPanel textField = new JPanel();
		JPanel buttons = new JPanel();
		confirmButton = new JButton("OK");
		quitButton = new JButton("Abbrechen");

		this.setLayout(new BorderLayout());
		text.setLayout(new GridLayout(anzahlFelder, 1));
		textField.setLayout(new GridLayout(anzahlFelder, 1));
		buttons.setLayout((new GridLayout(1, 2)));

		for (int i = 0; i < anzahlFelder; i++) {
			text.add(new JLabel(Adresse.adressenUeberschrift[i]), BorderLayout.WEST);
		}
		fieldVorname = new JTextField(10);
		fieldNachname = new JTextField(10);
		fieldStraﬂe = new JTextField(10);
		fieldHnr = new JTextField(10);
		fieldPlz = new JTextField(10);
		fieldOrt = new JTextField(10);
		textField.add(fieldVorname, BorderLayout.EAST);
		textField.add(fieldNachname, BorderLayout.EAST);
		textField.add(fieldStraﬂe, BorderLayout.EAST);
		textField.add(fieldHnr, BorderLayout.EAST);
		textField.add(fieldPlz, BorderLayout.EAST);
		textField.add(fieldOrt, BorderLayout.EAST);

		quitButton.addActionListener(this);
		confirmButton.addActionListener(this);

		buttons.add(confirmButton, BorderLayout.SOUTH);
		buttons.add(quitButton, BorderLayout.SOUTH);

		this.add(text, BorderLayout.WEST);
		this.add(textField, BorderLayout.EAST);
		this.add(buttons, BorderLayout.SOUTH);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);

		this.pack();
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quitButton) {
			this.setVisible(false);
		} else if (e.getSource() == confirmButton) {
			address = new Adresse(fieldVorname.getText(), fieldNachname.getText(), fieldStraﬂe.getText(), fieldHnr.getText(),
					fieldPlz.getText(), fieldOrt.getText());
			db.newAddress(address);
			this.setVisible(false);
		}
	}
}
