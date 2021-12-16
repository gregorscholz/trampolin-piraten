package zentral;

import spielelemente.IFSpielelement;

/**
 * Factory-Klasse, welche einzelne Spielelemente nach den Vorgaben in Textform erstellt.
 * 
 * @author Ines Rohrbach
 */
public abstract class LevelFactory {
	/**
	 * Erstellt ein Spielelement nach dem Vorgaben in der Textform.
	 * 
	 * @param s, der String, in dem die Vorgaben des Elements stehen
	 * @return Das erstellte Element
	 * @author Ines Rohrbach
	 */
	public IFSpielelement erstelleElement(String s) {
		IFSpielelement e = null;
		return e;
	}
}