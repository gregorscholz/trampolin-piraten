package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.InGamePanel;
import spielelemente.Plattform;
import zentral.Controller;
import zentral.Steuerung;

class TestSteuerung {
	Robot rob = null;
	Plattform p = null;
	JPanel j = null;
	
	@BeforeEach
	void setUp() {
		try {
			rob = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller.erstelleLevel(4, 0);
		p = Controller.getObjekte().getPlattform();
		j = new InGamePanel();
	}

	@Test
	void test() {
		Steuerung s = Steuerung.getSteuerung();
		assertNotNull("Steuerung ist null", s);
		assertEquals("Plattform ist nicht auf der Startposition", p.getxKoordinate(), 600);
		rob.keyPress(KeyEvent.VK_RIGHT);
		assertEquals("Plattform hat sich nicht einmal Bewegt", p.getxKoordinate(), 620);
		assertEquals("Plattform ist nicht am rechten Bildschirmrand", p.getxKoordinate(), 1180);
		rob.keyPress(KeyEvent.VK_LEFT);
		assertEquals("Plattform hat sich nicht nach links Bewegt", p.getxKoordinate(), 600);
		assertEquals("Plattform ist nicht am linken Bildschirmrand", p.getxKoordinate(), 0);
		rob.keyPress(KeyEvent.VK_LEFT);
		assertEquals("Plattform hat sich nicht weiter nach links Bewegt", p.getxKoordinate(), 580);
		assertEquals("Plattform ist nicht am linken Bildschirmrand", p.getxKoordinate(), 0);
	}

}
