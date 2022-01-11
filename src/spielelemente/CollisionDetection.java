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
        for(Kugel i: gameObjects.getKugeln()){
            if(i != null){
                if(checkSeiten(i)){
                    return true;
                }
                if(checkPlattform(i)){
                    return true;
                }
                if(checkFaesser(i)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Abfrage aller Faesser und Bewegung der Kugel setzen
     * Beschaedigen der Faesser
     *@author fseiffer
     *@param kugel aktuelle Kugel
     *@return Kollision
    */
    private boolean checkFaesser(Kugel kugel){
        for(Fass i : gameObjects.getFaesser()){
            if(i != null){
                if(kugel.intersects(i)){
                    i.treffer();
                    kugel.setxVelocity(calcVector(i, kugel)[0]);
                    kugel.setyVelocity(calcVector(i, kugel)[1]);
                }
            }
        }
        return false;
    }

    /**
     * Abfrage der Plattform und Bewegung der Kugel setzen
     *@author fseiffer
     * @param kugel aktuelle Kugel
     *@return Kollision
    */
    private boolean checkPlattform(Kugel kugel){
        if(kugel.intersects(gameObjects.getPlattform())){
            kugel.setxVelocity(calcVector(gameObjects.getPlattform(), kugel)[0]);
            kugel.setyVelocity(calcVector(gameObjects.getPlattform(), kugel)[1]);
            return true;
        }
        return false;
    }
    
    /**
     * Abfrage der Seiten und Bewegung der Kugel setzen
     *@author fseiffer
     * @param kugel aktuelle Kugel
     *@return Kollision
    */
    private boolean checkSeiten(Kugel kugel){
        //Kugel triff links o. rechts
        if(kugel.getxKoordinate() <= 0 || kugel.getMaxX() >= panel.getWidth()){
            kugel.setxVelocity(-kugel.getxVelocity());
            return true;
        }
        //Kugel trifft oben
        if(kugel.getyKoordinate() >= panel.getWidth()){
            kugel.setxVelocity(-kugel.getyVelocity());
            return true;
        }
        //Kugel trifft unten
        if(kugel.getyKoordinate() < gameObjects.getPlattform().getMinY()){
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
     *@param kugel aktuelle Kugel
    */
    private double[] calcVector(Rectangle coll, Kugel kugel){
        boolean xVorz;
        boolean yVorz;
        if(kugel.getxVelocity()<0){xVorz = false;}
        else if(kugel.getxVelocity()>0){xVorz = true;}
        else{return new double[]{0.0, -kugel.getyVelocity()};}
        if(kugel.getxVelocity()<0){yVorz = false;}
        else if(kugel.getxVelocity()>0){yVorz = true;}
        else{return new double[]{-kugel.getxVelocity(), 0.0};}
        boolean oberhalb = eckUnterscheidung(coll, xVorz, yVorz, kugel);
        boolean flip = yVorz^oberhalb;
        if(flip){return new double[]{-kugel.getxVelocity(), kugel.getxVelocity()};}
        else{return new double[]{kugel.getxVelocity(), -kugel.getxVelocity()};}
    }

    /**
     * Hilfsfunktion zur Bestimmung der Variable "oberhalb" in this.calcVerctor(Rectangle)
     *@author fseiffer
     *@return ob kugel oberhalb oder unterhalb von "collEcke" kollidiert
     *@param coll Objekt, mit dem Kugel kollidiert
     *@param xVorz xRichtung des Bewegungsvectors
     *@param yVorz yRichtung des Bewegungsvectors
     *@param kugel aktuelle Kugel
    */
    private boolean eckUnterscheidung(Rectangle coll, boolean xVorz, boolean yVorz, Kugel kugel){
        Gerade g;
        Point2D.Double collEcke;
        Point2D.Double vec = new Point2D.Double(kugel.getxVelocity(),kugel.getyVelocity());
        if(xVorz && yVorz){
            g = new Gerade(new Point2D.Double(kugel.getMaxX(), kugel.getMaxY()), vec);
            collEcke = new Point2D.Double(coll.getMinX(), coll.getMinY());
        }
        else if(!xVorz && !yVorz){
            g = new Gerade(new Point2D.Double(kugel.getMinX(), kugel.getMinY()), vec);
            collEcke = new Point2D.Double(coll.getMaxX(), coll.getMaxY());
        }
        else if(!xVorz && yVorz){
            g = new Gerade(new Point2D.Double(kugel.getMinX(), kugel.getMaxY()), vec);
            collEcke = new Point2D.Double(coll.getMaxX(), coll.getMinY());
        }
        else{
            g = new Gerade(new Point2D.Double(kugel.getMaxX(), kugel.getY()), vec);
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
