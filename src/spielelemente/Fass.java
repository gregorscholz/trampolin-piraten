package spielelemente;

import gui.InGamePanel;

/**
 * Klasse zum Verwalten der Faesser
 * @param verbleibend, Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
 * @param Fassposition, Array zum verwalten der Faesser
 * @param KoordinateX, x position eines Fasses (oben links)
 * @param KoordinateY, y position eines Fasses (oben links)
 * @author ischramm
 */

public class Fass implements IFSpielelement {

	private int position;
	int verbleibend;
	int xKoordinate;
	int yKoordinate;
	int fassbreite;
	int fasshoehe;
	
   /**
     *Konstruktor zu Collisionsbehandlung
     *@author ischramm
     * @return Anzahl der verbleibenden "lebens"punke
     */
	public Fass(int fassNummer, int leben, int eventnummer) {
		position = fassNummer;
		verbleibend = leben;
		yKoordinate = (fassNummer % 10)* fasshoehe;
		xKoordinate = (fassNummer % 20)* fassbreite;
	}
	
	/*kommentar ines: gehoeren die beiden konstruktren nicht zusammen? 
	weil man kann ja nicht ein fass erstellen mit nur der position und auch nicht ohne die position
	obwohl, die nummer ist doch eigentlich gleichzusetzen mit der position wenn ich es richtig verstehe.... 
	trotzdem sind da zwei konstruktoren denke ich nicht richtig
	*/
	
	   /**
     *Konstruktor zum erstellen der Faesser (positionsbehandlung)
     *@author ischramm
     */
	
	int treffer(int fassNummer, int leben, int eventnummer){
		leben = leben-1;
		verbleibend = leben;
		if (eventnummer != 0) {
			EventFass ausloeser = new EventFass(fassNummer, eventnummer);
		}
		return verbleibend;
	}

	 /**
     * @getPosition ,position eines Fasses (fassnummer)
     * @autor ischramm
     */
	public int getPosition() {
		return position;
	}
	 /**
     * @getLeben , Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
     * @autor ischramm
     */
	public int getLeben(){
		return verbleibend;
	}
	 /**
     * @getX , x position eines Fasses (oben links)
     * @autor ischramm
     */
	public int getX() {
		return xKoordinate;
	}
	 /**
     * @getY , y position eines Fasses (oben links)
     * @autor ischramm
     */
	public int getY() {
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
