package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Klasse für das Einstellungsmenu
 * 
 * @author Gregor Scholz
 */
public class SettingsPanel extends JPanel {

    private JLabel nameLabel;
    private JPanel buttonPanel, backPanel;
    
    public SettingsPanel() {
        Dimension dim = new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.setOpaque(false);

        setup();

        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(GamePanel.SCREEN_WIDTH, 0)));
        this.add(buttonPanel);
        this.add(backPanel);
    }

    /**
     * Erstellt das die Label und die Buttons
     * 
     * @see createButton() 
     * @author Gregor Scholz
     */
    public void setup() {
        nameLabel = new JLabel("Einstellungen", JLabel.CENTER);
        nameLabel.setFont(ResourceLoader.getFont(30f));   
        nameLabel.setForeground(Color.white);
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridBagLayout());
        createButton("A und D", buttonPanel, 1);
        buttonPanel.add(Box.createRigidArea(new Dimension(50, 50)));
        createButton("Pfeiltasten", buttonPanel, 2);     

        JButton zurueck = new JButton();
        zurueck.setLayout(new GridBagLayout());
        zurueck.setIcon(ResourceLoader.getBackIcon());
        zurueck.setBorderPainted(false);
        zurueck.setContentAreaFilled(false);
        zurueck.setPreferredSize(new Dimension(70, 50));
        zurueck.addActionListener(e -> GamePanel.cl.show(WindowPanel.gp, "Main Menu"));
        backPanel = new JPanel();
        backPanel.setOpaque(false);
        backPanel.setLayout(new FlowLayout());
        backPanel.setAlignmentX(CENTER_ALIGNMENT);
        backPanel.add(zurueck);
    }

    /**
     * Erstellt die Buttons für den Steuerungsänderung
     * 
     * @param setname - der Text welcher auf den Button steht
     * @param panel - das JPanel zu dem der Panel hinzugefügt wird
     * @param setnr - die Nummer zu dem Set
     */
    public void createButton(String setname, JPanel panel, int setnr) {
        JButton button = new JButton(ResourceLoader.getBigIcon());
        button.setPreferredSize(new Dimension(250, 50));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setLayout(new GridBagLayout());
        button.addActionListener(e -> getButton(setname, setnr));
        JLabel label = new JLabel(setname);
        label.setFont(ResourceLoader.getFont(24f));
        button.add(label);
        panel.add(button);
    }

    /**
     * Der ActionListener zu den Buttons, führt die entsprechende Funktion aus, bei Betätigung eines Buttons kommt eine Popup Meldung zur Änderung
     * 
     * @param setname - der Text welcher auf dem Button steht und das Set beschreibt
     * @param setnr - die Nummer zu dem Set
     */
    public void getButton(String setname, int setnr) {
        switch (setnr) {
            case 1:
                // TODO
                break;
            case 2:
                // TODO
                break;
        }
        JOptionPane.showMessageDialog(this, "Steuerung wurde auf " + setname + " geändert.");
    }

}
