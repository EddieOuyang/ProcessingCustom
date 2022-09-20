import processing.core.PApplet;

public class Particle {
	private float x,y,vx,vy,ax,ay,size,d,fullSize;
	private float[] c;
	
	// (x,y) position, (x,y) velocity, (x,y) acceleration, size, color, decay rate
	public Particle(float xi, float yi, float vxi, float vyi, float axi, float ayi, float sizei, float[] color, float di) {
		x = xi;
		y = yi;
		vx = vxi;
		vy = vyi;
		ax = axi;
		ay = ayi;
		size = sizei;
		fullSize = sizei;
		c = color;
		d = di;
	}
	
	//draw this particle
	public void draw(PApplet p) {
		p.push();
		p.noStroke();
		p.colorMode(PApplet.RGB, 255,255,255,1);
		p.fill(c[0],c[1],c[2],size/fullSize);
		p.circle(x, y, size);
		p.pop();
	}
	
	//apply motion to particles
	public void move() {
		vx += ax;
		vy += ay;
		x += vx;
		y += vy;
		size -= d;
	}
	
	//is dead
	public boolean dead() {
		return size <= 0;
	}
}
