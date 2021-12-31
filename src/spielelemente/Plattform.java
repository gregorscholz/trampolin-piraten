package spielelemente;

import java.awt.event.*;
import java.awt.*;

public class Plattform extends Rectangle implements IFSpielelement {

	int PlattformBreite;
	int PlattformGroesse;
	int xVelocity;
	int xKoordinate, yKoordinate;
	
	
	Plattform(){
		//Initialkoordinaten
		//Groesse
		//Geschwindigkeit in x-richtung (0), aendert sich wenn Plattform bewegt wird
	}
	
	//Getter und Setter
		
	public int getPlattformBreite() {
		return PlattformBreite;
	}

	public void setPlattformBreite(int plattformBreite) {
		PlattformBreite = plattformBreite;
	}

	public int getPlattformGroesse() {
		return PlattformGroesse;
	}

	public void setPlattformGroesse(int plattformGroesse) {
		PlattformGroesse = plattformGroesse;
	}

	public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getxKoordinate() {
		return xKoordinate;
	}

	public void setxKoordinate(int xKoordinate) {
		this.xKoordinate = xKoordinate;
	}

	public int getyKoordinate() {
		return yKoordinate;
	}

	public void setyKoordinate(int yKoordinate) {
		this.yKoordinate = yKoordinate;
	}

	
	//andere Methoden
	
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		//malt die Plattform; wird wahrscheinlich von Gregor in der GUI uebernommen
	}
}
