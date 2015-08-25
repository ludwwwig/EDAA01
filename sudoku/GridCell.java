package sudoku;

import java.awt.Color;
import javax.swing.JTextField;

public class GridCell {
	private JTextField textField;
	private static Color GREY = new Color(230, 230, 230);
	
	public GridCell(int col, int row) {
		textField = new JTextField();
		if((col/3 + row/3) % 2 == 1)
			textField.setBackground(GREY);
	}

	public JTextField getTextField() {
		return textField;
	}
	
}
