package sudoku;
import java.awt.*;
import java.util.*;

import javax.swing.*;

public class SudokuGUI extends JFrame {
	private Sudoku sudoku;
	private GridCell[][] textGrid;
	
	/**
	 * Constructs and opens a window with a new graphical user interface
	 * that displays a sudoku.
	 * @param sudoku The sudoku that is displayed by this GUI
	 */
	public SudokuGUI(Sudoku sudoku) {
		super("Sudoku");
		this.sudoku = sudoku;
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		setPreferredSize(new Dimension(220, 270));
		
		textGrid = new GridCell[9][9];
		JPanel gridPanel = new JPanel(new GridLayout(9,9,-5,-5));
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				GridCell g = new GridCell(j, i);
				textGrid[j][i] = g;
				gridPanel.add(g.getTextField());
			}
		}
		
		add(gridPanel,BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		southPanel.add(new SolveButton(this.sudoku, this));
		southPanel.add(new ClearButton(this));
		
		add(southPanel,BorderLayout.SOUTH);
		
		this.update();
		pack();
		setVisible(true);
	}
	
	/**
	 * Reads text entered into the cells, and, if it is in an appropriate 
	 * format (integer in the range 1-9), enters it into the sudoku.
	 */
	public void readCells() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				String s = textGrid[j][i].getTextField().getText();
				if(s.toCharArray().length != 1) { //undersök om textfältet har exakt ett tecken
					sudoku.set(j, i, 0); //om inte, så är det fel format
					textGrid[j][i].getTextField().setText(null);
				} else {
					int inputInt = s.toCharArray()[0] - 48; //char 0 = 48, gör om från string till int
					if(inputInt > 0 && inputInt < 10) {
						sudoku.set(j, i, inputInt);
					} else {
						textGrid[j][i].getTextField().setText(null); //om inte ett tal i intervallet 1-9 så fel format
					}
				}
			}
		}
	}
	
	/**
	 * Updates the text in each cell to match the current sudoku grid.
	 */
	public void update() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				JTextField t = textGrid[j][i].getTextField();
				if(sudoku.get(j, i) != 0)
					t.setText(((Integer) sudoku.get(j, i)).toString());
				else
					t.setText(null);
			}
		}
	}
	
	/**
	 * Clears all cells and makes them empty.
	 */
	public void clear() {
		sudoku.clear();
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				textGrid[j][i].getTextField().setText(null);;
	}
	
}
