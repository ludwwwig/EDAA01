package snakegame;

public class Snake {
	private int length;
	private SnakePart[] body;
	private int direction; //N-E-S-W : 0-1-2-3
	
	public Snake(int length) {
		this.length = length;
		body = new SnakePart[length];
		for(int i = 0; i < length; i++) {
			addPart(i);
		}
		direction = 0;
	}
	
	public void forward() {
		for(int i = 1; i < body.length - 1; i++) {
			body[i].x = body[i+1].x;
			body[i].y = body[i+1].y;
		}
		body[0].x = (int) Math.sin((Math.PI/2) * direction);
		body[0].y = (int) Math.cos((Math.PI/2) * direction);
		//undersök om utanför fönster och om krock med sig själv
	}
	
	public int[][] getCoords() {
		int[][] result = new int[body.length][2];
		for(int i = 0; i < body.length; i++) {
			result[i] = body[i].getCoords();
		}
		return result;
	}
	
	public void addPart(int index) {
		body[index] = new SnakePart(index, 100);
	}
	
	private class SnakePart {
		private int x;
		private int y;
		public SnakePart(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int[] getCoords() {
			return new int[]{x, y};
		}
	}
}