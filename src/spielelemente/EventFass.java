package spielelemente;

public class EventFass extends Fass implements IFSpielelement {

	/**
	 * Verwalten und Auslösen der Events
	 * @param breite, Anzahl der möglichen Nebeneinanderliegenden Fässer
	 * @param betroffen, Fass welches von Events mit betroffen ist aber NICHT das aufgerufene Eventfass
	 * @param symbol, zeichen des Eventes
	 * @author ischramm
	 */
	
	byte symbol; // als Array 0 =kein Event {1,2,3,4 = Event}
	Fass betroffen;
	int breite = 25;

	public EventFass(int fassNummer, int eventnummer) {
		super(eventnummer);
			switch(eventnummer) {
			case 1: //Schwarzpulver
				betroffen = new Fass(fassNummer- (breite +1),0,0);
				betroffen = new Fass(fassNummer- (breite),0,0);
				betroffen = new Fass(fassNummer- (breite-1),0,0);
				betroffen = new Fass(fassNummer- (1),0,0);
				betroffen = new Fass(fassNummer+ (1),0,0);
				betroffen = new Fass(fassNummer+ (breite -1),0,0);
				betroffen = new Fass(fassNummer+ (breite),0,0);
				betroffen = new Fass(fassNummer+ (breite +1),0,0);
			case 2: //Munition: for(int i = 0, i<7, i++) Ball.bewegung = position[this];
			case 3: // Rum: Bewegungssteuerung.links = zwischenspeicher;
					//Bewegungssteuerung.links = Bewegungssteuerung.rechts;
					// Bewegungssteuerung.rechts = zwischenspeicher;
					//TimeUnit.SECONDS.sleep(5);
					//Bewegungssteuerung.links = zwischenspeicher;
					//Bewegungssteuerung.links = Bewegungssteuerung.rechts;
					// Bewegungssteuerung.rechts = zwischenspeicher;
			case 4: //Wind: Unterer Rand = unterer Rand - x Pixel
			}
	}
}
