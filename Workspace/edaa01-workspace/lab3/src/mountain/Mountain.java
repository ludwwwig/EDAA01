package mountain;

import fractal.*;
import java.util.LinkedList;

public class Mountain extends Fractal {
	private Point a, b, c;
	private double dev;
	private LinkedList<Side> sideList;
	
	public Mountain(Point a, Point b, Point c, double deviation) {
		this.a = a;
		this.b = b;
		this.c = c;
		dev = deviation;
		sideList = new LinkedList<Side>();
	}
	
	public String getTitle() {
		return "Bergmassiv";
	}
	
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, a, b, c, dev);
	}
	
	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c, Double dev) {
		if(order == 0) {
			drawTriangle(turtle, a, b, c);
		} else {
			double aDev = RandomUtilities.randFunc(dev);
			double bDev = RandomUtilities.randFunc(dev);
			double cDev = RandomUtilities.randFunc(dev);
			
			Point abMid = new Point((a.getX()+b.getX())/2, aDev + (a.getY()+b.getY())/2);
			Point acMid = new Point((a.getX()+c.getX())/2, bDev + (a.getY()+c.getY())/2);
			Point bcMid = new Point((b.getX()+c.getX())/2, cDev + (b.getY()+c.getY())/2);
			Side abSide = new Side(a, b, abMid);
			Side acSide = new Side(a, c, acMid);
			Side bcSide = new Side(b, c, bcMid);
			
			Point check; 
			if((check = findMid(abSide)) != null) {
				abMid = check;
				sideList.remove(check);
			} else
				sideList.add(abSide);
			if ((check = findMid(acSide)) != null) {
				acMid = check;
				sideList.remove(check);
			} else
				sideList.add(acSide);
			if ((check = findMid(bcSide)) != null) {
				bcMid = check;
				sideList.remove(check);
			} else 
				sideList.add(bcSide);
			
			fractalTriangle(turtle, order-1, a, abMid, acMid, dev/2);
			fractalTriangle(turtle, order-1, abMid, b, bcMid, dev/2);
			fractalTriangle(turtle, order-1, acMid, bcMid, c, dev/2);
			fractalTriangle(turtle, order-1, abMid, acMid, bcMid, dev/2);
		}
	}
	
	private void drawTriangle(TurtleGraphics turtle, Point p1, Point p2, Point p3){
		turtle.moveTo(p1.getX(), p1.getY());
		turtle.forwardTo(p2.getX(), p2.getY());
		turtle.forwardTo(p3.getX(), p3.getY());
		turtle.forwardTo(p1.getX(), p1.getY());
	}
	
	private Point findMid(Side s) {
		for(Side side : sideList) {
			if(side.equals(s))
				return side.m;
		}
		return null;
	}
	
	private class Side {
		Point a, b, m;
		public Side(Point p1, Point p2, Point mid) {
			a = p1;
			b = p2;
			m = mid;
		}
		public boolean equals(Side s) {
			return ((a == s.a && b == s.b) || (b == s.a && a == s.b));
		}
	}
}
