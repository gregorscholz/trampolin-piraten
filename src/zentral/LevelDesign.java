package zentral;

import java.io.File;
import java.io.FileNotFoundException;
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
	private Set<IFSpielelement> alleElemente = new HashSet<IFSpielelement>();
	
	/**
	 * Konstruktor fuer ein Leveldesign, welches je nach gewaehltem Level und Schwierigkeit das gewuenschte Level erstellt.
	 * 
	 * @implNote Im moment angenommen, dass die level intern benannt sind von 0-4 und schwierigkeit von 0-2
	 * 
	 * @param design, Fassanrichtung
	 * @param schwierigkeit, Fassnummern und Eventfaesser
	 * @author Ines Rohrbach
	 */
	public LevelDesign(int design, int schwierigkeit) {	
		switch(design) {
			case 0: if(schwierigkeit == 0) {
						leseDatei("a-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("a-2.txt");
					} else {
						leseDatei("a-3.txt");
					} break;
			case 1: if(schwierigkeit == 0) {
						leseDatei("b-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("b-2.txt");
					} else {
						leseDatei("b-3.txt");
					} break;
			case 2: if(schwierigkeit == 0) {
						leseDatei("c-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("c-2.txt");
					} else {
						leseDatei("c-3.txt");
					} break;
			case 3: if(schwierigkeit == 0) {
						leseDatei("d-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("d-2.txt");
					} else {
						leseDatei("d-3.txt");
					} break;
			case 4: if(schwierigkeit == 0) {
						leseDatei("e-1.txt");
					} else if (schwierigkeit == 1) {
						leseDatei("e-2.txt");
					} else {
						leseDatei("e-3.txt");
					} break;
			default: 
				leseDatei("errorLevel.txt"); //man koennte ein extra leveldesign dafuer haben, damit fuer uns direkt klar ist das beim einlesen was nicht funktioniert, aber wir ein bisschen spa� haben koennen.
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
		File fileAlleStadt = new File(dateiname);
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileAlleStadt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Datei lesen fehlerhaft!");
		}while(scanner.hasNextLine()) {
			alleElemente.add(LevelFactory.erstelleElement(scanner.nextLine()));
		}		
	}

	/**
	 * Gibt alle f�r das Level verwendeten Spielelemente zurueck
	 * 
	 * @return alle Spielelmente des Levels in einem Hashset
	 * @author Ines Rohrbach
	 */
	public Set<IFSpielelement> getElemente() {
		return alleElemente;
	}
}
