package zentral;

public interface IFZentral {
	/**
	 * damit bei tastendruck ueberprueft werden kann, ob der spieler noch im panel ist
	 * @return Spielerposition horizontal als Integer
	 * @author iveev
	 */
	public int getSpielerPositionX();

	/**
	 * Erstellt/Gibt die Steuerung(Singleton).
	 * muss mir aber noch mal angucken wie genau das geht
	 * 
	 * @author iveev
	 */
	public Steuerung getSteuerung();
	
	/**
	 * Erstellt die Levelelemente zu dem ausgesuchten Aufbau und Schwierigkeit.
	 * 
	 * @author iveev
	 */
	public void erstelleLevel(byte a, byte b);
}
