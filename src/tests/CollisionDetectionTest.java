package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import gui.InGamePanel;
import spielelemente.*;

public class CollisionDetectionTest {
    CollisionDetection collisionDetection;
    GameObjects gameObjects;

    void setup1Kugel1Fass(int fassnummer, int kXOffset, int kYOffset, double vX, double vY){
        ArrayList<IFSpielelement> elemente = new ArrayList<IFSpielelement>();
        Fass f = new Fass(22, 1, 0);
        Kugel k = new Kugel(0, 1);
        k.setxKoordinate((int)f.getX()+kXOffset); k.setyKoordinate((int)f.getY()+kYOffset);
        k.setxVelocity(vX); k.setyVelocity(vY);
        k.setIstAktiv(0);
        elemente.add(f); 
        elemente.add(k);
        elemente.add(new Plattform(1, 3));
        gameObjects = new GameObjects(elemente);
        collisionDetection = new CollisionDetection(gameObjects, new InGamePanel());
    }

    @Test
    void testCheckCollision0() {      
        setup1Kugel1Fass(22, -2, -1, 1, 1);
        collisionDetection.checkCollision();
        assertEquals(-1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision1(){
        setup1Kugel1Fass(22, -1, -2, 1, 1);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }


    @Test
    void testCheckCollision2() {      
        setup1Kugel1Fass(22, -2, -1, -1, -1);
        collisionDetection.checkCollision();
        assertEquals(-1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision3(){
        setup1Kugel1Fass(22, -2, -5, -1, -1);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision4() {      
        setup1Kugel1Fass(22, -2, 0, 1, -1);
        collisionDetection.checkCollision();
        assertEquals(-1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision5(){
        setup1Kugel1Fass(22, 0, 5, 1, -1);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }
    @Test
    void testCheckCollision6() {      
        setup1Kugel1Fass(22, -2, 0, -1, 1);
        collisionDetection.checkCollision();
        assertEquals(-1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision7(){
        setup1Kugel1Fass(22, 0, 5, -1, 1);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision9(){
        setup1Kugel1Fass(22, -1, -1, 1, 0);
        collisionDetection.checkCollision();
        assertEquals(-1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(0.0, gameObjects.getKugel(0).getyVelocity(), 0.1);

        setup1Kugel1Fass(22, -1, -1, -1, 0);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(0.0, gameObjects.getKugel(0).getyVelocity(), 0.1);

        setup1Kugel1Fass(22, 1, 1, 0, 1);
        collisionDetection.checkCollision();
        assertEquals(0.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);

        setup1Kugel1Fass(22, 1, 1, 0, -1);
        collisionDetection.checkCollision();
        assertEquals(0.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }
}
