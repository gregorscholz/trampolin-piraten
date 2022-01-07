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
		
		String[] block = s.split(",",4);
		String typ = block[0];
		int nummer = Integer.parseInt(block[1]);
		int leben = Integer.parseInt(block[2]);
		int eNummer = Integer.parseInt(block[3]);
		
		switch(typ) {
		case "F": e = new Fass(nummer, leben, eNummer);
				break;
		case "P": e = new Plattform();
				break;
		case "K": e = new Kugel();
				break;
		default:
			break;
		}
		
		return e;
	}
}
