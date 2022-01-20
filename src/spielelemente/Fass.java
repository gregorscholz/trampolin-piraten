package spielelemente;

import java.awt.Rectangle;

import gui.InGamePanel;

/**
 * Klasse zum Verwalten der Faesser
 * @param verbleibend, Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
 * @param position, Arrayposition zum verwalten der Faesser
 * @param xKoordinate, x position eines Fasses (oben Links)
 * @param yKoordinate, y position eines Fasses (oben Links)
 * @param event , nummer des auszulösenden Events, 0 = kein Event
 * @param fassbreite, breite der hitbox eines Fasses
 * @param fasshoehe, hoehe der hitbox eines Fasses
 * @author ischramm
 */

public class Fass extends Rectangle implements IFSpielelement {
	
	private int verbleibend;
	private int position;
	private int xKoordinate;
	private int yKoordinate;
	private int event;
	private int fassbreite = 50;
	private int fasshoehe = 50;
	
   /**
     *Konstruktor zu Collisionsbehandlung
     *@author ischramm
     * @return Anzahl der verbleibenden "lebens"punke
     */
	public Fass(int fassNummer, int leben, int eventnummer) {
		super(((fassNummer % 10)* 50), ((fassNummer % 20)* 50), 50, 50);
		if ( leben != 0) {
			position = fassNummer;
			verbleibend = leben;
			yKoordinate = (fassNummer % 10)* fasshoehe;
			xKoordinate = (fassNummer % 20)* fassbreite;
			event = eventnummer;
		}
	}
	
	   /**
     *klasse zur trefferauswirkung (leben abziehen, event auslösen)
     *@return anzahl der verbleibenden leben
     *@author ischramm
     */
	
	Object treffer(int fassNummer, int leben, int eventnummer){
		leben = leben-1;
		verbleibend = leben;
		if (eventnummer != 0) {
			EventFass ausloeser = new EventFass(fassNummer, leben, eventnummer);
		}
		if (verbleibend == 0) {
			return null;
		}
		return verbleibend;
	}

	/**
     * @getEvent gibt die Eventnummer eines Fasses zurück
     * @return Eventnummer eines Fasses
     * @autor ischramm
     */
	public int getEvent() {
		return event;
	}
	 /**
     * @getPosition gibt die position eines Fasses (fassnummer)
     * @return position im Array
     * @autor ischramm
     */
	public int getPosition() {
		return position;
	}
	 /**
     * @getLeben gibt die Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
     * @return anzahl der verbleibenden leben
     * @autor ischramm
     */
	public int getLeben(){
		return verbleibend;
	}
	 /**
     * @getX ,gibt die x position eines Fasses (oben links)
     * @return x koordinate eines Fasses (oben links)
     * @autor ischramm
     */
	public int getxKoordinate() {
		return xKoordinate;
	}
	 /**
     * @getY ,gibt die y position eines Fasses (oben links)
     * @return y koordinate eines Fasses (oben links)
     * @autor ischramm
     */
	public int getyKoordinate() {
		return yKoordinate;
	}
	
	 /**
     * Berechnen der Position 
     * @param fassnummer, position des Fasses im Array
     * @autor ischramm
     */
	public void berechnePosition() {
		getX();
		getY();
	}
}
