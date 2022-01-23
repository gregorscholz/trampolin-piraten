package spielelemente;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Klasse zum Erstellen der Kugel und dessen Verwaltung der Position und Bewegung
 * @param xVelocity
 * @param yVelocity
 * @param random 
 * @param randomVelocities Ersatz fuer random, weil random direkt kein exkludieren von Zahlen (0) erlaubt
 * @author Johannes Roloff
 */
public class Kugel extends Rectangle implements IFSpielelement {

	private static final long serialVersionUID = 1L;
	private double xVelocity, yVelocity;
	private int istAktiv;
	private Random random = new Random();
	int[] randomVelocities = {-2, -1, 1, 2};

	/**
	 * Konstruktor, der die Kugel erstellt
	 * Die erste Kugel des Spiels wird immer mit festen Werten initialisiert.
	 * Kugeln, die durch Events entstehen, werden am Ort des Eventfasses und mit zufaelligen Geschwindigkeiten initialisiert
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param istEventKugel true, wenn Kugel durch Event entstanden ist
	 * @param aktivWert
	 * @author Johannes Roloff
	 */
	public Kugel(int aktivWert/*, int istEventKugel*/, int wellenstand){
		super(FassPosition.fassXPosition(aktivWert), FassPosition.fassYPosition(aktivWert), 50, 50);
		int randomXVelocity = random.nextInt(4);
		int randomYVelocity = random.nextInt(4);
		
		if(aktivWert == 0) {
			if(wellenstand == 0) {
				y = 788;
			} else if(wellenstand == 1) {
				y = 838;
			} else {
				y = 888;
			}
		}
		
		//if(istEventKugel == 1) {
		if(aktivWert!=0) {
			xVelocity = randomVelocities[randomXVelocity];
			yVelocity = randomVelocities[randomYVelocity];
			setIstAktiv(aktivWert);
		}
		else {
			xVelocity = 1.0;
	        yVelocity = randomVelocities[randomYVelocity];;
	        System.out.println(yVelocity);
	        setIstAktiv(aktivWert);
		}
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
	 * Gibt das dazugehoerige Eventfass oder das sie wirklich aktiv ist zurueck.
	 * 0 = ist gerade Aktiv, 1-200 = gehoert zu einem Event
	 * 
	 * @author Johannes Roloff
	 */
	public int getIstAktiv() {
		return istAktiv;
	}


	/**
	 *  Aendert den Status von gehoert zu einem Event zu ist jetzt aktiv.
	 *  0 = jetzt Aktiv
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
		y = (int) (y + yVelocity*3.0);
		x = (int) (x + xVelocity*3.0);
	}
	
}