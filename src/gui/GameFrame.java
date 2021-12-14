package gui;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Klasse zur Erstellung des Fensters
 * 
 * @author Gregor Scholz
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        this.add(new WindowPanel());
        this.setTitle("Trampolin-Piraten");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT));
        this.setResizable(true);
        this.pack();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

}
