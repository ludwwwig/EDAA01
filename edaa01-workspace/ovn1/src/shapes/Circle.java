package shapes;

public class Circle extends Shape {
	private int radius;
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	public void draw() {
		System.out.println("Här ska vi egentligen rita en cirkel med radien " + radius);
	}
}

