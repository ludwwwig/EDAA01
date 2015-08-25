package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClearButton extends JButton implements ActionListener {
	private SudokuGUI gui;
	
	public ClearButton(SudokuGUI gui) {
		super("Clear");
		this.gui = gui;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.clear();
	}
	
}

