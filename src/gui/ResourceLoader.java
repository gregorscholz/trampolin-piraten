package gui;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Klasse welche zum Beginn des Programms alle benoetigten Bilder etc. laedt
 * 
 * @author Gregor Scholz
 */
public class ResourceLoader {

    private static Font pirateFont;
    private static Icon bigIcon, backIcon, levelIcon;
    private static BufferedImage background, fass_explosion, fass_rum, fass_wellenstand_erhoehen, fass_wellenstand_verringern, fass_munition, fass, kugel, wellen, himmel;

    public ResourceLoader() {
        loadFont();
        loadButtonIcons();
        loadBackground();
        loadFaesser();
        loadKugel();
        loadWellen();
        loadHimmel();
    }
    
    /**
     * Methode welche die benoetigte Schriftart in das Programm laedt
     * 
     * @author Gregor Scholz
     */
    public void loadFont() {
        try {
            pirateFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/pirate_font.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pirateFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt die Schriftart in dem entsprechenden Format zurueck
     * 
     * @author Gregor Scholz
     * @return die geladene Schriftart im entsprechenden Format
     */
    public static Font getFont(float style) {
        return pirateFont.deriveFont(style);
    }

    /**
     * Laedt die Icons fuer die Buttons 
     * 
     * @author Gregor Scholz
     */
    public void loadButtonIcons() {
        bigIcon = new ImageIcon("resources/button_gross.png");
        backIcon = new ImageIcon("resources/button_zurueck.png");
        levelIcon = new ImageIcon("resources/button_level.png");
    }

    /**
     * Gibt das Icon fuer die großen Buttons zurueck
     * 
     * @author Gregor Scholz
     * @return großes Icon der Buttons
     */
    public static Icon getBigIcon() {
        return bigIcon;
    }

    /**
     * Gibt das Icon fuer die Zurueckbuttons zurueck
     * 
     * @author Gregor Scholz
     * @return Icon fuer die Zueruckbuttons
     */
    public static Icon getBackIcon() {
        return backIcon;
    }

    /**
     * Gibt das Icon fuer die Level zurueck
     * 
     * @author Gregor Scholz
     * @return Icon fuer die Level
     */
    public static Icon getLevelIcon() {
        return levelIcon;
    }

    /**
     * Laedt das Hintergrundbild
     * 
     * @author Gregor Scholz
     */
    public void loadBackground() {
        try {
            background = ImageIO.read(new File("resources/wooden-background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt das Hintergrundbild zurueck
     * 
     * @author Gregor Scholz
     * @return das Hintergrundbild
     */
    public static BufferedImage getBackground() {
        return background;
    }

    public void loadFaesser() {
        try {
            fass_explosion = ImageIO.read(new File("resources/fass_explosion.png"));
            fass_rum = ImageIO.read(new File("resources/fass_rum.png"));
            fass_wellenstand_erhoehen = ImageIO.read(new File("resources/fass_wellenstand_erhoehen.png"));
            fass_wellenstand_verringern = ImageIO.read(new File("resources/fass_wellenstand_verringern.png"));
            fass_munition = ImageIO.read(new File("resources/fass_munition.png"));
            fass = ImageIO.read(new File("resources/fass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getFassExplosion() {
        return fass_explosion;
    }

    public static BufferedImage getFassRum() {
        return fass_rum;
    }

    public static BufferedImage getWellenstandErhoehen() {
        return fass_wellenstand_erhoehen;
    }

    public static BufferedImage getWellenstandVerringern() {
        return fass_wellenstand_verringern;
    }

    public static BufferedImage getFassMunition() {
        return fass_munition;
    }

    public static BufferedImage getFass() {
        return fass;
    }

    public void loadKugel() {
        try {
            kugel = ImageIO.read(new File("resources/kugel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getKugel() {
        return kugel;
    }
    
    public void loadWellen() {
        try {
            wellen = ImageIO.read(new File("resources/wellen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getWellen() {
        return wellen;
    }

    public void loadHimmel() {
        try {
            himmel = ImageIO.read(new File("resources/himmel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getHimmel()  {
        return himmel;
    }

}
