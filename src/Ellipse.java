import processing.core.PApplet;

public class Ellipse {
	private double x,y,r,r2;
	
	public Ellipse(double xc, double yc, double ri) {
		x = xc;
		y = yc;
		r = ri;
		r2 = ri;
	}
	
	public Ellipse(double xc, double yc, double ri, double ri2) {
		x = xc;
		y = yc;
		r = ri;
		r2 = ri2;
	}
	
}
