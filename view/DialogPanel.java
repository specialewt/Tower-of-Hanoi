package view;

import model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogPanel extends JPanel {
    private boolean bestScore;
    private JPanel container;
    private JDialog dialog;
    private String name;
    private JButton ok;
    private JButton menu;
    private JButton playAgain;
    private JButton nextLevel;

    public DialogPanel(JFrame mainFrame, Level level, boolean bestScore) {
        this.bestScore = bestScore;
        container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));

        JLabel end;
        JPanel highScore = null;
        if (bestScore == true) {
            end = new JLabel("You got the best score!");

            highScore = new JPanel();
            JTextField nameField = new JTextField(10);
            highScore.add(new JLabel("Enter name: "));
            highScore.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            highScore.add(nameField);

            ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = nameField.getText();
                    System.out.println(name);
                    ok.setEnabled(false);
                    nameField.setEnabled(false);
                }
            });
            highScore.add(ok);
            highScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        } else {
            end = new JLabel("You've completed this level!");
            // print best score saved?
        }
        end.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        end.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel score = new JLabel("Score: "+ level.getMoveCounter());
        score.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        score.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel options = new JPanel();
        playAgain = new JButton("Play Again");
        nextLevel = new JButton("Next Level");
        menu = new JButton("Menu");
        options.add(playAgain);
        options.add(nextLevel);
        options.add(menu);
        options.setAlignmentX(Component.CENTER_ALIGNMENT);

        container.add(end);
        container.add(score);
        container.add(highScore);
        container.add(options);

        dialog = new JDialog(mainFrame, "LEVEL COMPLETE");
        dialog.add(container);
        dialog.setSize(400,150);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void showDialog() {
        dialog.setVisible(true);
    }

    public void closeDialog() {
        dialog.dispose();
    }

    public String getName() {
        return this.name;
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
