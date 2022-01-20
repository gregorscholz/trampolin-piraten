package gui;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.Timer;

import spielelemente.CollisionDetection;
import spielelemente.Fass;
import spielelemente.Kugel;
import zentral.Controller;

/**
 * Klasse für das Anzeigen des eigentlichen Spiels
 * 
 * @author Gregor Scholz
 */
public class InGamePanel extends JPanel {

    static final int tick = 0;
    private Timer timer;
    private boolean running;

    private CollisionDetection cd;

    public InGamePanel() {
        Dimension dim = new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.addKeyListener(Controller.getSteuerung());
        startGame();
        //cd = new CollisionDetection(Controller.getObjekte());
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
            g.fillRect( Controller.getObjekte().getPlattform().getxKoordinate(), Controller.getObjekte().getPlattform().getyKoordinate(), 
                        Controller.getObjekte().getPlattform().getPlattformBreite(), Controller.getObjekte().getPlattform().getPlattformHoehe());
            for(Fass f : Controller.getObjekte().getFaesser()) {
                g.fillRect( (int) f.getX(), (int) f.getY(), (int) f.getWidth(), (int) f.getHeight());
            }
            for(Kugel k : Controller.getObjekte().getKugeln()) {
                g.fillOval(k.getxKoordinate(), k.getyKoordinate(), (int) k.getWidth(), (int) k.getHeight());
            }
        } else {
            g.fillRect(10, 10, 100, 100);
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
        timer = new Timer(tick, new GameActionListener());
        timer.start();
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
                //cd.checkCollision();
            }
            repaint();
        }
        
    }

}
