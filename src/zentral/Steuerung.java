package zentral;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasse zur Einstellung der Steuerung per Tastatur und Implementation des KeyListeners.
 * 
 * @author Ines Rohrbach
 */
public class Steuerung implements KeyListener {
	private static Steuerung angelegt = null;
	private boolean rum = false;
	private char bewegungRechts = KeyEvent.VK_RIGHT; //VK_RIGHT oder VK_D
	private char bewegungLinks = KeyEvent.VK_LEFT; //VK_LEFT oder VK_A
	
	/**
	 * Privater Konstruktor, da es sich um ein Singleton handelt.
	 * 
	 * @author Ines Rohrbach
	 */
	private Steuerung() {}
	
	/**
	 * Gibt die Steuerungsklasse zurueck.
	 * 
	 * @return die einzige Steuerungsklasse (Singleton) zurueck.
	 * @author Ines Rohrbach
	 */
	public static Steuerung getSteuerung() {
		if(angelegt == null) {
			return (angelegt = new Steuerung());
		} else {
			return angelegt;
		}
	}
	
	/**
	 * Stellt ein ob mit Pfeiltasten oder mit 'a' und 'd' gesteuert werden soll.
	 * 
	 * @param setting - 0: Pfeiltasten 1: a und d
	 * @author Ines Rohrbach
	 */
	public void setTasten(int setting) {	
		if(setting == 0) { 
			bewegungRechts = KeyEvent.VK_RIGHT;
			bewegungLinks = KeyEvent.VK_LEFT;
		} else {
			if(setting == 1) {
				bewegungRechts = KeyEvent.VK_D;
				bewegungLinks = KeyEvent.VK_A;
			} else {
				System.out.println("\tERROR\n\rirgendwas ist falsch mit der tastenbelegung aenderung\n\r");
			}
		}
	}
	
	/**
	 * Aktiviert oder deaktiviert die vertauschte steuerung
	 * 
	 * @param aktiv
	 * @author Ines Rohrbach
	 */
	public void rumAktiviert(boolean aktiv) {
		rum = aktiv;
	}
	
	/**
	 * Lauscht auf die Tastenansteuerung der ausgewaehlten Steuerungstasten.
	 * 
	 * @author Ines Rohrbach
	 */
	@Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==bewegungRechts) {
        	if(Controller.getSpielerPositionX() >=1400) {
        		//Controller.getSpielerPositionX() = 1400;///ob das die richtigen werte sind noch einmal �berpr�fn
        		//muss dann �berhaupt etwas gemacht werden?
        	} else {
        		if(!rum) Controller.bewegenNachRechts();
        		else Controller.bewegenNachLinks();
        	}
        	//eventuell auch bei der plattform �berprf�fen ob die plattform noch drin ist
        }
        if(e.getKeyCode()==bewegungLinks) {
        	if(Controller.getSpielerPositionX() <=0) {
        		//Controller.getSpielerPositionX() = 0; ////ob das die richtigen werte sind noch einmal �berpr�fne
        		//muss dann �berhaupt etwas gemacht werden?
        	} else {
        		if(!rum) Controller.bewegenNachLinks();
        		else Controller.bewegenNachRechts();
        	}
        	//eventuell auch bei der plattform �berprf�fen ob die plattform noch drin ist
        }        
    }
	
	@Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
