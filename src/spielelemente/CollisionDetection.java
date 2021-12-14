package spielelemente;

import java.awt.Rectangle;

/**
 * Klasse zum Erkennen und Verarbeiten von Kollisionen zw. Objekten * 
 * @author fseiffer
 */

public class CollisionDetection {    
    
    GameObjects gameObjects;
    
    public CollisionDetection(GameObjects g){
        gameObjects = g;
    }
    
    /**
     *Abfrage der verschieden Objektgruppen bis eine Kollision auftritt
     *@author fseiffer
     *@return Kollision
     */
    public boolean checkCollision(){
        if(checkSeiten()){
            return true;
        }
        if(checkPlattform()){
            return true;
        }
        if(checkFaesser()){
            return true;
        }
        return false;
    }
    /**
     * Abfrage aller Faesser und Bewegung der Kugel setzen
     * Beschaedigen der Faesser
     *@author fseiffer
     *@return Kollision
    */
    private boolean checkFaesser(){
        return false;
    }

    /**
     * Abfrager der Plattform und Bewegung der Kugel setzen
     *@author fseiffer
     *@return Kollision
    */
    private boolean checkPlattform(){
        return false;
    }
    
    /**
     * Abfrage der Seiten und Bewegung der Kugel setzen
     *@author fseiffer
     *@return Kollision
    */
    private boolean checkSeiten(){
        return false;
    }
    
    /**
     * Berechnung der Richtung und der Geschwindigkeit der Kugel nach der Kollision
     *@author fseiffer
     *@return Richtung bzw. Geschwindigeit nach Kollision
     *@param coll Objekt, mit dem Kugel kollidiert
    */
    private double[] calcVector(Rectangle coll){
        return null;
    }
}
