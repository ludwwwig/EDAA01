package phonebook;
import javax.swing.*;

import java.awt.event.*;
import java.util.List;

public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNumbersMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find number(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Enter name");
		if(name == null) return;
		if(name.equals("")) return;
		List<String> numbers = phoneBook.findNumber(name);
		if(!numbers.isEmpty()) {
			gui.getTextArea().append("Numbers found for " + name + ":\n");
			for(String number : numbers) {
				gui.getTextArea().append("   " + number + "\n");
			}
		} else {
			gui.getTextArea().append("No numbers found for " + name + ".\n");
		}
	}
}