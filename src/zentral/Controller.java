package zentral;

import java.util.Set;

import spielelemente.GameObjects;
import spielelemente.IFSpielelement;

/**
 * Zentrale Verwaltungsklasse - Controller.
 * 
 * @author iveev
 */
public abstract class Controller {
	private static GameObjects aktuelleElemente;
	
	
	/**
	 * damit bei tastendruck ueberprueft werden kann, ob der spieler noch im panel ist
	 * 
	 * wenn bei der plattform überprüft wird, ob die plattform noch im spielfeld ist, dann wird diese methode wegfallen
	 * 
	 * @return Spielerposition horizontal als Integer
	 * @author iveev
	 */
	public static int getSpielerPositionX() {
		return woauchimmer.getSpielerPositionX();
	}
	
	/**
	 * anweisung die Plattform nach rechts zu schieben.
	 * 
	 * @author iveev
	 */
	public static void bewegenNachRechts() {
		woauchimmer.bewegenNachRechts();
	}
	
	/**
	 * anweisung die Plattform nach links zu schieben.
	 * 
	 * @author iveev
	 */
	public static void bewegenNachLinks() {
		woauchimmer.bewegenNachRechts();
	}
	
	/**
	 * Erstellt/Gibt die Steuerung(Singleton).
	 * muss mir aber noch mal angucken wie genau das geht
	 * 
	 * @author iveev
	 */
	public static Steuerung getSteuerung() {
		return new Steuerung();
	}

	/**
	 * Erstellt die Levelelemente zu dem ausgesuchten Aufbau und Schwierigkeit.
	 * 
	 * @author iveev
	 */
	public static void erstelleLevel(byte design, byte schwierigkeit) {
		new LevelDesign(design, schwierigkeit);
	}
	
	/**
	 * Speichert alle Spielelemente in der GameObjects Klasse.
	 * 
	 * @param elemente, alle aktuellen Spielelemente in einem Set
	 * @author iveev
	 */
	public static void aktuelleSpielelemente(Set<IFSpielelement> elemente) {
		aktuelleElemente = new GameObjects(elemente);
	}
	
	/**
	 * Übergibt die Tasteneinstellung an die Steuerungsklasse.
	 * 
	 * @author iveev
	 */
	public static void setTasten(int setting) {
		//eventuell anders
		Steuerung s = new Steuerung();
		s.setTasten(setting);
	}
}
