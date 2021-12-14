package gui;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Klasse für das eigentliche Spielfenster mit den festgelegten Größen
 * 
 * @author Gregor Scholz
 */
public class GamePanel extends JPanel {

    static final int SCREEN_HEIGHT = 1000;
    static final int SCREEN_WIDTH = 1400;

    static MainMenuPanel  mainmenupanel;
    static SettingsPanel settingspanel;
    static InGamePanel ingamepanel;
    static LevelChoosingPanel levelpanel;

    static CardLayout cl;

    public GamePanel() {
        setup();
        this.setOpaque(false);
        Dimension dim = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.setLayout(cl);

        this.add(mainmenupanel, "Main Menu");
        this.add(settingspanel, "Einstellungen");
        this.add(levelpanel, "Levelauswahl");
        this.add(ingamepanel, "In Game");

        this.setVisible(true);
        this.setFocusable(true);
    }

    /**
     * Intitialisiert die einzelenen Panels und das Layout
     * 
     * @author Gregor Scholz
     */
    public void setup() {
        cl = new CardLayout();
        mainmenupanel = new MainMenuPanel();
        settingspanel = new SettingsPanel();
        levelpanel = new LevelChoosingPanel();
        ingamepanel = new InGamePanel();
    }
    
}
