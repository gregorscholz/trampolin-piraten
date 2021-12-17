package spielelemente;

import java.util.ArrayList;
import java.util.Set;

/**
 * Diese Klasse verwaltet die aktuellen Spielelemente.
 * 
 * @author Ines Rohrbach
 */
public class GameObjects {
	private Kugel kugel;
	private Plattform plattform;
	private ArrayList<Fass> faesser = new ArrayList<Fass>();
	
	/**
	 * Gibt die aktuellen Faesser zurueck.
	 * 
	 * @return aktuellen Faesser in einem Array
	 * @author Ines Rohrbach
	 */
	public ArrayList<Fass> getFaesser() {
		return faesser;
	}

	/**
	 * Gibt die aktuelle Kugel zurueck.
	 * 
	 * @return aktuelle Kugel
	 * @author Ines Rohrbach
	 */
	public Kugel getKugel() {
		return kugel;
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
	public GameObjects(Set<IFSpielelement> elemente) {
		
	}
}
