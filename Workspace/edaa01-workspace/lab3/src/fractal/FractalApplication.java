package fractal;
import mountain.Mountain;
import koch.Koch;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);
	    fractals[0] = new Mountain(new Point(30,30) , new Point(500,500), new Point(100,550), 50);
		new FractalView(fractals, "Fraktaler");
	}

}
