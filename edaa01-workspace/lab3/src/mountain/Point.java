package mountain;

public class Point {
	private double x, y;
	private Point joint1, joint2;

	/** Constructs and initializes a point at the specified (x,y) location. */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/*
	public void setJoint(Point joint, boolean index) {
		if(joint == null)
			return;
		if(index)
			joint1 = joint;
		else
			joint2 = joint;
	}
	
	public Point getJoint(boolean index) {
		if(index)
			return joint1;
		else
			return joint2;
	}
	*/
	/** 
	 * Returns the x coordinate. 
	 * @return the x coordinate
	 */
	public double getX() {
		return x;
	}

	/** 
	 * Returns the y coordinate. 
	 * @return the y coordinate
	 */
	public double getY() {
		return y;
	}
	
	/** Indicates whether some other object is "equal to" this one.
	 * @param  obj the reference object with which to compare
	 * @return  true if this object is the same as the obj argument; false otherwise
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		} else {
			return false;
		}
	}

	/** Moves this point to the specified (x,y) location.
	 * post: the point is moved to the location (x,y)
	 * @param  x the x coordinate of the new location
	 * @param  y the y coordinate of the new location
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
