package gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

    public LevelChoosingPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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
        zurueck.setIcon(ResourceLoader.getBackIcon());
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
        label.setFont(ResourceLoader.getFont(30f));
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
                button.setIcon(ResourceLoader.getLevelIcon());
                JLabel label = new JLabel(String.valueOf(column));
                label.setFont(ResourceLoader.getFont(30f));
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

}
