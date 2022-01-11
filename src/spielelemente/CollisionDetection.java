package spielelemente;

import java.awt.Rectangle;
import java.awt.geom.Point2D;

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
            if(i != null){
                if(gameObjects.getKugel().intersects(i)){
                    i.treffer();
                    gameObjects.getKugel().setxVelocity(calcVector(i)[0]);
                    gameObjects.getKugel().setyVelocity(calcVector(i)[1]);
                }
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
            gameObjects.getKugel().setxVelocity(calcVector(gameObjects.getPlattform())[0]);
            gameObjects.getKugel().setyVelocity(calcVector(gameObjects.getPlattform())[1]);
            return true;
        }
        return false;
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
        if(gameObjects.getKugel().getyKoordinate() < gameObjects.getPlattform().getMinY()){
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
        boolean xVorz;
        boolean yVorz;
        if(gameObjects.getKugel().getxVelocity()<0){xVorz = false;}
        else if(gameObjects.getKugel().getxVelocity()>0){xVorz = true;}
        else{return new double[]{0.0, -gameObjects.getKugel().getyVelocity()};}
        if(gameObjects.getKugel().getxVelocity()<0){yVorz = false;}
        else if(gameObjects.getKugel().getxVelocity()>0){yVorz = true;}
        else{return new double[]{-gameObjects.getKugel().getxVelocity(), 0.0};}
        boolean oberhalb = eckUnterscheidung(coll, xVorz, yVorz);
        boolean flip = yVorz^oberhalb;
        if(flip){return new double[]{-gameObjects.getKugel().getxVelocity(), gameObjects.getKugel().getxVelocity()};}
        else{return new double[]{gameObjects.getKugel().getxVelocity(), -gameObjects.getKugel().getxVelocity()};}
    }

    /**
     * Hilfsfunktion zur Bestimmung der Variable "oberhalb" in this.calcVerctor(Rectangle)
     *@author fseiffer
     *@return ob kugel oberhalb oder unterhalb von "collEcke" kollidiert
     *@param coll Objekt, mit dem Kugel kollidiert
     *@param xVorz xRichtung des Bewegungsvectors
     *@param yVorz yRichtung des Bewegungsvectors
    */
    private boolean eckUnterscheidung(Rectangle coll, boolean xVorz, boolean yVorz){
        Gerade g;
        Point2D.Double collEcke;
        Point2D.Double vec = new Point2D.Double(gameObjects.getKugel().getxVelocity(),gameObjects.getKugel().getyVelocity());
        if(xVorz && yVorz){
            g = new Gerade(new Point2D.Double(gameObjects.getKugel().getMaxX(), gameObjects.getKugel().getMaxY()), vec);
            collEcke = new Point2D.Double(coll.getMinX(), coll.getMinY());
        }
        else if(!xVorz && !yVorz){
            g = new Gerade(new Point2D.Double(gameObjects.getKugel().getMinX(), gameObjects.getKugel().getMinY()), vec);
            collEcke = new Point2D.Double(coll.getMaxX(), coll.getMaxY());
        }
        else if(!xVorz && yVorz){
            g = new Gerade(new Point2D.Double(gameObjects.getKugel().getMinX(), gameObjects.getKugel().getMaxY()), vec);
            collEcke = new Point2D.Double(coll.getMaxX(), coll.getMinY());
        }
        else{
            g = new Gerade(new Point2D.Double(gameObjects.getKugel().getMaxX(), gameObjects.getKugel().getY()), vec);
            collEcke = new Point2D.Double(coll.getMinX(), coll.getMaxY());
        }
        return g.istOberhalb(collEcke);
    }

    /**
    * Hilfsklasse zur Darstellungen von Geraden 
    * @author fseiffer
    */

    private class Gerade{
        private double m;
        private double t;

        public Gerade(Point2D.Double p, Point2D.Double vector){
            m = vector.getX()/vector.getY();
            t = p.getY() + p.getX()*m;
        }

        /**
        * Ueberprüfen, ob Punkt p Oberhalb der Gerde liegt (also kleineres Y, da Ursprung oben, links)
        *@author fseiffer
        *@return Ob Punkt p oberhalb, der Geraden
        */

        public boolean istOberhalb(Point2D.Double p){
            double y = m*p.getX()+t;
            if(y > p.getY()){
                return true;
            } 
            return false;
        }
    }
}
