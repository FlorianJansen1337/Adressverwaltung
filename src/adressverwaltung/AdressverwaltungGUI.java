package adressverwaltung;

import java.awt.*;
import javax.swing.*;

public class AdressverwaltungGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private Dimension screenSize;
	private Dimension appSize;
	private Point locationOnScreen;
	private JPanel toolbar;
	private Menu menu;

	public static void main(String[] args) {
		AdressverwaltungGUI gui = new AdressverwaltungGUI();
		gui.setSize(800, 600);
		gui.centerWindow();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setResizable(false);
		gui.setVisible(true);
	}

	public AdressverwaltungGUI() {
		super("hier könnte ein Titel stehen.");
		toolbar = new JPanel();
		toolbar.setLayout(new BorderLayout());
		menu = new Menu();
		toolbar.add(menu.hauptmenu);
		this.add(toolbar, BorderLayout.NORTH);
	}
		

	private void centerWindow() {
		locationOnScreen = new Point();
		appSize = getSize();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		locationOnScreen.x = (screenSize.width - appSize.width) / 2;
		locationOnScreen.y = (screenSize.height - appSize.height) / 2;

		setLocation(locationOnScreen);
	}
}
