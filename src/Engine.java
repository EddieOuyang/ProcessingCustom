import processing.core.PApplet;
import javax.swing.JOptionPane;

public class Engine extends PApplet{
	private Sparkle spark;
	private int spawnAmt;
	private boolean move;
	
	public Engine() {
		spark = new Sparkle(0,400,10,10,20,10,0,0.7f);
		spark.setColor(255, 255, 255);
		spawnAmt = 0;
		move = true;
	}
	
	public void settings() {
		fullScreen();
	}
	
	public void setUp() {
	}
	
	public void mousePressed() {
		spark.spawn(20,mouseX, mouseY);
	}
	
	public void mouseDragged() {
		spark.spawn(5,mouseX, mouseY);
	}
	
	public void keyPressed() {
		switch(keyCode) {
		case 32: 
			String s = (String)JOptionPane.showInputDialog(null, "Change Settings", "Options",JOptionPane.QUESTION_MESSAGE, null, new String[] {"X", "Y", "X Spread", "Y Spread", "Size", "X Accel", "Y Accel", "Decay", "Spawns"}, null);
			try {
				switch(convertOption(s)){
				case 0:
					spark.setLocation(Float.parseFloat(JOptionPane.showInputDialog("Change " + s)), Float.NaN);
					break;
				case 1:
					spark.setLocation(Float.NaN, Float.parseFloat(JOptionPane.showInputDialog("Change " + s)));
					break;
				case 2:
					spark.setSize(Float.parseFloat(JOptionPane.showInputDialog("Change " + s)));
					break;
				case 3:
					spark.setDecay(Float.parseFloat(JOptionPane.showInputDialog("Change " + s)));
					break;
				case 4:
					spark.setAcceleration(Float.parseFloat(JOptionPane.showInputDialog("Change " + s)), Float.NaN);
					break;
				case 5:
					spark.setAcceleration(Float.NaN, Float.parseFloat(JOptionPane.showInputDialog("Change " + s)));
					break;
				case 6:
					spark.setSpread(Float.parseFloat(JOptionPane.showInputDialog("Change " + s)), Float.NaN);
					break;
				case 7:
					spark.setSpread(Float.NaN, Float.parseFloat(JOptionPane.showInputDialog("Change " + s)));
					break;
				case 8:
					int i = Integer.parseInt(JOptionPane.showInputDialog("Change " + s));
					spawnAmt = i < 0 ? 0:i;
				}
			} catch (Exception e) {
				System.out.println("error");
			}
			break;
		case 80: move = !move;
			break;
		}
	}
	
	public void draw() {
		background(255);
		spark.draw(this);
		spark.spawn(spawnAmt);
		if(frameCount%3 == 0 && move) spark.move();
		int cycle = frameCount*10%1530;
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
//		idle(frameCount*3);
	}
	
	private int convertOption(String s) {
		int i = 9;
		switch(s.length()) {
		case 1:	i = 0;
			break;
		case 4: i = 1;
			break;
		case 5: i = 2;
			break;
		case 6: i = 7;
			break;
		case 7: i = 4;
			break;
		case 8: i = 6;
			break;
		}
		return i + (s.charAt(0) == 'X' ? 0:1);
	}
	
	private void idle(int t) {
		double a = Math.toRadians(t);
		spark.setLocation(displayHeight/2 * 0.6f*(float)Math.cos(a) + displayWidth/2, displayHeight/2 * (1 + 0.6f*(float)Math.sin(a)));
	}
	
	public static void main(String[] args) {
		PApplet.runSketch(new String[]{""}, new Engine());
	}
}
