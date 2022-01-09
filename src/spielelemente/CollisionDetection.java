package spielelemente;

import java.awt.Rectangle;

import gui.InGamePanel;

import zentral.Controller;

/**
 * Klasse zum Erkennen und Verarbeiten von Kollisionen zw. Objekten * 
 * @author fseiffer
 */

public class CollisionDetection{    
    
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
        for(Fass i : gameObjects.getFaesser()){
            if(gameObjects.getKugel().intersects(i){
                i.triggerEvent();
                gameObjects.getKugel().setxVelocity(calcVector(gameObjects.getKugel(), i)[0]);
                gameObjects.getKugel().setyVelocity(calcVector(gameObjects.getKugel(), i)[1]);
            }
        }
        return false;
    }

    /**
     * Abfrage der Plattform und Bewegung der Kugel setzen
     *@author fseiffer
     *@return Kollision
    */
    private boolean checkPlattform(){
        if(gameObjects.getKugel().intersects(gameObjects.getPlattform())){
            gameObjects.getKugel().setxVelocity(calcVector(gameObjects.getKugel(), gameObjects.getPlattform())[0]);
            gameObjects.getKugel().setyVelocity(calcVector(gameObjects.getKugel(), gameObjects.getPlattform())[1]);
        }
    }
    
    /**
     * Abfrage der Seiten und Bewegung der Kugel setzen
     *@author fseiffer
     *@return Kollision
    */
    private boolean checkSeiten(){
        //Kugel triff links o. rechts
        if(gameObjects.getKugel().getxKoordinate() <= 0 || gameObjects.getKugel().getMaxX() >= panel.getWidth()){
            gameObjects.getKugel().setxVelocity(-gameObjects.getKugel().getxVelocity());
            return true;
        }
        //Kugel trifft oben
        if(gameObjects.getKugel().getyKoordinate() >= panel.getWidth()){
            gameObjects.getKugel().setxVelocity(-gameObjects.getKugel().getyVelocity());
            return true;
        }
        //Kugel trifft unten
        if(gameObjects.getKugel().getyKoordinate() < gameObjects.getPlattform().y){
            controller.resetKugel();//TODO
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
