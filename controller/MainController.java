package controller;

import model.Level;
import view.LevelScreen;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class MainController
{
    
    protected ArrayList<ActionListener> levelListenerList;
    
    protected GameFrameInterface gameFrame;
    protected HomePanelInterface homeScreen;
//     protected LevelPanelInterFace currentLevel;
//     protected BestScores localBestScores;
    protected LevelScreenInterface levelScreen;
    protected GameController game;
    protected volatile boolean levelChosen = false;

    public MainController(HomePanelInterface homeScreen,GameFrameInterface gameFrame)
    {
        
        this.homeScreen = homeScreen;
        this.gameFrame = gameFrame;
        
        this.levelButtonSetup();

        this.gameFrame.swapMainPanel(this.homeScreen.getHomePanel());

        this.startGame();
//        this.gameFrame.getFrame().add(this.homeScreen.getHomePanel());
    }

    public HomePanelInterface getHomeScreen() {
        return this.homeScreen;
    }
    
    private void levelButtonSetup()
    {
        for (int i=1;i<6;i++)
        {
            final int tempInt = i;
            ActionListener tempListener = new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    //Add the proper inteface fuction here
                    final int levelNum = tempInt;
//                  System.out.println("BUTTON WAS PRESSED"+levelNum);
                    selectLevel(tempInt);
                    levelChosen = true;
                }
            };
            this.homeScreen.setOnLevelSelect(tempListener,i);
        }
    
    }
        
    private void selectLevel(int levelNum)
    {
        System.out.println("You pressed button "+levelNum);

        Level level = new Level(levelNum);
        this.levelScreen = new LevelScreen(this.gameFrame, level);
        levelScreen.createLevel();

        game = new GameController(this.gameFrame, this, level, this.levelScreen);
        System.out.println("game created");

        this.gameFrame.swapMainPanel(levelScreen.getLevelPanel());

        System.out.println("swapped");
    }

    public void startGame()
    {
        while (!levelChosen) ;
        levelChosen = false;
        game.play();
    }
}
