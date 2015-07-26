package phonebook;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class FindNamesMenu extends JMenuItem implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;
	
	public FindNamesMenu(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Find name(s)");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String number = JOptionPane.showInputDialog("Enter number");
		if(number == null) return;
		if(number.equals("")) return;
		List<String> names =  phoneBook.findNames(number);
		if(!names.isEmpty()) {
			gui.getTextArea().append("Persons with the number '" + number + "': \n");
			for(String name : names) {
				gui.getTextArea().append("   " + name + "\n");
			}
		} else {
			gui.getTextArea().append("No persons with the number " + number + " found.\n");
		}	
	}
}