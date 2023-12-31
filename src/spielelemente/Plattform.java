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
	private int wellenstand;
	
	/**
	 * 
	 * @param c, hoch=0 mittel=1 niedrig=2
	 * @param velocity, normal=1 etwasSchneller=2 nochSchneller=3 
	 */
	public Plattform(int c, int velocity){
		super(600, 24797, 200, 25);
		setWellenstand(c);
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
	 * Setzt horizontale Position der Plattform
	 * 
	 * @author Johannes Roloff
	 */
	public void setxKoordinate(int xKoordinate) {
		this.x = xKoordinate;
	}

	/**
	 * Setzt vertikale Position der Plattform
	 * 
	 * @author Johannes Roloff
	 */
	public void setyKoordinate(int yKoordinate) {
		this.y = yKoordinate;
	}
	
	/**
	 * Setzt Breite der Plattform
	 * @param newWidth
	 * @author Johannes Roloff
	 */
	public void setPlattformBreite(int newWidth) {
		this.width = newWidth;
	}
	
	/**
	 * @return Hoehe der Plattform
	 * @author Johannes Roloff
	 */
	public int getPlattformBreite( ) {
		return width;
	}
	
	/**
	 * Setzt Hoehe der Plattform
	 * @param newHeight
	 * @author Johannes Roloff
	 */
	public void setPlattformHoehe(int newHeight) {
		this.height = newHeight;
	}
	
	/**
	 * @return Breite der Plattform
	 * @author Johannes Roloff
	 */
	public int getPlattformHoehe( ) {
		return height;
	}
	
	/**
	 * @return Die Wellenstandhoehe
	 * @author Ines Rohrbach
	 */
	public int getWellenstand() {
		return wellenstand;
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
			y = 850-(height/2);
			wellenstand = 850;
			break;
		case 1:
			y = 900-(height/2);
			wellenstand = 900;
			break;
		case 2:
			y = 950-(height/2);
			wellenstand = 950;
			break;
		}
	}
	
	/**
	 * Bewegt die Plattform um einen festen Wert multipliziert mit der der horizontalen Geschwindigkeit
	 * @see #setxVelocity(int)
	 * @author Johannes Roloff
	 */
	/*public void moveLeft() {
		while(x >= xVelocity*20) {
			x = x - xVelocity*20;
		}
	}
	
	public void moveRight() {
		while(x <= xVelocity*20) {
			x = x + xVelocity*20;
		}
	}*/
	
	
	public void moveRight() {
		if(!((x+xVelocity*30)>1200)) {
			x = x + xVelocity*30;
		}
		else x = 1200;
	}

	public void moveLeft() { //funktioniert nur weil x nicht negativ werden kann
		if(x >= xVelocity*30) {
			x = x - xVelocity*30;
		}
		else x = x+0;
	}
}
