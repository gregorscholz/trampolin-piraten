package spielelemente;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Klasse zum Erstellen der Kugel und dessen Verwaltung der Position und Bewegung
 * @param xVelocity
 * @param yVelocity
 * @param x
 * @param y
 * @param width
 * @param height
 * @author Johannes Roloff
 */
public class Kugel extends Rectangle implements IFSpielelement {

	private double xVelocity, yVelocity;
	private int istAktiv;

	public Kugel(int x, int y, int aktivWert){
		super(x, y, 50, 50);
        xVelocity = 1.0;
        yVelocity = -1.5;
        setIstAktiv(aktivWert);
	}
	
	
	//Getter und Setter
	
	/**
	 * Setzt horizontale Geschwindigkeit und Richtung der Kugel
	 * @see #move()
	 * @author Johannes Roloff
	 */
	public void setxVelocity(double newxVelocity){
        xVelocity = newxVelocity;
    }

	/**
	 * Setzt vertikale Geschwindigkeit und Richtung der Kugel
	 * @see #move()
	 * @author Johannes Roloff
	 */
    public void setyVelocity(double newyVelocity){
        yVelocity = newyVelocity;
    }

	/**
	 * 
	 * @return horizontale Geschwindigkeit der Kugel
	 * @author Johannes Roloff
	 */
	public double getxVelocity() {
		return xVelocity;
	}

	/**
	 * 
	 * @return vertikale Geschwindigkeit der Kugel
	 * @author Johannes Roloff
	 */
	public double getyVelocity() {
		return yVelocity;
	}

	/**
	 * 
	 * @return horizontale Position der Kugel
	 * @author Johannes Roloff
	 */
	public int getxKoordinate() {
		return x;
	}

	/**
	 * Setzt horizontale Position der Kugel
	 * 
	 * @author Johannes Roloff
	 */
	public void setxKoordinate(int xKoordinate) {
		this.x = xKoordinate;
	}

	/**
	 * 
	 * @return vertikale Position der Kugel
	 * @author Johannes Roloff
	 */
	public int getyKoordinate() {
		return y;
	}

	/**
	 * Setzt vertikale Position der Kugel
	 * 
	 * @author Johannes Roloff
	 */
	public void setyKoordinate(int yKoordinate) {
		this.y = yKoordinate;
	}
	
	/**
	 * Lorem Ipsum
	 * 
	 * @author Johannes Roloff
	 */
	public int getIstAktiv() {
		return istAktiv;
	}


	/**
	 *  dolor sit amet
	 * 
	 * @author Johannes Roloff
	 */
	public void setIstAktiv(int istAktiv) {
		this.istAktiv = istAktiv;
	}

	//andere Methoden
	
	/**
	 * Bewegt die Kugel um einen festen Wert multipliziert mit der der derzeitigen horizontalen und vertikalen Geschwindigkeit
	 * @see #setxVelocity(double)
	 * @see #setyVelocity(double)
	 * @author Johannes Roloff
	 */
	public void move() {
		y = (int) (y + yVelocity*20.0);
		x = (int) (x + xVelocity*20.0);
	}
	
}