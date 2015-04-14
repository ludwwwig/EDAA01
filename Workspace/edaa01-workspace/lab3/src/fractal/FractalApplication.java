package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(230, 50), new Point(50, 380), new Point(500, 475), 30);
	    new FractalView(fractals, "Fraktaler");
	}

}
