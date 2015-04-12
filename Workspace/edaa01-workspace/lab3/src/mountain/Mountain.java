package mountain;
import java.lang.Math;
import fractal.*;

public class Mountain extends Fractal {
	Point a, b, c;
	int iteration;
	
	public Mountain(Point a, Point b, Point c){
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		iteration = 0;
	}
	
	public String getTitle() {
		return "Mountain";
	}
	
	public void draw(TurtleGraphics turtle) {	
		int lines = (int) Math.pow(2, iteration++);
		double xAB = b.getX() - a.getX();
		double xBC = c.getX() - b.getX();
		double xCA = a.getX() - c.getX();
		
		double yAB = 1*(b.getY() - a.getY());
		double yBC = 1*(c.getY() - b.getY());
		double yCA = 1*(a.getY() - c.getY());
		
		for (int i = 1; i <= lines; ++i) {
			//Dra tre linjer per iteration
			turtle.moveTo(a.getX() + i*xAB/(lines) , a.getY() + i*yAB/(lines));
			turtle.forwardTo(c.getX() + (lines-i)*xCA/(lines), c.getY() + (lines-i)*yCA/(lines));
			turtle.moveTo(c.getX() + (i)*xCA/(lines) , c.getY() + (i)*yCA/(lines));
			turtle.forwardTo(b.getX() + (lines-i)*xBC/(lines), b.getY() + (lines-i)*yBC/(lines));
			turtle.moveTo(b.getX() + i*xBC/(lines) , b.getY() + i*yBC/(lines));
			turtle.forwardTo(a.getX() + (lines-i)*xAB/(lines), a.getY() + (lines-i)*yAB/(lines));

		}
	}
}
