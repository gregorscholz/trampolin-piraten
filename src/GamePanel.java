import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

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
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setLayout(cl);

        this.add(mainmenupanel, "Main Menu");
        this.add(settingspanel, "Settings");
        this.add(levelpanel, "Level");
        this.add(ingamepanel, "In Game");

        this.setVisible(true);
        this.setFocusable(true);
    }

    public void setup() {
        cl = new CardLayout();
        mainmenupanel = new MainMenuPanel();
        settingspanel = new SettingsPanel();
        levelpanel = new LevelChoosingPanel();
        ingamepanel = new InGamePanel();
    }

    public static void switchToMain() {
        cl.show(WindowPanel.gp, "Main Menu");
    }

    public static void switchToSettings() {
        cl.show(WindowPanel.gp, "Settings");
    }

    public static void switchToLevel() {
        cl.show(WindowPanel.gp, "Level");
    }

    public static void switchToInGame() {
        cl.show(WindowPanel.gp, "In Game");
    }
    
}
