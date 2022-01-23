package spielelemente;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gui.InGamePanel;

import zentral.Controller;

/**
 * Klasse zum Erkennen und Verarbeiten von Kollisionen zw. Objekten * 
 * @author fseiffer
 */

public class CollisionDetection{    
    
    public CollisionDetection(){

    }

    public CollisionDetection(GameObjects g, InGamePanel p){

    }
    
    /**
     *Abfrage der verschieden Objektgruppen bis eine Kollision auftritt
     *@author fseiffer
     *@return Kollision
     */
    public void checkCollision(){
        for(Kugel i: Controller.getObjekte().getKugeln()){
            if(i != null && i.getIstAktiv()==0){
                if(checkSeiten(i)){
                    break;
                }
                if(checkPlattform(i)){
                    break;
                }
                if(checkFaesser(i)){
                    break;
                }
            }
        }
    }
    /**
     * Abfrage aller Faesser und Bewegung der Kugel setzen
     * Beschaedigen der Faesser
     *@author fseiffer
     *@param kugel aktuelle Kugel
     *@return Kollision
    */
    private boolean checkFaesser(Kugel kugel){
    	ArrayList<Fass> faesser = new ArrayList<Fass>(Controller.getObjekte().getFaesser()); //weil ich nicht weiss ob dich die for schleife bewert oder nicht, wenn das so ist wie vorher
        for(Fass i : faesser/*Controller.getObjekte().getFaesser()*/){
            if(i != null){
                if(kugel.intersects(i)){
                	int j = i.treffer();
                	if(j==0) {
                		Controller.getObjekte().entferneFass(i.getPosition());
                        if(Controller.getObjekte().getFaesser().size()<=0){
                            Controller.spielBeendet(true);
                        }
                	}
                	double[] vec = calcVector(i, kugel);
                    kugel.setxVelocity(vec[0]);
                    kugel.setyVelocity(vec[1]);
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
        if(kugel.intersects(Controller.getObjekte().getPlattform())){
            kugel.setxVelocity(calcVector(Controller.getObjekte().getPlattform(), kugel)[0]);
            kugel.setyVelocity(calcVector(Controller.getObjekte().getPlattform(), kugel)[1]);
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
        if(kugel.getX() <= 0 || kugel.getMaxX() >= 1400){
            kugel.setxVelocity(-kugel.getxVelocity());
            return true;
        }
        //Kugel trifft oben
        if(kugel.getY() <= 0){
            kugel.setyVelocity(-kugel.getyVelocity());
            return true;
        }
        //Kugel trifft unten
        if(kugel.getY() > Controller.getObjekte().getPlattform().getWellenstand()){
            resetKugel(kugel);
            return true;
        }
        return false;
    }

    /**
     * Kugel auf inaktiv setzen, evtl. spiel beenden
     *@author fseiffer
     * @param kugel aktuelle Kugel
    */
    private void resetKugel(Kugel kugel){
        kugel.setIstAktiv(24797);
        for(Kugel i : Controller.getObjekte().getKugeln()){
            if(i.getIstAktiv()==0)
            return;
        }
        Controller.spielBeendet(false);
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

        if(kugel.getyVelocity()<0){yVorz = false;}
        else if(kugel.getyVelocity()>0){yVorz = true;}
        else{return new double[]{-kugel.getxVelocity(), 0.0};}
        
        boolean oberhalb = eckUnterscheidung(coll, xVorz, yVorz, kugel);
        boolean flip = (!xVorz && !yVorz && oberhalb)||(!xVorz && yVorz && !oberhalb)
            ||(xVorz && !yVorz && oberhalb)||(xVorz && yVorz && !oberhalb);//yVorz^oberhalb;
        if(!flip){return new double[]{-kugel.getxVelocity(), kugel.getyVelocity()};}
        else{return new double[]{kugel.getxVelocity(), -kugel.getyVelocity()};}
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
            g = new Gerade(new Point2D.Double(kugel.getMaxX(), kugel.getMinY()), vec);
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
            m = vector.getY()/vector.getX();
            t = p.getY() - p.getX()*m;
        }

        /**
        * Ueberprüfen, ob Punkt p Oberhalb der Gerde liegt (also kleineres Y, da Ursprung oben, links)
        * 
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
