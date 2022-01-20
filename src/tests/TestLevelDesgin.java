package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

import spielelemente.Fass;
import spielelemente.IFSpielelement;
import spielelemente.Kugel;
import zentral.LevelDesign;

class TestLevelDesgin {

	@Test
	void testLevelMitKonstruktor() {
		LevelDesign ld = new LevelDesign(4, 0);
		assertNotNull("Design ist null", ld);
		ArrayList<IFSpielelement> s = ld.getElemente();
		Fass f = (Fass) s.get(0);
		assertEquals("Erstes Fass stimmt nicht", f.getLeben(), 8);
		assertEquals("Letzte Kugel stimmt nicht", s.get(143).getClass(), Kugel.class);
		assertNotNull("Set ist null", s);
		assertEquals("Anzahl ist nicht richtig", s.size(), 144);
	}

}
