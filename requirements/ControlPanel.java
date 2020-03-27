import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private JLabel moves;
    private int moveCount;
    private JPanel movePanel;
    private Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

    public ControlPanel(int frameWidth, int frameHeight) {
        this.setPreferredSize(new Dimension(frameWidth, frameHeight/6));
        this.setLayout(new GridLayout(1, 4));

        movePanel = new JPanel();
        movePanel.setLayout(new GridBagLayout());

        moveCount = 0;
        moves = new JLabel("Moves: "+moveCount);
        moves.setFont(font);
        movePanel.add(moves, new GridBagConstraints());

        JButton menu = new JButton("Menu");
        menu.setFont(font);
        JButton reset = new JButton("Reset");
        reset.setFont(font);
        JButton change = new JButton("Change Level");
        change.setFont(font);

        this.add(menu);
        this.add(reset);
        this.add(change);
        this.add(movePanel);

    }
}
