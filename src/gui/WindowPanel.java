package gui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Klasse für das JPanel welches den kompletten Bildschirm abdeckt
 * 
 * @author Gregor Scholz
 */
public class WindowPanel extends JPanel {

    static GamePanel gp;
    private BufferedImage bi;

    public WindowPanel() {
        gp = new GamePanel();
        getBackgroundImage();
        this.add(gp);
    }

    /**
     * lädt das Hintergrundbild in das Programm
     * 
     * @author Gregor Scholz
     */
    public void getBackgroundImage() {
        try {
            bi = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * zeichnet das Hintergrundbild auf das Panel
     * 
     * @author Gregor Scholz
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);           
        g.drawImage(bi, 0, 0, null);
    }
    
}
