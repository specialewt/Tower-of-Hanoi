package controller;

import model.*;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface HomePanelInterface
{
    public void updateHighScores(ArrayList<String> newScores);
    public void setOnLevelSelect(ActionListener selectListener,int levelNumber);
    public JPanel getHomePanel();


}
