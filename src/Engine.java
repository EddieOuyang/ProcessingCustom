import processing.core.PApplet;
import java.util.*;

public class Engine extends PApplet{
	private Sparkle spark;
	public Engine() {
		spark = new Sparkle(500,200,15,20,20,0,2.5f,0.9f);
		spark.setColor(255, 255, 255);
	}
	
	public void settings() {
		fullScreen();
	}
	
	public void setUp() {
	}
	
	public void mousePressed() {
		spark.setLocation(mouseX, mouseY);
	}
	
	public void mouseDragged() {
		spark.setLocation(mouseX, mouseY);
	}
	
	public void draw() {
		background(0);
		spark.draw(this);
		spark.spawn(2);
		if(frameCount%3 == 0) spark.move();
		int cycle = frameCount*5%1530;
		int part = cycle%255;
		switch(cycle/255){
		case 0: spark.setColor(255, part, 0);
			break;
		case 1: spark.setColor(255 - part, 255, 0);
			break;
		case 2: spark.setColor(0, 255, part);
			break;
		case 3: spark.setColor(0, 255 - part, 255);
			break;
		case 4: spark.setColor(part, 0, 255);
			break;
		case 5: spark.setColor(255, 0, 255 - part);
			break;
		}
	}
	
	public static void main(String[] args) {
		PApplet.runSketch(new String[]{""}, new Engine());
	}
}
