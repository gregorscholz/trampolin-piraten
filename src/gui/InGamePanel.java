package gui;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.Timer;

import spielelemente.CollisionDetection;
import spielelemente.Fass;
import zentral.Controller;

/**
 * Klasse für das Anzeigen des eigentlichen Spiels
 * 
 * @author Gregor Scholz
 */
public class InGamePanel extends JPanel {

    static final int tick = 0;
    static final int UNIT_SIZE = 50;

    private Timer timer;
    private boolean running;

    private int xKugel, yKugel, xPlatform, yPlatform, widthPlatform, heightPlatform;

    private CollisionDetection cd;

    public InGamePanel() {
        Dimension dim = new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.addKeyListener(Controller.getSteuerung());
        timer = new Timer(tick, new GameActionListener());
        cd = new CollisionDetection(Controller.getObjekte());
    }

    /**
     * Malt alle GameObjects auf den Screen und am Ende auch den GameOverScreen
     * 
     * @author Gregor Scholz
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(running) {
            g.fillOval(xKugel, yKugel, 9, 9);  //  größe der kugel muss noch anders bestimmt werden
            g.fillRect(xPlatform, yPlatform, widthPlatform, heightPlatform);
            for(Fass f : Controller.getObjekte().getFaesser()) {
                g.fillRect(f.getX(), f.getY(), 1, 1);  // fässerbreite
            }
        } else {
            // zeige Game Over Screen, entweder verloren oder gewonnen
        }
    }

    /**
     * startet das Spielgeschehen
     * 
     * @author Gregor Scholz
     */
    public void startGame() {
        running = true;
        timer.start();
    }

    /**
     * aktualisiert die Posiion alle Objekte
     * 
     * @author Gregor Scholz
     */
    public void updateObjects() {
        widthPlatform = Controller.getObjekte().getPlattform().getPlattformBreite();
        heightPlatform = Controller.getObjekte().getPlattform().getPlattformGroesse();

        xKugel = Controller.getObjekte().getKugel().getxKoordinate();
        yKugel = Controller.getObjekte().getKugel().getyKoordinate();
    }

    /**
     * ActionListener Klasse für das Panel
     * 
     * @author Gregor Scholz
     */
    public class GameActionListener implements ActionListener {

        /**
         * bei jeden Tick aktuallisiert es alle Objekte und überprüft nach Collisions
         * 
         * @author Gregor Scholz
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(running) {
                updateObjects();
                cd.checkCollision();
            }
            repaint();
        }
        
    }

}
