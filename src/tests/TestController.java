package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.GameFrame;
import zentral.Controller;

class TestController {

	@Test
	void test() {
		new GameFrame();
		Controller.erstelleLevel(4, 0);
		assertNotNull("Keine Elemente erstellt", Controller.getObjekte());
		assertNotNull(Controller.getObjekte().getKugel(0));
	}

}
