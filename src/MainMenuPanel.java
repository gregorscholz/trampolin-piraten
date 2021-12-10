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

public class MainMenuPanel extends JPanel {

    private JLabel nameLabel, levelLabel, settingsLabel, exitLabel;
    private JButton levelButton, settingsButton, exitButton;
    private ImageIcon icon;
    private Font pirate_font_label, pirate_font_button;

    public MainMenuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT));;
        this.setOpaque(false);
        loadRessources();
        setup();
    }

    public void setup() {
        nameLabel = new JLabel("Trampolin-Piraten");
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        nameLabel.setFont(pirate_font_label);
        // TODO Hintergrund transparent oder eigene Textur

    

        levelButton = new JButton(icon);
        levelButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        levelButton.setMaximumSize(new Dimension(250, 50));
        levelButton.addActionListener(e -> GamePanel.switchToLevel());
        levelButton.setLayout(new GridBagLayout());
        levelLabel = new JLabel("Levelauswahl");
        levelLabel.setFont(pirate_font_button);
        levelButton.add(levelLabel);
        levelButton.setBorderPainted(false);
        levelButton.setContentAreaFilled(false);

        settingsButton = new JButton(icon);
        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        settingsButton.setMaximumSize(new Dimension(250, 50));
        settingsButton.addActionListener(e -> GamePanel.switchToSettings());
        settingsButton.setLayout(new GridBagLayout());
        settingsLabel = new JLabel("Einstellungen");
        settingsLabel.setFont(pirate_font_button);
        settingsButton.add(settingsLabel);
        settingsButton.setBorderPainted(false);
        settingsButton.setContentAreaFilled(false);

        exitButton = new JButton(icon);
        exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        exitButton.setMaximumSize(new Dimension(250, 50));
        exitButton.setLayout(new GridBagLayout());
        exitButton.addActionListener(e -> System.exit(0));
        exitLabel = new JLabel("Beenden");
        exitLabel.setFont(pirate_font_button);
        exitButton.add(exitLabel);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);

        Box box = Box.createVerticalBox();
        box.setPreferredSize(new Dimension(1400, 1000));
        this.add(Box.createRigidArea(new Dimension(0, GamePanel.SCREEN_HEIGHT / 4)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 200)));
        this.add(levelButton);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(settingsButton);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(exitButton);
    }

    public void loadRessources() {
        icon = new ImageIcon("resources/buttons.png");

        try {
            pirate_font_label = Font.createFont(Font.TRUETYPE_FONT, new File("resources/pirate_font.ttf")).deriveFont(60f);
            pirate_font_button = Font.createFont(Font.TRUETYPE_FONT, new File("resources/pirate_font.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pirate_font_label);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

}