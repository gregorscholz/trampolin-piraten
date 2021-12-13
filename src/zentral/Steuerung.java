package zentral;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasse zur Einstellung der Steuerung per Tastatur und... .
 * 
 * @author iveev
 */
public class Steuerung implements KeyListener {
	private char bewegungRechts = KeyEvent.VK_RIGHT; //VK_RIGHT oder VK_D
	private char bewegungLinks = KeyEvent.VK_LEFT; //VK_LEFT oder VK_A
	
	/**
	 * Legt fest ob mit Pfeiltasten oder mit 'a' und 'd' gesteuert werden soll.
	 * 
	 * @author iveev
	 */
	public void setPfeilTasten(boolean b) {		
	}
	
	/**
	 * Lauscht auf die Tastenansteuerung der ausgewaehlten Steuerungstasten
	 * 
	 * @author iveev
	 */
	@Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==bewegungRechts) {
        	if(Controller.getSpielerPositionX() >=1400) {
        		Controller.getSpielerPositionX() = 1400;///ob das die richtigen werte sind noch einmal überprüfn
        	} else {
        		Controller.bewegenNachRechts();
        	}
        }
        if(e.getKeyCode()==bewegungLinks) {
        	if(Controller.getSpielerPositionX() <=0) {
        		Controller.getSpielerPositionX() = 0; ////ob das die richtigen werte sind noch einmal überprüfne
        	} else {
        		Controller.bewegenNachLinks();
        	}
        }

        
    }
	
	@Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
