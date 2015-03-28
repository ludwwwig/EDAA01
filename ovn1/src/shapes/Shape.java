package shapes;

public abstract class Shape {
	protected int x;
	protected int y;
	
	protected Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int dx, int dy) {
		x = x + dx;
		y = y + dy; 
	}
	
	// övriga metoder
}

