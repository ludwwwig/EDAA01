package shapes;

public class Square extends Shape {
	private int side;
	public Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}
	public void draw() {
		System.out.println("Här ska vi egentligen rita en kvadrat med sidlängden " + side);
	}
}

