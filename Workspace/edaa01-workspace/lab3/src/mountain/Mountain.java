package mountain;

import java.util.LinkedList;
import fractal.*;

public class Mountain extends Fractal {
	Point a, b, c;
	
	double dev;
	LinkedList<Side> lista;
	
	public Mountain(Point a, Point b, Point c, double dev){
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		lista = new LinkedList<Side>();
	}
	
	public String getTitle() {
		return "Mountain";
	}
	public void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c) {
		/*if (order == 1)
			return;

		Point ab = new Point((a.getX() + b.getX())/2, (a.getY() + b.getY())/2);
		Point bc = new Point((b.getX() + c.getX())/2, (b.getY() + c.getY())/2);
		Point ac = new Point((a.getX() + c.getX())/2, (a.getY() + c.getY())/2);
		turtle.moveTo(ab.getX(), ab.getY());
		turtle.forwardTo(bc.getX(), bc.getY());
		turtle.forwardTo(ac.getX(), ac.getY());
		turtle.forwardTo(ab.getX(), ab.getY());

		drawTriangle(order -1, turtle, a, ab, ac);
		drawTriangle(order -1, turtle, b, ab, bc);
		drawTriangle(order -1, turtle, c, ac, bc);
		drawTriangle(order -1, turtle, ab,ac,bc);*/
		turtle.moveTo(a.getX(), a.getY());
		turtle.forwardTo(b.getX(), b.getY());
		turtle.forwardTo(c.getX(), c.getY());
		turtle.forwardTo(a.getX(), a.getY());
	}
	public void draw(TurtleGraphics turtle) {
		/*turtle.moveTo(a.getX(), a.getY());
		turtle.forwardTo(b.getX(), b.getY());
		turtle.forwardTo(c.getX(), c.getY());
		turtle.forwardTo(a.getX(), a.getY());
		drawTriangle(order+1, turtle, a, b, c);*/
		/*if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			secondDraw(order, turtle, a, b, c, this.dev);
		
	}*/
		secondDraw(order,turtle, a, b, c, dev);
	}
	public void secondDraw(int iteration, TurtleGraphics turtle, Point a, Point b, Point c, double dev) {
		if (iteration <= 0)	{
			drawTriangle(turtle, a, b, c);
			return;
		}
		
		Side sa = getSide(a,b, dev);
		Side sb = getSide(b,c, dev);
		Side sc = getSide(a,c, dev);
		
		secondDraw(iteration -1, turtle, a, sa.m, sc.m, dev/2);
		secondDraw(iteration -1, turtle, sa.m, sb.m, sc.m, dev/2);
		secondDraw(iteration -1, turtle, b, sa.m, sb.m, dev/2);
		secondDraw(iteration -1, turtle, c, sb.m, sc.m, dev/2);
	}
	private Side getSide(Point a, Point b, double dev) {
		Point mab = new Point((a.getX() + b.getX())/2, (a.getY() + b.getY())/2 + RandomUtilities.randFunc(dev));
		Side sa = new Side(a, b, mab);
		boolean add = true;
		for (Side s : lista)
			if (s.Equals(sa)) {
				sa.m = s.m;
				//lista.remove(s);
				add = false;
				break;
			}
		if (add) lista.add(sa);
		return sa;
	}
	private class Side {
		private Point a, b, m;
		
		private Side(Point a, Point b, Point m) {
			this.a = a;
			this.b = b;
			this.m = m;
		}
		
		private boolean Equals(Side s) {
			return ((a == s.a && b == s.b) || (a == s.b && b == s.a));
		}
		
	}
}


/*int lines = (int) Math.pow(2, iteration++);
double xAB = b.getX() - a.getX();
double xBC = c.getX() - b.getX();
double xCA = a.getX() - c.getX();

double yAB = 1*(b.getY() - a.getY());
double yBC = 1*(c.getY() - b.getY());
double yCA = 1*(a.getY() - c.getY());

for (int i = 0; i <= lines; ++i) {
	//Dra tre linjer per iteration
	turtle.moveTo(a.getX() + i*xAB/(lines) , a.getY() + i*yAB/(lines));
	turtle.forwardTo(c.getX() + (lines-i)*xCA/(lines), c.getY() + (lines-i)*yCA/(lines));
	turtle.moveTo(c.getX() + (i)*xCA/(lines) , c.getY() + (i)*yCA/(lines));
	turtle.forwardTo(b.getX() + (lines-i)*xBC/(lines), b.getY() + (lines-i)*yBC/(lines));
	turtle.moveTo(b.getX() + i*xBC/(lines) , b.getY() + i*yBC/(lines));
	turtle.forwardTo(a.getX() + (lines-i)*xAB/(lines), a.getY() + (lines-i)*yAB/(lines));

}*/