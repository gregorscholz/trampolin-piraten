package zentral;

/**
 * Klasse, welche die fuer das Level notwenigen Spielelemente erstellt.
 * Die Level sind vorgefertit in Textform vorhanden.
 * 
 * @author iveev
 */
public class LevelDesign {
	private Set<IFSpielemlement> alleElemente = new Hashset<IFSpielelement>();
	
	/**
	 * Konstruktor fuer ein Leveldesign, welches je nach gewaehltem Level und Schwierigkeit das gewuenschte Level erstellt.
	 * 
	 * 
	 * @param level, Fassanrichtung
	 * @param schwierigkeit, Fassnummern und Eventfaesser
	 * @author iveev
	 */
	public LevelDesign(byte level, byte schwierigkeit) {		
	}
	
	/**
	 * Liesst die ausgewaehlte Textdatei ein und erstellt die Elemente ueber die Factory.
	 * 
	 * @param dateiname, Name des genauen Levels 
	 * @author iveev
	 */
	private void leseDatei(String dateiname) {	
	}

	/**
	 * Gibt alle für das Level verwendeten Spielelemente zurueck
	 * 
	 * @return alle Spielelmente des Levels in einem Hashset
	 * @author iveev
	 */
	public Set<IFSpielelement> getElemente() {
	}
}
