package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import zentral.Controller;

class TestController {

	@Test
	void test() {
		Controller.erstelleLevel(4, 0);
		assertNotNull("Keine Elemente erstellt", Controller.getObjekte());
		assertNotNull(Controller.getObjekte().getKugel(0));
	}

}
