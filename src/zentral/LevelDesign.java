package zentral;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import spielelemente.IFSpielelement;

/**
 * Klasse, welche die fuer das Level notwenigen Spielelemente erstellt.
 * Die Level sind vorgefertit in Textform vorhanden.
 * 
 * @author Ines Rohrbach
 */
public class LevelDesign {
	private ArrayList<IFSpielelement> alleElemente = new ArrayList<IFSpielelement>();
	
	/**
	 * Konstruktor fuer ein Leveldesign, welches je nach gewaehltem Level und Schwierigkeit das gewuenschte Level erstellt.
	 * Die level intern benannt sind von 0-4 und schwierigkeit von 0-2
	 * 
	 * @param design, Fassanrichtung
	 * @param schwierigkeit, Fassnummern und Eventfaesser
	 * @author Ines Rohrbach
	 */
	public LevelDesign(int design, int schwierigkeit) {	
		switch(design) {
			case 0: if(schwierigkeit == 0) {
						leseDatei("level/a-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("level/a-2.txt");
					} else {
						leseDatei("level/a-3.txt");
					} break;
			case 1: if(schwierigkeit == 0) {
						leseDatei("level/b-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("level/b-2.txt");
					} else {
						leseDatei("level/b-3.txt");
					} break;
			case 2: if(schwierigkeit == 0) {
						leseDatei("level/c-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("level/c-2.txt");
					} else {
						leseDatei("level/c-3.txt");
					} break;
			case 3: if(schwierigkeit == 0) {
						leseDatei("level/d-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("level/d-2.txt");
					} else {
						leseDatei("level/d-3.txt");
					} break;
			case 4: if(schwierigkeit == 0) {
						leseDatei("level/e-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("level/e-2.txt");
					} else {
						leseDatei("level/e-3.txt");
					} break;
			default: 
				leseDatei("level/errorLevel.txt"); //man koennte ein extra leveldesign dafuer haben, damit fuer uns direkt klar ist das beim einlesen was nicht funktioniert, aber wir ein bisschen spa� haben koennen.
				break;
		}
	}
	
	/**
	 * Liesst die ausgewaehlte Textdatei ein und erstellt die Elemente ueber die Factory.
	 * 
	 * @param dateiname, Name des genauen Levels 
	 * @author Ines Rohrbach
	 */
	private void leseDatei(String dateiname) {	
		File datei = new File(dateiname);
		Scanner scanner = null;
		try {
			scanner = new Scanner(datei);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Datei lesen fehlerhaft!");
		}while(scanner.hasNextLine()) {
			alleElemente.add(LevelFactory.erstelleElement(scanner.nextLine()));
		}
	}

	/**
	 * Gibt alle fuer das Level verwendeten Spielelemente zurueck
	 * 
	 * @return alle Spielelmente des Levels in einem Hashset
	 * @author Ines Rohrbach
	 */
	public ArrayList<IFSpielelement> getElemente() {
		return alleElemente;
	}
}
