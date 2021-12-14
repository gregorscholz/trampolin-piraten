package gui;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Klasse für das JPanel welches den kompletten Bildschirm abdeckt
 * 
 * @author Gregor Scholz
 */
public class WindowPanel extends JPanel {

    static GamePanel gp;

    public WindowPanel() {
        gp = new GamePanel();
        this.add(gp);
    }

    /**
     * Zeichnet das Hintergrundbild auf das Panel
     * 
     * @author Gregor Scholz
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);           
        g.drawImage(ResourceLoader.getBackground(), 0, 0, null);
    }
    
}
