package spielelemente;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * 
 * @author Johannes Roloff
 */
public class Kugel extends Rectangle implements IFSpielelement {

	private double xVelocity, yVelocity;

	public Kugel(int x, int y){
		super(x, y, 9, 9);
        xVelocity = 1.0;
        yVelocity = -1.5;
	}
	
	
	//Getter und Setter
	
	/**
	 * 
	 * 
	 * @author Johannes Roloff
	 */
	public void setxVelocity(double newxVelocity){
        xVelocity = newxVelocity;
    }

    public void setyVelocity(double newyVelocity){
        yVelocity = newyVelocity;
    }

	public double getxVelocity() {
		return xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
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
	
	//andere Methoden
	
	public void move() {
		y = (int) (y + yVelocity*20.0);
		x = (int) (x + xVelocity*20.0);
	}
	
	public void draw(Graphics g) {
		//malt die Kugel; wird wahrscheinlich von Gregor in der GUI uebernommen
	}
}