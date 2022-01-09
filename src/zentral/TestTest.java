package zentral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spielelemente.Fass;
import spielelemente.Kugel;
import spielelemente.Plattform;

class TestTest {
	private ArrayList<String> elemente = new ArrayList<String>();
	
	@BeforeEach
	void setUp() {
		File fileAlleStadt = new File("teins.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileAlleStadt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Datei lesen fehlerhaft!");
		}while(scanner.hasNextLine()) {
			elemente.add(scanner.nextLine());
		}
	}

	@Test
	void testFabrikFass() {
		Fass e = (Fass) LevelFactory.erstelleElement(elemente.get(0));
		assertNotNull("Element ist null", e);
		int p = e.getPosition();
		assertNotNull("Position ist null", p);
		assertEquals("Position ist nicht richtig", p, 8);
	}
	
	@Test
	void testFabrikPlattform() {
		Plattform e = (Plattform) LevelFactory.erstelleElement(elemente.get(1));
		assertNotNull("Element ist null", e);
		int p = e.getyKoordinate();
		assertNotNull("Position ist null", p);
		assertEquals("Position ist nicht richtig", p, 8);
	}
	
	@Test
	void testFabrikKugel() {
		Kugel e = (Kugel) LevelFactory.erstelleElement(elemente.get(2));
		assertNotNull("Element ist null", e);
		int p = e.getAktiv();
		assertNotNull("Position ist null", p);
		assertEquals("Position ist nicht richtig", p, 8);
	}
}
