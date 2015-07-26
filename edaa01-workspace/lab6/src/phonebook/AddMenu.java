package phonebook;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public AddMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Add");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog("Enter name");
		if(name == null) return;
		if(name.equals("")) return;
		String number = JOptionPane.showInputDialog("Enter number");
		if(number == null) return;
		if(number.equals("")) return;
		if(phoneBook.put(name, number)){
			gui.getTextArea().append(name + " has now been added.\n");
		} else {
			gui.getTextArea().append(name + " has already been added with this number.\n");
		}
		
	}
}
