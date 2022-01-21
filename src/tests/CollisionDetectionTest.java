package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.BeforeParam;

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
        assertTrue("Kollision mit Vector 1, 1 unterhalb",-1.0 == gameObjects.getKugel(0).getxVelocity());
    }

    @Test
    void testCheckCollision1(){
        setup1Kugel1Fass(22, -1, -5, 1, 1);
        collisionDetection.checkCollision();
        assertTrue("Kollision mit Vector 1, 1 oberhalb",-1.0 == gameObjects.getKugel(0).getyVelocity());
    }
}
