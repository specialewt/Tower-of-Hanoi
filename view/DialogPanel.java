package view;

import model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogPanel extends JPanel {
    private JFrame mainFrame;
    private JPanel container;
    private JDialog dialog;

    private String name;
    private JButton menu;
    private JButton playAgain;
    private JButton nextLevel;
    private volatile boolean enteredName = false;

    public DialogPanel(JFrame mainFrame, int levelNum, int moves) {
        this.mainFrame = mainFrame;

        container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));

        // level complete message
        JLabel end = new JLabel("You've completed level " + levelNum + "!");
        end.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        end.setAlignmentX(Component.CENTER_ALIGNMENT);

        // show final score of level
        JLabel score = new JLabel("Score: "+ moves);
        score.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        score.setAlignmentX(Component.CENTER_ALIGNMENT);

        // text field to enter name to save score
        JPanel saveScore = new JPanel();
        JTextField nameField = new JTextField("Name",10);
        saveScore.add(new JLabel("Enter name: "));
        saveScore.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        saveScore.add(nameField);

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            // saves name and then allows more option choices
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                ok.setEnabled(false);
                nameField.setEnabled(false);

                playAgain.setEnabled(true);
                if (levelNum < 5) {
                    nextLevel.setEnabled(true);
                }
                menu.setEnabled(true);

                enteredName = true;
            }
        });
        saveScore.add(ok);
        saveScore.setAlignmentX(Component.CENTER_ALIGNMENT);

        // more options
        JPanel options = new JPanel();
        playAgain = new JButton("Play Again");
        playAgain.setEnabled(false);
        nextLevel = new JButton("Next Level");
        nextLevel.setEnabled(false);
        menu = new JButton("Menu");
        menu.setEnabled(false);
        options.add(playAgain);
        options.add(nextLevel);
        options.add(menu);
        options.setAlignmentX(Component.CENTER_ALIGNMENT);

        container.add(end);
        container.add(score);
        container.add(saveScore);
        container.add(options);
    }

    public void showDialog() {
        dialog = new JDialog(mainFrame, "LEVEL COMPLETE");

        dialog.add(container);
        dialog.setSize(400,150);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);
    }

    public void closeDialog() {
        this.enteredName = false;
        dialog.dispose();
    }

    public String getName() {
        return this.name;
    }

    public boolean getEnteredName() {
        return this.enteredName;
    }

    public JButton getMenuInDialog() {
        return this.menu;
    }

    public JButton getPlayAgain() {
        return this.playAgain;
    }

    public JButton getNextLevel() {
        return this.nextLevel;
    }
}
