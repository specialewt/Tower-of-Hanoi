import view.HomePanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LevelScreenPrototype {
    private JFrame mainFrame;
    private int frameHeight;
    private int frameWidth;
    private JPanel titlePanel;

    public LevelScreenPrototype(int frameSize, int level) {
        this.mainFrame = new JFrame("Tower of Hanoi: Level "+level);

        this.frameHeight = 5/3*frameSize;
        this.frameWidth = frameSize;
        this.mainFrame.setPreferredSize(new Dimension(this.frameWidth, this.frameHeight));

        // default close operation
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // level title panel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setPreferredSize(new Dimension(frameWidth,frameHeight / 4));
        titlePanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("LEVEL "+level);
        titleLabel.setForeground((Color.BLACK));
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 24));

        titlePanel.add(titleLabel, new GridBagConstraints());

        // adding panels
        this.mainFrame.add(new ControlPanel(this.frameWidth, this.frameHeight), BorderLayout.SOUTH);
        this.mainFrame.add(titlePanel, BorderLayout.NORTH);
        this.mainFrame.add(new GamePanel(this.frameWidth), BorderLayout.CENTER);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JFrame getFrame()
    {
        return this.mainFrame;
    }
}
