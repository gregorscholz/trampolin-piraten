package spielelemente;

import zentral.Controller;

public class EventFass extends Fass implements IFSpielelement {

	/**
	 * Verwalten und Auslösen der Events
	 * @param go, GameObjects zum zugriff auf andere Objecte
	 * @param breite, Anzahl der möglichen Nebeneinanderliegenden Fässer
	 * @param betroffen, Fass welches von Events mit betroffen ist aber NICHT das aufgerufene Eventfass
	 * @param symbol, zeichen des Eventes
	 * @author ischramm
	 */
	
	private GameObjects go = Controller.getObjekte();
	//private byte symbol; // als Array 0 =kein Event {1,2,3,4,5 = Event}
	private Fass betroffen;
	private int breite = 20;

	public EventFass(int fassNummer, int leben, int eventnummer) {
		super(fassNummer, leben, eventnummer);
		System.out.println("EVENTFASS");
			switch(eventnummer) {
			case 1: //Schwarzpulver
				betroffen = go.getFass(fassNummer- (breite +1));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer- (breite));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer- (breite-1));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer- (1));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer+ (1));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer+ (breite -1));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer+ (breite));
				if(betroffen!=null) betroffen.treffer();
				betroffen = go.getFass(fassNummer+ (breite +1));
				if(betroffen!=null) betroffen.treffer();
			case 2: //Munition
				Controller.aktiviereKugel(fassNummer);
			case 3: // Rum: 
				Controller.rumAktiviert(true);
			case 4: //wellenstand erhöhen
				Controller.erhoeheWellenstand(true);
			case 5: //wellenstand verringern
				Controller.erhoeheWellenstand(false);
			}
	}
}
