package gui;
import javax.swing.JPanel;
import javax.swing.Timer;

import zentral.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Graphics;

/**
 * Klasse f√ºr das Anzeigen des eigentlichen Spiels
 * 
 * @author Gregor Scholz
 */
public class InGamePanel extends JPanel {

    static final int tick = 0;

    Timer timer;
    boolean running;

    public InGamePanel() {
        setup();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setup() {
        this.addKeyListener(new Controller.getSteuerung()); //ich weiﬂ nicht warum er nicht erkennt, dass Steuerung KeyListener implementiert
        timer = new Timer(tick, new GameActionListener());
    }

    public void startGame() {
        running = true;
    }

    public class GameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(running) {
                /**
                 * checkBallCollisions();
                 * updatePlatform();
                 */
                repaint();
            }  
        }
        
    }

    //eigentlich abgeloesst
    /*public class GameKeyListener implements KeyListener { 

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

    }*/
}
