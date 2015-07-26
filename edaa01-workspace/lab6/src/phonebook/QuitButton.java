package phonebook;
import javax.swing.*;

import java.awt.event.*;

public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Yes", "No"};
		int choice = JOptionPane.showOptionDialog(gui, 
				"Would you like to save?",
				"Save",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		if(choice == JOptionPane.YES_OPTION) {
			String fileName = JOptionPane.showInputDialog("Please enter a name.");
			if(fileName == null) return;
			phoneBook.writeData(fileName);
		} else if(choice == JOptionPane.CLOSED_OPTION) {
			return;
		}
		System.exit(0);
	}
}