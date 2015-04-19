
public class TowerOfHanoi {
	private int noDisks;   // antal skivor
	
	/** Skapar ett torn med noDisks skivor */
	public TowerOfHanoi(int n) {
		noDisks = n;
	}
	
	public void move() {
		move(noDisks, 1, 2, 3);
	}
	
	public void move(int n, int start, int dest, int temp) {
		if (n == 1) {
			System.out.println("Move from " + start + " to " + dest);
		} else {
			move(n - 1, start, temp, dest);
			System.out.println("Move from " + start + " to " + dest);
			move(n - 1, temp, dest, start);
		}
	}
	
	public static void main(String[] args) {
		new TowerOfHanoi(4).move();
	}
}
