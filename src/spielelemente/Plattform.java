package spielelemente;

import java.awt.event.*;
import java.awt.*;

/**
 * 
 * 
 * @author Johannes Roloff
 */
public class Plattform extends Rectangle implements IFSpielelement {

	private int xVelocity;
	private int xKoordinate, yKoordinate;
	
	public Plattform(int y, int velocity){
		super(600, y, 200, 25);
		xVelocity = velocity;
	}
	
	//Getter und Setter
	
	public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getxKoordinate() {
		return x;
	}

	public void setxKoordinate(int xKoordinate) {
		this.x = xKoordinate;
	}

	public int getyKoordinate() {
		return y;
	}

	public void setyKoordinate(int yKoordinate) {
		this.y = yKoordinate;
	}
	
	public void setWellenstand(int c) {
		switch(c) {
		case 0:
			y = 1350-height;
			break;
		case 1:
			y = 1300-height;
			break;
		case 2:
			y = 1250-height;
			break;
		}
	}

	
	//andere Methoden
	
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		//malt die Plattform; wird wahrscheinlich von Gregor in der GUI uebernommen
	}
}
