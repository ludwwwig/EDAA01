package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SolveButton extends JButton implements ActionListener {
	private Sudoku s;
	private SudokuGUI gui;
	
	public SolveButton(Sudoku sudoku, SudokuGUI gui) {
		super("Solve");
		s = sudoku;
		this.gui = gui;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.readCells();
		boolean wasSolved = s.solve();
		if(wasSolved)
			gui.update();
		else
			JOptionPane.showMessageDialog(new JFrame(), "This sudoku is unsolvable.", "Unsolvable", JOptionPane.ERROR_MESSAGE);
	}

}
