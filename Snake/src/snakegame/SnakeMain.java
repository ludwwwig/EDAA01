package snakegame;
import java.awt.*;

import javax.swing.*;

public class SnakeMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6985178138097906409L;
	GamePanel gp = new GamePanel();
	private boolean running = true;
	//private java.util.Timer timer;

	
	public SnakeMain() {
		super("Snake");
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(640, 480);
		application.setTitle("Snake");
		application.setVisible(true);
		application.add(gp, BorderLayout.CENTER);
		gp.update();
		gp.repaint();
		
	}
	
	public static void main(String[] args) {
		new SnakeMain();
	}
	
	/*public void gameLoop() {
		timer = new java.util.Timer();
		timer.schedule(new Loop(), 0, 1000/60);
	}*/
	
	/*public void draw(Graphics g, int[][] board) {
		int[][] a = s.getCoords();
		for(int i = 0; i < a.length; i++) {
			paintComponents(g);
		}
	}*/
	
	private class GamePanel extends JPanel {
		private int width, height;
		private int[][] board;
		Snake s;
		
		public GamePanel() {
			width = 300;
			height = 300;
			board = new int[width][height];
			s = new Snake(3);
		}
		
		public void update() {
			s.forward();
			//lägg till äpple
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.red);
			g.drawLine(0, 20, 30, 0);
		}
	}
}
