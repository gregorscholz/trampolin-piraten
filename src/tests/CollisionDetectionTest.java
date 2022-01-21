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
        Kugel k = new Kugel(f.getxKoordinate()+kXOffset, f.getyKoordinate()+kYOffset, 0);
        k.setxVelocity(vX); k.setyVelocity(vY);
        elemente.add(f); 
        elemente.add(k);
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
        setup1Kugel1Fass(22, -2, -5, 1, 1);
        collisionDetection.checkCollision();
        assertEquals(1.0, gameObjects.getKugel(0).getxVelocity(), 0.1);
        assertEquals(-1.0, gameObjects.getKugel(0).getyVelocity(), 0.1);
    }

    @Test
    void testCheckCollision2(){
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
