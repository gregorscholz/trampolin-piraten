package spielelemente;

import gui.InGamePanel;

/**
 * Klasse zum Verwalten der F�sser
 * @param verbleibend, Anzahl der verbleibenden treffer bis zum verschwinden eines Fasses
 * @param Fassposition, Array zum verwalten der F�sser
 * @param KoordinateX, x position eines Fasses (oben links)
 * @param KoordinateY, y position eines Fasses (oben links)
 * @author ischramm
 */

public class Fass {

	int verbleibend;
	int KoordinateX;
	int KoordinateY;
	
   /**
     *Konstruktor zu Collisionsbehandlung
     *@author ischramm
     * @return Anzahl der verbleibenden "lebens"punke
     */
	public Fass(int fassNummer, int leben, int eventnummer) {
			leben = leben-1;
			verbleibend = leben;
			if (eventnummer != 0) {
				EventFass ausloeser = new EventFass(fassNummer, eventnummer);
			}
			
	}
	
	   /**
     *Konstruktor zum erstellen der F�sser (positionsbehandlung)
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
