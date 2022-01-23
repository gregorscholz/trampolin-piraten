package gui;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import spielelemente.CollisionDetection;
import spielelemente.Fass;
import spielelemente.Kugel;
import zentral.Controller;

/**
 * Klasse fuer das Anzeigen des eigentlichen Spiels
 * 
 * @author Gregor Scholz
 */
public class InGamePanel extends JPanel {
	private KeyListener listener = Controller.getSteuerung();

    static final int tick = 0;
    private Timer timer;
    private boolean running;
    private boolean kugelStart = false;
    private boolean ausgang = false; //default verloren

    private CollisionDetection cd;

    public InGamePanel() {
        Dimension dim = new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
    }

    /**
     * Malt alle GameObjects auf den Screen und am Ende auch den GameOverScreen
     * 
     * @author Gregor Scholz
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ResourceLoader.getHimmel(), 0, 0, null);
        if(running) {
            g.drawImage(ResourceLoader.getWellen(), 0, Controller.getObjekte().getPlattform().getWellenstand(), null);
            g.drawImage(ResourceLoader.getSchiff(), (int) Controller.getObjekte().getPlattform().getX(), (int) Controller.getObjekte().getPlattform().getY(), null);
            for(Fass f : Controller.getObjekte().getFaesser()) {
                switch (f.getEvent()) {
                    case 0:
                    g.drawImage(ResourceLoader.getFass(), (int) f.getX(),(int) f.getY(), null);
                    break;
                    case 1:
                    g.drawImage(ResourceLoader.getFassExplosion(), (int) f.getX(),(int) f.getY(), null);
                    break;
                    case 2:
                    g.drawImage(ResourceLoader.getFassMunition(), (int) f.getX(),(int) f.getY(), null);
                    break;
                    case 3:
                    g.drawImage(ResourceLoader.getFassRum(), (int) f.getX(),(int) f.getY(), null);
                    break;
                    case 4:
                    g.drawImage(ResourceLoader.getWellenstandErhoehen(), (int) f.getX(),(int) f.getY(), null);
                    break;
                    case 5:
                    g.drawImage(ResourceLoader.getWellenstandVerringern(), (int) f.getX(),(int) f.getY(), null);
                    break;
                }
                g.setFont(ResourceLoader.getFont(24f));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString(String.valueOf(f.getLeben()), (int) ((f.getX() + (f.getWidth() / 2)) - (metrics.stringWidth(String.valueOf(f.getLeben())) / 2)), (int) ((f.getY() + (f.getHeight() / 2)) + (g.getFont().getSize() / 2)));
            }
            for(Kugel k : Controller.getObjekte().getKugeln()) {
                if (k.getIstAktiv() == 0) {
                    g.drawImage(ResourceLoader.getKugel(), (int) k.getX(), (int) k.getY(), null);
                }
            }
        } else {
            g.setFont(ResourceLoader.getFont(48f));
            FontMetrics metrics = getFontMetrics(g.getFont());
            if(!ausgang) {
            	g.drawString("Game Over!", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Game Over!")) / 2, (GamePanel.SCREEN_HEIGHT - g.getFont().getSize()) / 2);
            } else {
            	g.drawString("Gewonnen!", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Gewonnen!")) / 2, (GamePanel.SCREEN_HEIGHT - g.getFont().getSize()) / 2);

            }
        }
    }

    /**
     * startet das Spielgeschehen
     * 
     * @author Gregor Scholz
     */
    public void startGame() {
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(listener);
        cd = new CollisionDetection();
        running = true;
        timer = new Timer(tick, new GameActionListener());
        timer.restart();									
    }
    
    /**
     * Beendet das aktive Spiel
     * 
     * @author Ines Rohrbach
     */
    public void beendet(boolean b) {
    	ausgang = b;
    	running = false;
    	kugelStart = false;
    	this.removeKeyListener(listener);
    	timer.stop();
    }
    
    /**
     * Startet nach dem Space-Taste druecken die Bewegung der Kugel.
     * 
     * @param b, true = kugel bewegt sich
     * @author Ines Rohrbach
     */
    public void setKugelStart(boolean b) {
    	kugelStart = b;
    }

    /**
     * ActionListener Klasse fuer das Panel
     * 
     * @author Gregor Scholz
     */
    public class GameActionListener implements ActionListener {

        /**
         * bei jeden Tick aktuallisiert es alle Objekte und ueberprueft nach Collisions
         * 
         * @author Gregor Scholz
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(kugelStart) {
        		for(Kugel k: Controller.getObjekte().getKugeln()) {
        			if(k.getIstAktiv()==0) {
        				k.move();
        			}
        		}
        	}
            if(running) {
                cd.checkCollision();
            }
            repaint();
        }
        
    }

}
