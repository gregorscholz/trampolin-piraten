package spielelemente;

public class EventFass extends Fass implements IFSpielelement {

	/**
	 * Verwalten und Auslösen der Events
	 * @param go, GameObjects zum zugriff auf andere Objecte
	 * @param breite, Anzahl der möglichen Nebeneinanderliegenden Fässer
	 * @param betroffen, Fass welches von Events mit betroffen ist aber NICHT das aufgerufene Eventfass
	 * @param symbol, zeichen des Eventes
	 * @author ischramm
	 */
	
	private GameObjects go;
	//private byte symbol; // als Array 0 =kein Event {1,2,3,4 = Event}
	private Fass betroffen;
	private int breite = 20;
	//zentral.Steuerung st = new zentral.Steuerung();

	public EventFass(int fassNummer, int eventnummer) {
		super(eventnummer);
			switch(eventnummer) {
			case 1: //Schwarzpulver
				betroffen = go.getFass(fassNummer- (breite +1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer- (breite));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer- (breite-1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer- (1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer+ (1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer+ (breite -1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer+ (breite));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
				betroffen = go.getFass(fassNummer+ (breite +1));
				betroffen.treffer(betroffen.getPosition(), betroffen.getLeben(), betroffen.getEvent());
			case 2: //Munition
					for(int anzahlBaelle = 0; anzahlBaelle<7; anzahlBaelle++){ // anzahl der neuen Bälle Sinnvoll?
						Kugel ball = new Kugel(); //kommentar ines: nicht so - änderung folgt
					}
			case 3: // Rum: 
					//st.rumAktiviert(true);
			case 4: //Wind:
				zentral.Controller.erhoeheWellenstand(true);
			}
	}
}
