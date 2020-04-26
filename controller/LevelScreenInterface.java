package controller;

import model.*;
import view.DialogPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface LevelScreenInterface {

    public void createLevel();
    public JPanel getLevelPanel();

    public void setOnMenu(ActionListener menuListener);
    public void setOnReset(ActionListener resetListener);
//    public void setOnLevel(ActionListener levelListener);
    public void disableMenu();
    public void disableReset();
    public void enableMenu();
    public void enableReset();

    public void setOnLeft(ActionListener postListener);
    public void setOnMid(ActionListener postListener);
    public void setOnRight(ActionListener postListener);
    public void removeOnLeft(ActionListener l);
    public void removeOnMid(ActionListener l);
    public void removeOnRight(ActionListener l);

    public void buildGame(Level level);
    public void moveRingIcon(int sendPost, int receivePost);
    public void updateMoves(int newMoveCount);

    public void levelComplete();
    public String getBestScore();
    public void setOnMenuComplete(ActionListener menuListener);
    public void setOnNextLevel(ActionListener nextListener);
    public void setOnPlayAgain(ActionListener resetListener);
    public boolean endChoice();


//    public JFrame getFrame();
}
