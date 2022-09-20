import java.util.*;
import processing.core.PApplet;

public class Sparkle {
	private ArrayList<Particle> particles, kill;
	private float x,y,spreadX,spreadY,s,ax,ay,d;
	private Random rand;
	private float[] c;
	
	// (x,y) position, (x,y) deviation, particle size, (x,y) acceleration, decay rate
	public Sparkle(float xi, float yi, float spreadx, float spready, float size, float axi, float ayi, float di) {
		x = xi;
		y = yi;
		spreadX = spreadx;
		spreadY = spready;
		s = size;
		ax = axi;
		ay = ayi;
		rand = new Random();
		particles = new ArrayList<Particle>();
		kill = new ArrayList<Particle>();
		c = new float[] {255,255,255};
		d = di;
	}
	
	//draw particle system
	public void draw(PApplet pa) {
		for(Particle p:particles) {
			p.draw(pa);
		}
	}
	
	//apply motion to particles
	public void move() {
		for(Particle p:particles) {
			p.move();
			if(p.dead()) kill.add(p);
		}
		for(Particle p:kill) {
			particles.remove(p);
		}
		kill.clear();
	}
	
	//set new particles' color
	public void setColor(int a, int b, int c) {
		this.c = new float[] {a,b,c};
	}
	
	//set spawn location
	public void setLocation(float xi, float yi) {
		x = xi;
		y = yi;
	}
	
	//
	public void setAcceleration(float xi, float yi) {
		ax = xi;
		ay = yi;
	}
	
	//spawn i new particles
	public void spawn(int i) {
		for(;i > 0; i--)particles.add(new Particle(x+rand.nextFloat()-0.5f,y+rand.nextFloat()-0.5f,rand.nextFloat()*spreadX*2-spreadX, rand.nextFloat()*spreadY*2-spreadY, ax, ay, (rand.nextInt(30) + 70)/100.0f * s, c.clone(), d));
	}
	
	//spawn i new particles at (x,y)
	public void spawn(int i, float x, float y) {
		for(;i > 0; i--)particles.add(new Particle(x+rand.nextFloat()-0.5f,y+rand.nextFloat()-0.5f,rand.nextFloat()*spreadX*2-spreadX, rand.nextFloat()*spreadY*2-spreadY, ax, ay, (rand.nextInt(30) + 70)/100.0f * s, c.clone(), d));
	}
}
