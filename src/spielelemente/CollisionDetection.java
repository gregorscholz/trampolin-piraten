package spielelemente;

import java.awt.Rectangle;

import gui.InGamePanel;

import zentral.Controller;

/**
 * Klasse zum Erkennen und Verarbeiten von Kollisionen zw. Objekten * 
 * @author fseiffer
 */

public class CollisionDetection {    
    
    GameObjects gameObjects;
    InGamePanel panel;
    Controller controller;
    
    public CollisionDetection(GameObjects g, InGamePanel p){
        gameObjects = g;
        panel = p;
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
        //Kugel triff links o. rechts
        if(gameObjects.getKugel().getPosX <= 0 || gameObjects.getKugel().getPosX() >= (panel.getWidth()- gameObjects.getKugel().getWidth())){
            gameObjects.getKugel().setVelX(-gameObjects.getKugel().getVelX());
            return true;
        }
        //Kugel trifft oben
        if(gameObjects.getKugel().getPosY() >= panel.getWidth()){
            gameObjects.getKugel().setVelY(-gameObjects.getKugel().getVelY());
            return true;
        }
        //Kugel trifft unten
        if(gameObjects.getKugel().getPosY() <= 0){
            //controller.resetKugel();
            return true;
        }
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
