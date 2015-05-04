package snakegame;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Snake {
	private ArrayList<SnakePart> body;
	private int direction; //S-E-N-W : 0-1-2-3
	private boolean hasCollided = false;
	
	public Snake(int length) {
		body = new ArrayList<SnakePart>();
		for(int i = 0; i < length; i++) { //add parts
			body.add(new SnakePart(SnakeMain.convert((SnakeMain.WIDTH/2)), SnakeMain.convert(SnakeMain.HEIGHT/2)));
		}
		direction = 1;
	}
	
	public void setDirection(int direction) {
		if((direction + 2) % 4 != this.direction)
			this.direction = direction;
	}
	
	public boolean hasCollided() {
		return hasCollided;
	}	
	
	private void checkCollision() {
		for(int i = 1; i < body.size(); i++) {
			if(body.get(0).x == body.get(i).x && body.get(0).y == body.get(i).y){
				hasCollided = true;
			}
		}
	}
	public void forward() {
		for(int i = body.size()-1; i > 0; i--) {
			body.get(i).x = body.get(i-1).x;
			body.get(i).y = body.get(i-1).y;
		}
		body.get(0).x += SnakeMain.convert((int) Math.sin((Math.PI/2) * direction));
		body.get(0).y += SnakeMain.convert((int) Math.cos((Math.PI/2) * direction));
		/*if(direction == 0) {
			body.get(0).y += SnakeMain.convert(1);
		} else if (direction == 1) {
			body.get(0).x += SnakeMain.convert(1);
		} else if (direction == 1) {
			body.get(0).y -= SnakeMain.convert(1);
		} else {
			body.get(0).x -= SnakeMain.convert(1);
		}*/
		
		checkCollision();
	}
	
	public int[][] getCoords() {
		//undersök också om utanför fönstret
		int[][] result = new int[body.size()][2];
		for(int i = 0; i < body.size(); i++) {
			result[i] = body.get(i).getCoords();
		}
		return result;
	}
	
	public int getLength() {
		return body.size();
	}
	
	public void paint(Graphics g, Color c) {
		for(int i = 0; i < body.size(); i++) {
			g.setColor(c);
			int[][] coords = getCoords();
			g.fillRect(coords[i][0], coords[i][1], SnakeMain.cellSize, SnakeMain.cellSize);
		}
	}
	
	private class SnakePart {
		private int x;
		private int y;
		public SnakePart(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int[] getCoords() {
			return new int[] {x, y};
		}
	}
}