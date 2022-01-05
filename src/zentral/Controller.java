package zentral;

import java.util.Set;

import spielelemente.GameObjects;
import spielelemente.IFSpielelement;

/**
 * Zentrale Verwaltungsklasse - Controller.
 * 
 * @author Ines Rohrbach
 */
public abstract class Controller {
	private static GameObjects aktuelleElemente;
	
	
	/**
	 * damit bei tastendruck ueberprueft werden kann, ob der spieler noch im panel ist
	 * 
	 * wenn bei der plattform überprüft wird, ob die plattform noch im spielfeld ist, dann wird diese methode wegfallen
	 * 
	 * @return Spielerposition horizontal als Integer
	 * @author Ines Rohrbach
	 */
	public static int getSpielerPositionX() {
		return aktuelleElemente.getPlattform().getxKoordinate();
	}
	
	/**
	 * anweisung die Plattform nach rechts zu schieben.
	 * 
	 * @author Ines Rohrbach
	 */
	public static void bewegenNachRechts() {
		aktuelleElemente.getPlattform().move();//rechts
	}
	
	/**
	 * anweisung die Plattform nach links zu schieben.
	 * 
	 * @author Ines Rohrbach
	 */
	public static void bewegenNachLinks() {
		aktuelleElemente.getPlattform().move();//links
	}
	
	/**
	 * Aktiviert oder deaktiviert die vertauschte steuerung
	 * 
	 * @param aktiv
	 * @author Ines Rohrbach
	 */
	public static void rumAktiviert(boolean aktiv) {
		getSteuerung().rumAktiviert(aktiv);
	}
	
	/**
	 * Gibt die Steuerung(Singleton) zureuck.
	 * 
	 * @author Ines Rohrbach
	 */
	public static Steuerung getSteuerung() {
		return Steuerung.getSteuerung();
	}

	/**
	 * Erstellt die Levelelemente zu dem ausgesuchten Aufbau und Schwierigkeit und speichert die aktuellen Spielelemente in der GameObjects Klasse.
	 * 
	 * @author Ines Rohrbach
	 */
	public static void erstelleLevel(byte design, byte schwierigkeit) {
		LevelDesign l = new LevelDesign(design, schwierigkeit);
		aktuelleElemente = new GameObjects(l.getElemente());
	}
	
	/**
	 * Übergibt die Tasteneinstellung an die Steuerungsklasse.
	 * 
	 * @author Ines Rohrbach
	 */
	public static void setTasten(int setting) {
		Steuerung.getSteuerung().setTasten(setting);
	}
	
	/**
	 * Gibt die aktuellen Spielelemente als GameObjects zurueck.
	 * 
	 * @return die Klasse GameObjects.
	 * @author Ines Rohrbach
	 */
	public static GameObjects getObjekte() {
		return aktuelleElemente;
	}
}
