package spielelemente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Diese Klasse verwaltet die aktuellen Spielelemente.
 * 
 * @author Ines Rohrbach
 */
public class GameObjects {
	private ArrayList<Kugel> kugeln = new ArrayList<Kugel>(10);
	private Plattform plattform;
	private ArrayList<Fass> faesser = new ArrayList<Fass>();;
	
	/**
	 * Gibt die aktuellen Faesser zurueck.
	 * Beachte: Es gilt NICHT mehr faesser.get(i) hat fass mit Position i an der stelle
	 * 
	 * @return aktuellen Faesser in einem Array
	 * @author Ines Rohrbach
	 */
	public ArrayList<Fass> getFaesser() {
		return faesser;
	}
	
	/**
	 * Gibt ein einzelnes Fass zurueck.
	 * Beachte: Fass 0 =null
	 * 
	 * @param i, Fass welches man haben moechte.
	 * @return
	 */
	public Fass getFass(int i) {
		Iterator<Fass> f = faesser.iterator();
		while(f.hasNext()) {
			Fass fass = f.next();
			if(fass.getPosition() == i) return fass; 
		}
		return null;
	}
	
	/**
	 * Entfernt ein zerstoertes Fass.
	 * 
	 * @param i, FassPosition des Fasses, welches entfernt werden soll
	 * @author Ines Rohrbach
	 */
	public void entferneFass(int i) {
		int j = 0;
		while(j<faesser.size()) {
			if(faesser.get(j).getPosition() == i) {
				faesser.remove(j);
				break;
			}
			j++;
		}
	}

	/**
	 * Gibt die Kugel zurueck.
	 * 
	 * @param i, welche Kugel
	 * @return aktuelle Kugel
	 * @author Ines Rohrbach
	 */
	public Kugel getKugel(int i) {
		return kugeln.get(i);
	}
	
	/**
	 * Gibt alle Kugeln zurueck.
	 * 
	 * @return alle Kugeln
	 * @author Ines Rohrbach
	 */
	public ArrayList<Kugel> getKugeln() {
		return kugeln;
	}

	/**
	 * Gibt die aktuelle Plattform zurueck.
	 * 
	 * @return aktuelle Plattform
	 * @author Ines Rohrbach
	 */
	public Plattform getPlattform() {
		return plattform;
	}

	/**
	 * Ein Objekt der Klasse wird immer mit den Spielelementen erstellt, die dann auch sortiert werden.
	 * 
	 * @param elemente
	 * @author Ines Rohrbach
	 */
	@SuppressWarnings("unchecked")
	public GameObjects(ArrayList<IFSpielelement> elemente) {
		int end = elemente.size()-1;
		while(elemente.get(end).getClass()!=Fass.class) {
			if(elemente.get(end).getClass()==Kugel.class) {
				kugeln.add((Kugel) elemente.remove(end));
			} else if(elemente.get(end).getClass()==Plattform.class) {
				this.plattform = (Plattform) elemente.remove(end);
			}
			end--;
		}
		faesser.addAll((Collection<? extends Fass>) elemente);
	}
}
