package snakegame;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import queue.FifoQueue;

public class SnakeMain extends JFrame {
	GamePanel gp = new GamePanel();
	private boolean running = true;
	public static int cellSize = 5;
	public static int WIDTH = 100; //antal celler, inte pixlar
	public static int HEIGHT = 100; //antal celler, inte pixlar
	private FifoQueue<Integer> actionQueue = new FifoQueue<Integer>();
	
	public SnakeMain() {
		super("Snake");
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(WIDTH*cellSize, HEIGHT*cellSize + 20);
		application.setTitle("Snake");
		application.add(gp, BorderLayout.CENTER);
		application.setVisible(true);
		application.setResizable(false);
		while(running) {
			gp.update();
			gp.repaint();
	
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new SnakeMain();
	}
	
	public static int convert(int cellCoordinates) {
		return cellCoordinates*cellSize;
	}
	
	private class GamePanel extends JPanel {
		private Random r = new Random();
		private int width, height;
		private int[][] board;
		Snake s;
		Snake s2;
		InputMap imap = getInputMap();
		ActionMap amap = getActionMap();
		
		public GamePanel() {
			super();
			
			imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");
			amap.put("down", new MoveAction(0));
			imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");
			amap.put("right", new MoveAction(1));
			imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");
			amap.put("up", new MoveAction(2));
			imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
			amap.put("left", new MoveAction(3));
			
			setBackground(Color.white);
			board = new int[width][height];
			s = new Snake(150);
			s2 = new Snake(23);
		}
		
		class MoveAction extends AbstractAction {
			private int dir;
			public MoveAction(int direction) {
				dir = direction;
			}
			
			public void actionPerformed(ActionEvent e) {
				actionQueue.add(dir);
			}
		}
		
		public void update() {
			if(r.nextInt(100) < 30)
				s2.setDirection(r.nextInt(4));
			if(actionQueue.peek() != null){
				s.setDirection(actionQueue.poll());
				
			}
			s.forward();
			s2.forward();
			if(s.hasCollided())
				running = !running;
			
			//lägg till äpple: if(appleEaten) spawnApple();
		}
		
		public void paintComponent(Graphics g){
			s.paint(g, Color.black);
			s2.paint(g, Color.red);
			/*int[][] coords = s.getCoords(); 
			for(int i = 0; i < s.getLength(); i++) {
				if(running)
					g.setColor(Color.black);
				else
					g.setColor(Color.red);
				g.fillRect(coords[i][0], coords[i][1], cellSize, cellSize);
			}*/
		}
	}
}
