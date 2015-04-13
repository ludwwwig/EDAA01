package mountain;

import fractal.*;

public class Mountain extends Fractal {
	private double dev;
	
	public Mountain(double deviation) {
		dev = deviation;
	}
	
	public String getTitle() {
		return "Bergmassiv";
	}
	
	public void draw(TurtleGraphics turtle) {
		fractalTriangle(turtle, order, new Point(230, 50), new Point(100, 350), new Point(500, 375));
	}
	
	private static double randFunc(double dev) {
        double t = dev * Math.sqrt(-2 * Math.log(Math.random()));
        if (Math.random() < 0.5) {
        	t = -t; 
        }
        return t; 
    }
	
	private void fractalTriangle(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3) {
		if(order == 0) {
			drawTriangle(turtle, p1, p2, p3);
		} else {
			double deviation = dev/(Math.pow(2, order));
			double a1 = randFunc(deviation);
			double a2 = randFunc(deviation);
			double b1 = randFunc(deviation);
			double b2 = randFunc(deviation);
			double c1 = randFunc(deviation);
			double c2 = randFunc(deviation);
			
			Point p4 = new Point(a1 + (p1.getX()+p2.getX())/2, a2 + (p1.getY()+p2.getY())/2);
			Point p5 = new Point(b1 + (p1.getX()+p3.getX())/2, b2 + (p1.getY()+p3.getY())/2);
			Point p6 = new Point(c1 + (p2.getX()+p3.getX())/2, c2 + (p2.getY()+p3.getY())/2);
			
			fractalTriangle(turtle, order-1, p1, p4, p5);
			fractalTriangle(turtle, order-1, p4, p2, p6);
			fractalTriangle(turtle, order-1, p5, p6, p3);
			fractalTriangle(turtle, order-1, p4, p5, p6);
		}
	}

	private void drawTriangle(TurtleGraphics turtle, Point p1, Point p2, Point p3){
		turtle.moveTo(p1.getX(), p1.getY());
		turtle.forwardTo(p2.getX(), p2.getY());
		turtle.forwardTo(p3.getX(), p3.getY());
		turtle.forwardTo(p1.getX(), p1.getY());
	}
}
