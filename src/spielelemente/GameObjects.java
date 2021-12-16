package spielelemente;

import java.util.Set;

/**
 * Diese Klasse verwaltet die aktuellen Spielelemente.
 * 
 * @author Ines Rohrbach
 */
public class GameObjects {
	private Kugel kugel;
	private Plattform plattform;
	
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
