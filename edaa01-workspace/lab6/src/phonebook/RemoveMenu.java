package phonebook;
import javax.swing.*;

import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public RemoveMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Remove");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Enter name");
		if(name == null) return;
		if(name.equals("")) return;
		if(phoneBook.remove(name)){
			gui.getTextArea().append(name + " has now been removed.\n");
		} else {
			gui.getTextArea().append("Could not find person with the name " + name + ".\n");
		}
	}
}
