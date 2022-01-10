package spielelemente;

public class EventFass extends Fass implements IFSpielelement {

	/**
	 * Verwalten und Auslösen der Events
	 * @param go, GameObjects zum zugriff auf andere Objecte
	 * @param breite, Anzahl der möglichen Nebeneinanderliegenden Fässer
	 * @param betroffen, Fass welches von Events mit betroffen ist aber NICHT das aufgerufene Eventfass
	 * @param symbol, zeichen des Eventes
	 * @param st, zum zugriff auf andere Objecte
	 * @param con, zum zugriff auf andere Objecte
	 * @author ischramm
	 */
	
	private GameObjects go;
	//private byte symbol; // als Array 0 =kein Event {1,2,3,4 = Event}
	private Fass betroffen;
	private int breite = 20;
	private zentral.Steuerung st;
	private zentral.Controller con;

	public EventFass(int fassNummer, int leben, int eventnummer) {
		super(fassNummer, leben, eventnummer);
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
					st.rumAktiviert(true);
			case 4: //Wind:
				con.erhoeheWellenstand(true);
			}
	}
}
