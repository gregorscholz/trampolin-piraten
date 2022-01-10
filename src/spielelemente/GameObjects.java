package spielelemente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Diese Klasse verwaltet die aktuellen Spielelemente.
 * 
 * @author Ines Rohrbach
 */
public class GameObjects {
	private ArrayList<Kugel> kugeln = new ArrayList<Kugel>();
	private Plattform plattform;
	private ArrayList<Fass> faesser = new ArrayList<Fass>();
	
	/**
	 * Gibt die aktuellen Faesser zurueck.
	 * Beachte: Fass[0]=null
	 * 
	 * @return aktuellen Faesser in einem Array
	 * @author Ines Rohrbach
	 */
	public ArrayList<Fass> getFaesser() {
		return faesser;
	}
	
	/**
	 * Gibt ein einzelnes Fass zurueck.
	 * Beachte: Fass[0]=null
	 * 
	 * @param i, Fass welches man haben moechte.
	 * @return
	 */
	public Fass getFass(int i) {
		return faesser.get(i);
	}

	/**
	 * Gibt die Kugel zurueck.
	 * 
	 * @param i, welche Kugel
	 * @return aktuelle Kugel
	 * @author Ines Rohrbach
	 */
	public Kugel getKugel(int i) {
		return kugeln.get(i);
	}
	
	/**
	 * Gibt alle Kugeln zurueck.
	 * 
	 * @return alle Kugeln
	 * @author Ines Rohrbach
	 */
	public ArrayList<Kugel> getKugeln() {
		return kugeln;
	}

	/**
	 * Gibt die aktuelle Plattform zurueck.
	 * 
	 * @return aktuelle Plattform
	 * @author Ines Rohrbach
	 */
	public Plattform getPlattform() {
		return plattform;
	}

	/**
	 * Ein Objekt der Klasse wird immer mit den Spielelementen erstellt, die dann auch sortiert werden.
	 * 
	 * @param elemente
	 * @author Ines Rohrbach
	 */
	public GameObjects(ArrayList<IFSpielelement> elemente) {
		Iterator<IFSpielelement> i = elemente.iterator();
		while(i.hasNext()) {
			IFSpielelement e = i.next();
			if(e.getClass()== Fass.class) {
				faesser.add(((Fass) e).getPosition(), (Fass) e);
			} else if(e.getClass()== Plattform.class) {
				this.plattform = (Plattform) e;
			} else if(e.getClass()== Kugel.class) {
				kugeln.add((Kugel) e);
			}
		}
	}
}
