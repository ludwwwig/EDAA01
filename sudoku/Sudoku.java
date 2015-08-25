package sudoku;

import java.io.File;
import java.util.Scanner;

public class Sudoku {
	private int[][] grid;
	
	/**
	 * Creates a new, empty sudoku object.
	 */
	public Sudoku() {
		grid = new int[9][9];
	}
	
	/**
	 * Returns the content of the cell specified by column and row.
	 * @param col Column index
	 * @param row Row index
	 * @return the number in the specified cell.
	 */
	public int get(int col, int row) {
		return grid[col][row];
	}
	
	/**
	 * Sets the specified cell to a new value.
	 * @param col Column index
	 * @param row Row index
	 * @return true if cell was successfully set
	 */
	public void set(int col, int row, int val) {
		grid[col][row] = val;
	}
	
	/**
	 * Make an attempt to solve this sudoku.
	 * @return true if the sudoku was solvable
	 */
	public boolean solve() {
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if(grid[j][i] != 0) //om cellen inte är tom
					if(!isGoodFormat(j, i, grid[j][i])) //undersök om talet i cellen har bra format
						return false; //om dåligt format så går sudokut inte att lösa
		
		return solve(0, 0);
	}
	
	private boolean solve(int i, int j) {
		if(grid[i][j] == 0) { //om det inte finns ett tal i cellen
			int counter = 1;
			boolean solved;
			while(counter < 10) {
				if(isGoodFormat(i, j, counter)) {
					set(i, j, counter);
					if(i < 8)		solved = solve(i+1, j);	//flytta till nästa kolonn
					else if(j < 8)	solved = solve(0, j+1);	//flytta till nästa rad, och till första kolonnen
					else			return true; 			//i = j = 8 och bra format => sudoku är löst.
					
					if(solved) return true;
					set(i, j, 0);
				}
				counter++;
			}
			set(i, j, 0);
			return false;	//kunde inte hitta något nummer som passade
			
		} else { //om det redan finns ett tal i cellen
			if(!isGoodFormat(i, j, grid[i][j])){ return false;}
			if(i < 8)		return solve(i+1, j);	//flytta till nästa kolonn
			else if(j < 8)	return solve(0, j+1);	//flytta till nästa rad, och till första kolonnen
			else			return true; 			//i = j = 8 och bra format => sudoku är löst.
		}
	}
	
	private boolean isGoodFormat(int col, int row, int val) {
		if(val < 1 || val > 9) return false; //är talet mellan 1 och 9?
		if(!isColGood(col, row,  val)) return false; //finns talet redan i kolonnen?
		if(!isRowGood(col, row, val)) return false; //finns talet redan i raden?
		if(!isBoxGood(col, row, val)) return false; //finns talet redan i boxen?
		return true; //om svaret är nej på alla så är det bra format.
	}
	
	private boolean isColGood(int col, int row, int val) {
		for(int row2 = 0; row2 < 9; row2++)
			if(grid[col][row2] == val && row != row2)
				return false;
		return true;
	}
	
	private boolean isRowGood(int col, int row, int val) {
		for(int col2 = 0; col2 < 9; col2++)
			if(grid[col2][row] == val && col != col2)
				return false;
		return true;
	}
	
	private boolean isBoxGood(int col, int row, int val) {
		int colStart = (col/3)*3;	//heltalsdivison innebär att indexet för cellen
		int rowStart = (row/3)*3;	//högst upp till vänster i boxen fås
		for(int row2 = rowStart; row2 < rowStart + 3; row2++)
			for(int col2 = colStart; col2 < colStart + 3; col2++)
				if(grid[col2][row2] == val && !(col == col2 && row == row2))
					return false;
		return true;
	}
	
	/**
	 * Reads a text file with the correct format (9x9 numbers arranged
	 * like the string obtained from calling .toString() on this object) 
	 * and replaces the current sudoku with the one read from the file.
	 * @param fileName The name of the file
	 */
	public void readFile(String fileName) {
		try {
			Scanner in = new Scanner(new File(fileName));
			int[][] readFile = new int[9][9];
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
					readFile[j][i] = in.nextInt();
			in.close();
			
			boolean wasReplaced = this.replaceWith(readFile);
			if(!wasReplaced)
				System.out.println("The read file has the wrong format. The grid is unchanged.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Replaces current sudoku with a new sudoku. If the provided 
	 * matrix is not 9x9, the current sudoku will not be replaced.
	 * @param newGrid An integer square matrix with 9x9 elements
	 * @return true if this sudoku was successfully replaced
	 */
	public boolean replaceWith(int[][] newGrid) {
		if(newGrid.length == 9)	{			//check if width is correct
			for(int i = 0; i < 9; i++)		//check if height is correct
				if(newGrid[i].length != 9)	
					return false;	//if jagged or non-square, do not replace
		} else return false;
			
		grid = newGrid;	//newSudoku is both square and non-jagged, and may replace current grid
		return true;
	}
	
	/**
	 * Sets all cells to be empty.
	 */
	public void clear() {
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				this.set(j, i, 0);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(grid[j][i]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
