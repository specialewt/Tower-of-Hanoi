package view;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private JLabel moves;
    private int moveCount;
    private JPanel movePanel;
    private Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

    private JButton menu;
    private JButton reset;
//    private JButton change;

    public ControlPanel(int frameWidth, int frameHeight) {
        this.setPreferredSize(new Dimension(frameWidth, frameHeight/6));
        this.setLayout(new GridLayout(1, 3));

        movePanel = new JPanel();
        movePanel.setLayout(new GridBagLayout());

        moveCount = 0;
        moves = new JLabel("Moves: "+moveCount);
        moves.setFont(font);
        movePanel.add(moves, new GridBagConstraints());

        this.menu = new JButton("Menu");
        this.menu.setFont(font);
        this.reset = new JButton("Reset");
        this.reset.setFont(font);
//        this.change = new JButton("Change Level");
//        this.change.setFont(font);

        this.add(this.menu);
        this.add(this.reset);
//        this.add(this.change);
        this.add(this.movePanel);

    }

    public JButton getMenu() {
        return this.menu;
    }

    public JButton getReset() {
        return this.reset;
    }

//    public JButton getChange() {
//        return this.change;
//    }

    public JLabel getMoves() {
        return this.moves;
    }
}
