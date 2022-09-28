import processing.core.PApplet;

public class Circle {
	private double x,y,r;
	
	//center x,y and radius
	public Circle(double xi, double yi, double ri) {
		x = xi;
		y = yi;
		r = ri;
	}
	
	//i like arrays
	public Circle(double[] d) {
		this(d[0],d[1],d[2]);
	}
	
	//draw
	public void draw(PApplet p) {
		p.circle((float)x, (float)y, (float)r*2);
	}
	
	public boolean intersects(Circle c) {
		return  Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2)) < r + c.r && !contains(c);
	}
	
	public boolean contains(double x, double y) {
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) < r;
	}
	
	public boolean contains(Circle c) {
		return (Math.max(r, c.r) > Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2)) + Math.min(r, c.r));
	}
	
	public boolean touches(Circle c) {
		return Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2)) == r + c.r;
	}
	
	public double getArea() {
		return Math.PI*r*r;
	}
	
	public double getPerimeter() {
		return Math.PI*2*r;
	}
	
	public double equalSize(Circle c) {
		return r = c.r;
	}
	//(x, y) radius = r
	public String toString() {
		return "(" + x + ", " + y + ")" + "radius = " + r;
	}
}
