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

public class LevelChoosingPanel extends JPanel {

    private ArrayList<JPanel> rowspanel;
    private ArrayList<FlowLayout> rowslayout;
    private JLabel levels, einfach, mittel, schwer;
    private JButton zurueck;
    private ImageIcon levelicon;
    private Font pirate_font;

    public LevelChoosingPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setOpaque(false);
        loadFont();
        loadPanels();        
        for (int i = 0; i < rowspanel.size(); i++) {
            this.add(rowspanel.get(i));
        }
    }

    public void loadPanels() {
        rowspanel = new ArrayList<JPanel>();
        rowslayout = new ArrayList<FlowLayout>();
        levelicon = new ImageIcon("resources/level_knopf.png");
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

        createLevelButtons();

        levels = new JLabel("Levels");
        levels.setFont(pirate_font);
        rowspanel.get(0).add(levels); 
        
        einfach = new JLabel("Anfaenger");
        einfach.setFont(pirate_font);
        rowspanel.get(1).add(einfach);

        mittel = new JLabel("Fortgeschritten");
        mittel.setFont(pirate_font);
        rowspanel.get(3).add(mittel);

        schwer = new JLabel("Schwer");
        schwer.setFont(pirate_font);
        rowspanel.get(5).add(schwer);

        zurueck = new JButton("Zurueck");
        zurueck.setPreferredSize(new Dimension(100, 50));
        zurueck.addActionListener(e -> GamePanel.switchToMain());
        rowspanel.get(7).add(Box.createRigidArea(new Dimension(1400, 60)));
        rowspanel.get(7).add(zurueck);
    }

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

    public void loadFont() {
        try {
            pirate_font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/pirate_font.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pirate_font);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

}
