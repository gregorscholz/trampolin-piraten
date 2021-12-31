package zentral;

import spielelemente.EventFass;
import spielelemente.Fass;
import spielelemente.IFSpielelement;
import spielelemente.Kugel;
import spielelemente.Plattform;

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
	public static IFSpielelement erstelleElement(String s) {
		IFSpielelement e = null;
		
		switch(s) {
		case "F"://fass
				//aufteilen
				e = new Fass(a,b,c);
				break;
		case "E"://eventfass
				//aufteilen
				e = new EventFass(a,b,c,d);
				break;
		case "P"://plattform
				//aufteilen
				e = new Plattform();
				break;
		case "K"://kugel
				//aufteilen
				e = new Kugel();
				break;
		default:
			break;
		}
		
		return e;
	}
}
