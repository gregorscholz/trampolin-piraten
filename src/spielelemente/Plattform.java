package spielelemente;

import java.awt.event.*;
import java.awt.*;

/**
 * Klasse zum Erstellen der Plattform und deren Verwaltung der Position und Bewegung
 * @param xVelocity
 * @param x
 * @param y
 * @param width
 * @param height
 * @author Johannes Roloff
 */
public class Plattform extends Rectangle implements IFSpielelement {

	private int xVelocity;
	
	public Plattform(int y, int velocity){
		super(600, y, 200, 25);
		xVelocity = velocity;
	}
	
	//Getter und Setter
	
	/**
	 * 
	 * @return Geschwindigkeit und Richtung in x-Richtung
	 * @author Johannes Roloff
	 */
	public int getxVelocity() {
		return xVelocity;
	}

	/**
	 * Setzt horizontale Richtung- und Geschwindigkeit der Plattform
	 * 
	 * @author Johannes Roloff
	 */
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	/**
	 * 
	 * @return horizontale Position der Plattform
	 * @author Johannes Roloff
	 */
	public int getxKoordinate() {
		return x;
	}

	/**
	 * Setzt horizontale Position der Plattform
	 * 
	 * @author Johannes Roloff
	 */
	public void setxKoordinate(int xKoordinate) {
		this.x = xKoordinate;
	}

	/**
	 * 
	 * @return y-Koordinate der Plattform
	 * @author Johannes Roloff
	 */
	public int getyKoordinate() {
		return y;
	}

	/**
	 * Setzt vertikale Position der Plattform
	 * 
	 * @author Johannes Roloff
	 */
	public void setyKoordinate(int yKoordinate) {
		this.y = yKoordinate;
	}
	
	//andere Methoden
	
	/**
	 * Ermöglicht ein intuitivieres Erlebnis fuer die ganze Familie beim festlegen der vordefinierten Wellenstaende
	 * @param c, Wertebereich [0,2] setzt Wellenstand auf hoch, mittel oder tief
	 * 
	 * @author Johannes Roloff
	 */
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
	
	/**
	 * Bewegt die Plattform um einen festen Wert multipliziert mit der der horizontalen Geschwindigkeit
	 * @see #setxVelocity(int)
	 * @author Johannes Roloff
	 */
	public void move() {
		x = x + xVelocity*20;
	}
}
