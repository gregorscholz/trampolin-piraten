package spielelemente;

import zentral.Controller;

public class EventFass extends Fass implements IFSpielelement {

	/**
	 * Verwalten und Ausl�sen der Events
	 * @param go, GameObjects zum zugriff auf andere Objecte
	 * @param breite, Anzahl der m�glichen Nebeneinanderliegenden F�sser
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
		go.entferneFass(fassNummer);
			switch(eventnummer) {
			case 1: //Schwarzpulver
				betroffen = go.getFass(fassNummer- (breite +1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer- (breite));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer- (breite-1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer- (1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer+ (1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer+ (breite -1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer+ (breite));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				betroffen = go.getFass(fassNummer+ (breite +1));
				if(betroffen!=null) if(betroffen.treffer()==0) go.entferneFass(betroffen.getPosition());
				break;
			case 2: //Munition
				Controller.aktiviereKugel(fassNummer);
				break;
			case 3: // Rum: 
				Controller.rumAktiviert(true);
				break;
			case 4: //wellenstand erh�hen
				Controller.erhoeheWellenstand(true);
				break;
			case 5: //wellenstand verringern
				Controller.erhoeheWellenstand(false);
				break;
			}
	}
}
