package zentral;

import java.util.Set;

import spielelemente.GameObjects;
import spielelemente.IFSpielelement;
import spielelemente.Plattform;

/**
 * Zentrale Verwaltungsklasse - Controller.
 * 
 * @author Ines Rohrbach
 */
public abstract class Controller {
	private static GameObjects aktuelleElemente = null;
	
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
	 * Aktiviert oder deaktiviert die vertauschte Steuerung.
	 * Rum-Event
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
	public static void erstelleLevel(int i, int j) {
		LevelDesign l = new LevelDesign(i, j);
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
	
	/**
	 * Erhoeht oder verringert den Wellenstand.
	 * Wird ausgeloesst durch ein Eventfass
	 * 
	 * @param b, true wenn erhoeht wird - false wenn er verringert wird
	 * @author Ines Rohrbach
	 */
	public static void erhoeheWellenstand(Boolean b) {
		Plattform p = aktuelleElemente.getPlattform();
		if(b) {
			if(!(p.getyKoordinate()==1250)) {
				p.setyKoordinate(p.getyKoordinate() + 50);
			}
		} else {
			if(!(p.getyKoordinate()==1350)) {
				p.setyKoordinate(p.getyKoordinate() - 50);
			}
		}
	}
	
	/**
	 * Beendet das Level und ermoeglicht das Weiterspielen.
	 * Sorgt dafuer, dass keine Elemente und Sondereinstellungen von dem vorherigen Spiel uebrig ist.
	 * 
	 * @author Ines Rohrbach
	 */
	public void spielBeendet() {
		
		//freeze spielstand bild
		aktuelleElemente = null;
		rumAktiviert(false);
		
		//Gewonnen/Verloren
		//Anzeige Gewonnen Verloren
		//bei der anzeige auch fragen ob zurueck zur levelauswahl oder hauptmenue
	}
}
