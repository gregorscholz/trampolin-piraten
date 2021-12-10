import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class InGamePanel extends JPanel {

    static final int tick = 0;
    
    private int level, difficulty;

    Timer timer;
    boolean running;

    public InGamePanel() {
        setup();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    }

    public void setup() {
        this.addKeyListener(new GameKeyListener());
        timer = new Timer(tick, new GameActionListener());
    }

    public void startGame() {
        running = true;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public class GameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO action
            if(running) {
                /**
                 * checkBallCollisions();
                 * updatePlatform();
                 */
                repaint();
            }  
        }

    }

    public class GameKeyListener implements KeyListener {

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

    }
}
