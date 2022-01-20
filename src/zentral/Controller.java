package zentral;

import java.util.Iterator;
import java.util.Set;

import gui.GamePanel;
import spielelemente.GameObjects;
import spielelemente.IFSpielelement;
import spielelemente.Kugel;
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
		aktuelleElemente.getPlattform().moveRight();
	}
	
	/**
	 * anweisung die Plattform nach links zu schieben.
	 * 
	 * @author Ines Rohrbach
	 */
	public static void bewegenNachLinks() {
		aktuelleElemente.getPlattform().moveLeft();
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
		GamePanel.getInGameP().startGame();
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
	 * Aktiviert die Kugel des Fasses >>i<<.
	 * 
	 * @param i, (Event)Fassnummer
	 * @author Ines Rohrbach
	 */
	public static void aktiviereKugel(int i) {
		Iterator<Kugel> j = aktuelleElemente.getKugeln().iterator();
		while(j.hasNext()) {
			Kugel k = j.next();
			if(k.getIstAktiv() == i) {
				k.setIstAktiv(0);
				break;
			}
		}
	}
	
	/**
	 * Beendet das Level und ermoeglicht das Weiterspielen.
	 * Sorgt dafuer, dass keine Elemente und Sondereinstellungen von dem vorherigen Spiel uebrig ist.
	 * 
	 * @author Ines Rohrbach
	 */
	public void spielBeendet()  {
		GamePanel.getInGameP().beendet();
		aktuelleElemente = null;
		rumAktiviert(false);
		
		//Gewonnen/Verloren
		//Anzeige Gewonnen Verloren
		//bei der anzeige auch fragen ob zurueck zur levelauswahl oder hauptmenue
	}
}
