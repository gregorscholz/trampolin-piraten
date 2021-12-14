package gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasse für das Menu zur Levelauswahl
 * 
 * @author Gregor Scholz
 */
public class LevelChoosingPanel extends JPanel {

    private ArrayList<JPanel> rowspanel;
    private ArrayList<FlowLayout> rowslayout;
    private JButton zurueck;
    private ImageIcon levelicon, zurueckicon;
    private Font pirate_font;

    public LevelChoosingPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        loadFont();
        loadPanels();        
        for (int i = 0; i < rowspanel.size(); i++) {
            this.add(rowspanel.get(i));
        }
    }

    /**
     * Erstellt die einzelnen Reihen und fügt die Komponenten hinzu
     * 
     * @author Gregor Scholz
     */
    public void loadPanels() {
        rowspanel = new ArrayList<JPanel>();
        rowslayout = new ArrayList<FlowLayout>();
        levelicon = new ImageIcon("resources/level_knopf.png");
        zurueckicon = new ImageIcon("resources/zurueck_knopf.png");
        for (int i = 0; i < 8; i++) {
            rowspanel.add(new JPanel());
            rowslayout.add(new FlowLayout());
            if (i == 0) {
                rowslayout.get(i).setAlignment(FlowLayout.CENTER);
            } else {
                rowslayout.get(i).setAlignment(FlowLayout.LEFT);
            }
            rowspanel.get(i).setLayout(rowslayout.get(i));
            rowspanel.get(i).setMinimumSize(new Dimension(1400, 125));
            rowspanel.get(i).setPreferredSize(new Dimension(1400, 125));
            rowspanel.get(i).setMaximumSize(new Dimension(1400, 125));
        }

        createLevelLabel("Levels", 0);
        createLevelLabel("Anfaenger", 1);
        createLevelLabel("Fortgeschritten", 3);
        createLevelLabel("Schwer", 5);
        createLevelButtons();

        zurueck = new JButton();
        zurueck.setLayout(new GridBagLayout());
        zurueck.setIcon(zurueckicon);
        zurueck.setBorderPainted(false);
        zurueck.setContentAreaFilled(false);
        zurueck.setPreferredSize(new Dimension(70, 50));
        zurueck.addActionListener(e -> GamePanel.cl.show(WindowPanel.gp, "Main Menu"));
        rowspanel.get(7).add(Box.createRigidArea(new Dimension(1400, 60)));
        rowspanel.get(7).add(zurueck);
    }

    /**
     * Erstellt die einzelnen Label für die Schwierigkeiten für die Level
     * 
     * @param schwierigkeit - der Name des Labels, also die Schwierigkeit
     * @param row - die Reihe in welchen die Label hinzugefügt werden
     * @author Gregor Scholz
     */
    public void createLevelLabel(String schwierigkeit, int row) {
        JLabel label = new JLabel(schwierigkeit);
        label.setFont(pirate_font.deriveFont(30f));
        rowspanel.get(row).add(label);
    }

    /**
     * Erstellt die einzelnen Knöpfe für die Level
     * 
     * @author Gregor Scholz
     */
    public void createLevelButtons() {
        for(int row = 2; row <= 6; row += 2) {
            for(int column = 1; column <= 5; column++) {
                JButton button = new JButton();
                button.setLayout(new GridBagLayout());
                button.setIcon(levelicon);
                JLabel label = new JLabel(String.valueOf(column));
                label.setFont(pirate_font);
                button.add(label);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setPreferredSize(new Dimension(150, 100));
                // button.addActionListener
                rowspanel.get(row).add(Box.createRigidArea(new Dimension(100, 0)));
                rowspanel.get(row).add(button);
            }
        }
    }

    /**
     * lädt die Schriftarten in das Programm
     * 
     * @author Gregor Scholz
     */
    public void loadFont() {
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
