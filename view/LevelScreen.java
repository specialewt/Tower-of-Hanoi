package view;

import controller.GameFrameInterface;
import model.*;
import controller.LevelScreenInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelScreen extends JPanel implements LevelScreenInterface {
    private JFrame mainFrame;
    private Level level;
//    private int frameSize = 800;

    private int frameHeight;
    private int frameWidth;
    private JPanel levelPanel;
    private JPanel titlePanel;
    private GamePanel game;
    private ControlPanel controls;
    private DialogPanel complete;
    private volatile boolean endChoice;

    public LevelScreen(GameFrameInterface mainFrame, Level level) {
        this.level = level;
        this.mainFrame = mainFrame.getFrame();
        this.frameHeight = mainFrame.getFrameHeight();
        this.frameWidth = mainFrame.getFrameWidth();
    }

    public void createLevel() {
//        this.mainFrame = new JFrame("Tower of Hanoi: Level "+level.getLevel());
//
//        this.frameHeight = 4/3*frameSize;
//        this.frameWidth = frameSize;
//        this.mainFrame.setPreferredSize(new Dimension(this.frameWidth, this.frameHeight));
//
//        // default close operation
//        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        levelPanel = new JPanel();
        levelPanel.setBackground(Color.WHITE);
        levelPanel.setPreferredSize(new Dimension(this.frameWidth, this.frameHeight));
        levelPanel.setLayout(new BorderLayout());

        // title panel with level number
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.WHITE);
        titlePanel.setPreferredSize(new Dimension(frameWidth,frameHeight / 4));
        titlePanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("LEVEL "+level.getLevel());
        titleLabel.setForeground((Color.BLACK));
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 24));

        titlePanel.add(titleLabel, new GridBagConstraints());

        // bottom control panel with buttons
        controls = new ControlPanel(this.frameWidth, this.frameHeight);

        // game panel where user plays
        game = new GamePanel(this.frameWidth, this.frameHeight);
        this.buildGame(this.level);     // builds initial game state

        // adding sub-panels to level panel
        this.levelPanel.add(controls, BorderLayout.SOUTH);
        this.levelPanel.add(titlePanel, BorderLayout.NORTH);
        this.levelPanel.add(game, BorderLayout.CENTER);

        // adding level panel to main frame
//        this.mainFrame.add(levelPanel);
//
//        mainFrame.pack();
//        mainFrame.setVisible(true);
    }

    public JPanel getLevelPanel() {
        return this.levelPanel;
    }
//
//    public void removeLevelScreen() {
//        this.mainFrame.remove(levelPanel);
//    }

    public void setOnMenu(ActionListener l) {
        controls.getMenu().addActionListener(l);
    }

    public void setOnReset(ActionListener l) {
        controls.getReset().addActionListener(l);
    }

//    public void setOnLevel(ActionListener l) {
//        controls.getChange().addActionListener(l);
//    }

    public void disableMenu() {
        controls.getMenu().setEnabled(false);
    }

    public void disableReset() {
        controls.getReset().setEnabled(false);
    }

    public void enableMenu() {
        controls.getMenu().setEnabled(true);
    }

    public void enableReset() {
        controls.getReset().setEnabled(true);
    }

    public void setOnLeft(ActionListener l) {
        game.getLeftPost().setPostButton(l);
    }

    public void setOnMid(ActionListener l) {
        game.getMiddlePost().setPostButton(l);
    }

    public void setOnRight(ActionListener l) {
        game.getRightPost().setPostButton(l);
    }

    public void removeOnLeft(ActionListener l) {
        game.getLeftPost().removeListener(l);
    }

    public void removeOnMid(ActionListener l) {
        game.getMiddlePost().removeListener(l);
    }

    public void removeOnRight(ActionListener l) {
        game.getRightPost().removeListener(l);
    }

    public void buildGame(Level level) {
        this.game.removeRingsAllPosts();

        Post left = level.getPost(0);
        for (Ring r : left.getRings()) {
            game.getLeftPost().addRing(r);
        }

        Post mid = level.getPost(1);
        for (Ring r : mid.getRings()) {
            game.getMiddlePost().addRing(r);
        }

        Post right = level.getPost(2);
        for (Ring r : right.getRings()) {
            game.getRightPost().addRing(r);
        }

        this.game.revalidate();
        this.game.repaint();
    }

    public void updateMoves(int newMoveCount) {
        this.controls.getMoves().setText("Moves: " + newMoveCount);
    }

    public void moveRingIcon(int sendPost, int receivePost) {
        RingIcon movingIcon = null;

        if (sendPost == 0) {
            movingIcon = this.game.getLeftPost().removeTopRing();
        } else if (sendPost == 1) {
            movingIcon = this.game.getMiddlePost().removeTopRing();
        } else if (sendPost == 2) {
            movingIcon = this.game.getRightPost().removeTopRing();
        }

        if (receivePost == 0) {
            this.game.getLeftPost().addRing(movingIcon.getRing());
        } else if (receivePost == 1) {
            this.game.getMiddlePost().addRing(movingIcon.getRing());
        } else if (receivePost == 2) {
            this.game.getRightPost().addRing(movingIcon.getRing());
        }
    }

    public void levelComplete() {
        //need to pass boolean for best score
        complete = new DialogPanel(this.mainFrame, this.level, true);

        this.endChoice = false;
        ActionListener dialogListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                complete.closeDialog();
                endChoice = true;
            }
        };

        complete.getMenuInDialog().addActionListener(dialogListener);
        complete.getNextLevel().addActionListener(dialogListener);
        complete.getPlayAgain().addActionListener(dialogListener);

        complete.showDialog();
    }

    public boolean endChoice() {
        return this.endChoice;
    }

    public String getBestScore() {
        return level.getLevel() + "," + this.complete.getName() + "," + level.getMoveCounter();
    }

    public void setOnMenuComplete(ActionListener l) {
        complete.getMenuInDialog().addActionListener(l);
    }

    public void setOnPlayAgain(ActionListener l) {
        complete.getPlayAgain().addActionListener(l);
    }

    public void setOnNextLevel(ActionListener l) {
        complete.getNextLevel().addActionListener(l);
    }

//    public JFrame getFrame()
//    {
//        return this.mainFrame;
//    }
}
