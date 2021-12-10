import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WindowPanel extends JPanel {

    static GamePanel gp;
    private BufferedImage bi;

    public WindowPanel() {
        gp = new GamePanel();
        getBackgroundImage();
        this.add(gp);
    }

    public void getBackgroundImage() {
        try {
            // TODO besseres Randbild raussuchen
            bi = ImageIO.read(new File("resources/1434.png"));
        } catch (IOException e) {
            // TODO exception handeling
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);           
        g.drawImage(bi, 0, 0, null);
    }
    
}
