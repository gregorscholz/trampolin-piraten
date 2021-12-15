package zentral;

import java.util.HashSet;
import java.util.Set;

import spielelemente.IFSpielelement;

/**
 * Klasse, welche die fuer das Level notwenigen Spielelemente erstellt.
 * Die Level sind vorgefertit in Textform vorhanden.
 * 
 * @author Ines Rohrbach
 */
public class LevelDesign {
	private Set<IFSpielelement> alleElemente = new HashSet<IFSpielelement>();
	
	/**
	 * Konstruktor fuer ein Leveldesign, welches je nach gewaehltem Level und Schwierigkeit das gewuenschte Level erstellt.
	 * 
	 * 
	 * @param design, Fassanrichtung
	 * @param schwierigkeit, Fassnummern und Eventfaesser
	 * @author Ines Rohrbach
	 */
	public LevelDesign(byte design, byte schwierigkeit) {		
	}
	
	/**
	 * Liesst die ausgewaehlte Textdatei ein und erstellt die Elemente ueber die Factory.
	 * 
	 * @param dateiname, Name des genauen Levels 
	 * @author Ines Rohrbach
	 */
	private void leseDatei(String dateiname) {	
	}

	/**
	 * Gibt alle für das Level verwendeten Spielelemente zurueck
	 * 
	 * @return alle Spielelmente des Levels in einem Hashset
	 * @author Ines Rohrbach
	 */
	public Set<IFSpielelement> getElemente() {
		return alleElemente;
	}
}
