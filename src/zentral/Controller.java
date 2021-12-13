package zentral;

/**
 * Zentrale Verwaltungsklasse, die das Interface IFZentral implementiert.
 * 
 * @author iveev
 */
public class Controller implements IFZentral {
	@Override
	public int getSpielerPositionX() {
		return woauchimmer.getSpielerPositionX();
	}
	@Override
	public Steuerung getSteuerung() {
		return new Steuerung();
	}

}
