package gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasse für das Hauptmenu
 * 
 * @author Gregor Scholz
 */
public class MainMenuPanel extends JPanel {

    private JLabel nameLabel;
    private ImageIcon icon;
    private Font pirate_font;

    public MainMenuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT));;
        this.setOpaque(false);
        loadRessources();
        setup();
    }

    /**
     * Erstellt das Overlay mit den Buttons und dem Label
     * 
     * @author Gregor Scholz
     */
    public void setup() {
        nameLabel = new JLabel("Trampolin-Piraten");
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        nameLabel.setFont(pirate_font.deriveFont(60f));    
        
        Box box = Box.createVerticalBox();
        box.setPreferredSize(new Dimension(1400, 1000));
        this.add(Box.createRigidArea(new Dimension(0, GamePanel.SCREEN_HEIGHT / 4)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        createButton("Levelauswahl");
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        createButton("Einstellungen");
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        createButton("Beenden");
    }

    /**
     * Erzeugt die Buttons zum wechseln der Panel
     * 
     * @param msg - der Name der Panel und welcher auf den Buttons steht
     * @author Gregor Scholz
     */
    public void createButton(String msg) {
        JButton button = new JButton(icon);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(250, 50));
        button.addActionListener(e -> switchPanel(msg));
        button.setLayout(new GridBagLayout());
        JLabel label = new JLabel(msg);
        label.setFont(pirate_font.deriveFont(24f));
        button.add(label);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        this.add(button);
    }

    /**
     * Wechselt bei Betätigigung eines der Buttons zu dem entsprechenden Panel
     * 
     * @param msg - der Name der Panel und welcher auf den Buttons steht
     * @author Gregor Scholz
     */
    public void switchPanel(String msg) {
        if(msg == "Beenden") {
            System.exit(0);
        } else {
            GamePanel.cl.show(WindowPanel.gp, msg);
        }
    }

    /**
     * Methode welche die benötigten Schriftarten und Bilder in das Programm lädt
     * 
     * @author Gregor Scholz
     */
    public void loadRessources() {
        icon = new ImageIcon("resources/buttons.png");
        try {
            pirate_font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/pirate_font.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pirate_font);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

}