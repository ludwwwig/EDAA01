package sudoku;

public class Test_Sudoku {
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				s.set(j, i, (j+i)%9 + 1);
			}
		}
		
		/*s.replaceWith(new int[][]{
					{1, 4, 7, 8, 9, 0, 0, 0, 0},
					{2, 5, 8, 9, 7, 0, 0, 0, 0},
					{3, 6, 9, 7, 0, 0, 0, 0, 0},
					{4, 1, 2, 0, 0, 0, 0, 0, 0},
					{5, 2, 1, 0, 0, 0, 0, 0, 0},
					{6, 3, 5, 0, 0, 0, 0, 0, 0},
					{7, 8, 4, 0, 0, 0, 0, 0, 0},
					{8, 9, 6, 0, 0, 0, 0, 0, 0},
					{9, 7, 3, 0, 0, 0, 0, 0, 0}});*/
		
		//s.set(2, 2, 5);
		//System.out.println(s.solve());
		
		System.out.println(s);
	}
}