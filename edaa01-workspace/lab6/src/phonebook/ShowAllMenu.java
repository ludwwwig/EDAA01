package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.Set;

public class ShowAllMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public ShowAllMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Show all");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Set<String> names = phoneBook.names();
		gui.getTextArea().append("Found the following names: \n");
		for(String name : names) {
			gui.getTextArea().append("   " + name + "\n");
		}
	}

}
