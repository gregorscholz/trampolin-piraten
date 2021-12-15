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
 * Klasse welche zum Beginn des Programms alle benötigten Bilder etc. lädt
 * 
 * @author Gregor Scholz
 */
public class ResourceLoader {

    private static Font pirateFont;
    private static Icon bigIcon, backIcon, levelIcon;
    private static BufferedImage background;

    public ResourceLoader() {
        loadFont();
        loadButtonIcons();
        loadBackground();
    }
    
    /**
     * Methode welche die benötigte Schriftart in das Programm lädt
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
     * Gibt die Schriftart in dem entsprechenden Format zurück
     * 
     * @author Gregor Scholz
     * @return die geladene Schriftart im entsprechenden Format
     */
    public static Font getFont(float style) {
        return pirateFont.deriveFont(style);
    }

    /**
     * Lädt die Icons für die Buttons 
     * 
     * @author Gregor Scholz
     */
    public void loadButtonIcons() {
        bigIcon = new ImageIcon("resources/button_groß.png");
        backIcon = new ImageIcon("resources/button_zurück.png");
        levelIcon = new ImageIcon("resources/button_level.png");
    }

    /**
     * Gibt das Icon für die großen Buttons zurück
     * 
     * @author Gregor Scholz
     * @return großes Icon der Buttons
     */
    public static Icon getBigIcon() {
        return bigIcon;
    }

    /**
     * Gibt das Icon für die Zurückbuttons zurück
     * 
     * @author Gregor Scholz
     * @return Icon für die Züruckbuttons
     */
    public static Icon getBackIcon() {
        return backIcon;
    }

    /**
     * Gibt das Icon für die Level zurück
     * 
     * @author Gregor Scholz
     * @return Icon für die Level
     */
    public static Icon getLevelIcon() {
        return levelIcon;
    }

    /**
     * Lädt das Hintergrundbild
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
     * Gibt das Hintergrundbild zurück
     * 
     * @author Gregor Scholz
     * @return das Hintergrundbild
     */
    public static BufferedImage getBackground() {
        return background;
    }
}
