import processing.core.PApplet;
//i like rectangles
public class Rectangle {
	public double x1,y1,x2,y2,centerX,centerY;
	
	//constructor
	public Rectangle(double xA, double yA, double xB, double yB) {
		x1 = Math.min(xA, xB);
		x2 = Math.max(xA, xB);
		y1 = Math.min(yA, yB);
		y2 = Math.max(yA, yB);
		centerX = (x1+x2)/2;
		centerY = (y1+y2)/2;
	}
	
	//alt constructor i like arrays
	public Rectangle(double[] p) {
		this(p[0], p[1], p[2], p[3]);
	}
	
	//get points i like arrays
	public double[][] getPoints() {
		return new double[][] {{x1,y1},{x2,y1},{x2,y2},{x1,y2}};
	}
	
	//draw
	public void draw(PApplet p) {
		p.rect((float)x1, (float)y1, (float)(x2 - x1), (float)(y2 - y1));
	}
	
	//intersect other rectangle
	public boolean intersects(Rectangle other) {
		return !(x1 > other.x2 || x2 < other.x1 || y1 > other.y2 || y2 < other.y1);
	}
	
	//contain a point
	public boolean contains(double x, double y) {
		return (x >= x1 && x <= x2) && (y >= y1 && y <= y2); 
	}
	
	//contain entirely
	public boolean contains(Rectangle other) {
		return !(x1 > other.x1 || x2 < other.x2 || y1 > other.y1 || y2 < other.y2);
	}
	
	//checks size
	public boolean equalSize(Rectangle other) {
		return (other.x2 - other.x1 == x2 - x1) && (other.y2 - other.y1 == y2 - y1);
	}
	
	//shift rectangle
	public void shift(float dx, float dy) {
		x1 += dx;
		y1 += dy;
		x2 += dx;
		y2 += dy;
		centerX += dx;
		centerY += dy;
	}
	
	//name
	public double getPerimeter() {
		return 2 * (x2 - x1) + 2 * (y2 - y1);
	}
	
	//name
	public double getArea() {
		return (x2 - x1) * (y2 - y1);
	}
	
	//tostring
	public String toString() {
		return "(" + x1 + ", " + y1 + ") , (" + x2 + ", " + y2 + ")"; 
	}
	
}
