package spielelemente;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Kugel extends Rectangle implements IFSpielelement {

	static final int BALL_DIAMETER = 9; //!!!!!! einfach damit die fehlermeldung weg ist
	int xVelocity;
	int yVelocity;
	int xKoordinate, yKoordinate;


	public Kugel(){
        //Initialkoordinaten als Parameter, damit Ballmultiplikatorevent am Block Baelle erstellen kann
        //Initialgeschwindigkeit
        //Gr��e (Durchmesser)
	}
	
	//Getter und Setter
	
	public void setxVelocity(int newxVelocity){
        xVelocity = x;
    }

    public void setyVelocity(int newyVelocity){
        yVelocity = newyVelocity;
    }

	public int getxVelocity() {
		return xVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
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
		//malt die Kugel; wird wahrscheinlich von Gregor in der GUI uebernommen
	}
}
