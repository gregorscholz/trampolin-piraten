package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import gui.GameFrame;
import spielelemente.Fass;
import spielelemente.IFSpielelement;
import zentral.Controller;

class Arraylist {

	@Test
	void test() {
		new GameFrame();
		ArrayList<Fass> a = new ArrayList<Fass>();
		Controller.erstelleLevel(4, 1);
		a.addAll(Controller.getObjekte().getFaesser());
		Iterator<Fass> i = a.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().getPosition());
		}
		System.out.println("-----");
		for(int j = 110; j < 141; j++) {
			a.remove(Controller.getObjekte().getFass(j));
		}
		int k = 0;
		while(k<a.size()) {
			System.out.println(a.get(k).getPosition());
			k++;
		}
	}

}
