package zentral;

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
		for (String teilblock : block) {
			if (teilblock == null) {
				teilblock = "0";
			}
		}
		
		int wert1 = Integer.parseInt(block[1]);
		int wert2 = Integer.parseInt(block[2]);
		int wert3 = Integer.parseInt(block[3]);
		
		switch(typ) {
		case "F": e = new Fass(wert1, wert2, wert3);
				break;
		case "P": e = new Plattform(wert1, wert2);
				break;
		case "K": e = new Kugel(wert1, wert2/*, wert3*/);
				break;
		default:
			break;
		}
		
		return e;
	}
}
