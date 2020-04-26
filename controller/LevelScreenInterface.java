package controller;

import model.*;
import view.DialogPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface LevelScreenInterface {

    public void createLevel();
    public void buildGame(Level level);
    public JPanel getLevelPanel();

    // setting up control panel buttons
    public void setOnMenu(ActionListener menuListener);
    public void setOnReset(ActionListener resetListener);
    public void disableMenu();
    public void disableReset();
    public void enableMenu();
    public void enableReset();

    // setting up post buttons
    public void setOnLeft(ActionListener postListener);
    public void setOnMid(ActionListener postListener);
    public void setOnRight(ActionListener postListener);
    public void removeOnLeft(ActionListener l);
    public void removeOnMid(ActionListener l);
    public void removeOnRight(ActionListener l);

    // moving rings during game
    public void moveRingIcon(int sendPost, int receivePost);
    public void invalidMove();
    public void updateMoves(int newMoveCount);

    // level completion
    public void levelComplete(int levelNum, int moves);
    public String getBestScore();
    public void setOnMenuComplete(ActionListener menuListener);
    public void setOnNextLevel(ActionListener nextListener);
    public void setOnPlayAgain(ActionListener resetListener);
    public boolean endChoice();
}
