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
	int KoordinateX;
	int KoordinateY;
	
	//getter position
	public int getPosition() {
		return position;
	}
	
   /**
     *Konstruktor zu Collisionsbehandlung
     *@author ischramm
     * @return Anzahl der verbleibenden "lebens"punke
     */
	public Fass(int fassNummer, int leben, int eventnummer) {
		position = fassNummer; //wenn fassnummer das ist was ich denke
			leben = leben-1;
			verbleibend = leben;
			if (eventnummer != 0) {
				EventFass ausloeser = new EventFass(fassNummer, eventnummer);
			}
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
	public Fass(int fassNummer) {
	//InGamePanel.paintfass (KoordinateX, KoordinateY); oder so
	}

	 /**
     * 3 getter zum aubfragen der:
     * @getLeben , Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
     * @getX , x position eines Fasses (oben links)
     * @getY , y position eines Fasses (oben links)
     * @autor ischramm
     */
	public int getLeben(){
		return verbleibend;
	}
	public int getX() {
		return KoordinateX;
	}
	public int getY() {
		return KoordinateY;
	}
	
	 /**
     * Berechnen der Position 
     * @param fassnummer, position des Fasses im Array
     * @autor ischramm
     */
	public void berechnePosition(int fassnummer) {
		//berechnet x und y Koordinaten eines Fasses
	}
}
