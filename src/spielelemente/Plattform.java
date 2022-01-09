package spielelemente;

import java.awt.event.*;
import java.awt.*;

public class Plattform extends Rectangle implements IFSpielelement {

	//int PlattformBreite;
	//int PlattformGroesse;
	int xVelocity;
	int xKoordinate, yKoordinate;
	
	
	public Plattform(int y, int velocity){
		super(600, y, 200, 25);
		xVelocity = velocity;

	}
	
	
	//für tests
	public Plattform(int i){
		this.yKoordinate = i;
	}
	
	//Getter und Setter
	
	/*
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
	*/
	
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
	
	public void setWellenstand(int c) {
		switch(c) {
		case 0:
			yKoordinate = 1350-height;
			break;
		case 1:
			yKoordinate = 1300-height;
			break;
		case 2:
			yKoordinate = 1250-height;
			break;
		}
	}

	
	//andere Methoden
	
	public void move() {
		
	}
	
	public void draw(Graphics g) {
		//malt die Plattform; wird wahrscheinlich von Gregor in der GUI uebernommen
	}
}
