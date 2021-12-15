package zentral;

public interface IFZentral {
	/**
	 * damit bei tastendruck ueberprueft werden kann, ob der spieler noch im panel ist
	 * @return Spielerposition horizontal als Integer
	 * @author Ines Rohrbach
	 */
	public int getSpielerPositionX();

	/**
	 * Erstellt/Gibt die Steuerung(Singleton).
	 * muss mir aber noch mal angucken wie genau das geht
	 * 
	 * @author Ines Rohrbach
	 */
	public Steuerung getSteuerung();
	
	/**
	 * Erstellt die Levelelemente zu dem ausgesuchten Aufbau und Schwierigkeit.
	 * 
	 * @author Ines Rohrbach
	 */
	public void erstelleLevel(byte a, byte b);
}
