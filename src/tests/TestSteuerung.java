package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.GameFrame;
import zentral.Controller;
import zentral.Steuerung;

class TestSteuerung {
	Robot rob = null;
	JPanel jj = null;
	
	@BeforeEach
	void setUp() {
		new GameFrame();
		try {
			rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller.erstelleLevel(4, 0);
	}

	@Test
	void test() {
		Steuerung s = Steuerung.getSteuerung();
		assertNotNull("Steuerung ist null", s);
		assertEquals("Plattform ist nicht auf der Startposition", (int) Controller.getObjekte().getPlattform().getX(), 600);
		for(long i = 0; i<30000; i++) { rob.keyPress(KeyEvent.VK_RIGHT);}
		assertEquals("Plattform hat sich nicht einmal Bewegt", (int) Controller.getObjekte().getPlattform().getX(), 1200);
		for(long i = 0; i<1000; i++) { rob.keyPress(KeyEvent.VK_LEFT);}
		assertEquals("Plattform ist nicht am linken Bildschirmrand", (int) Controller.getObjekte().getPlattform().getX(), 0);
		for(long i = 0; i<1000; i++) { rob.keyPress(KeyEvent.VK_RIGHT);}
		assertEquals("Plattform hat sich nicht nach rechts Bewegt", (int) Controller.getObjekte().getPlattform().getX(), 1200);
		}

}
