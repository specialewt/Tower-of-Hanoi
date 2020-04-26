package controller;

import model.BestScores;
import model.Level;
import view.GameFrame;
import view.HomePanel;
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
    protected BestScores localBestScores;
    protected LevelScreenInterface levelScreen;
    protected GameController game;
    protected volatile boolean levelChosen = false;
    protected volatile boolean inMenu;

    public MainController(HomePanelInterface homeScreen,GameFrameInterface gameFrame, BestScores localBestScores)
    {
        
        this.homeScreen = homeScreen;
        this.gameFrame = gameFrame;
        this.localBestScores = localBestScores;
        
        this.levelButtonSetup();

        this.gameFrame.swapMainPanel(this.homeScreen.getHomePanel());
        this.inMenu = true;

//        this.startGame();
//        this.gameFrame.getFrame().add(this.homeScreen.getHomePanel());
    }

    public HomePanelInterface getHomeScreen() {
        return this.homeScreen;
    }
    
    private void levelButtonSetup()
    {
        for (int i=1;i<5;i++)
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
                    inMenu = false;
                }
            };
            this.homeScreen.setOnLevelSelect(tempListener,i);
        }
    
    }
        
    private void selectLevel(int levelNum)
    {
        System.out.println("You chose Level "+levelNum);

        Level level = new Level(levelNum);
        this.levelScreen = new LevelScreen(this.gameFrame, level);
        levelScreen.createLevel();

        // creating game
        game = new GameController(this.gameFrame, this, level, this.levelScreen);
        this.gameFrame.swapMainPanel(levelScreen.getLevelPanel());
    }
    
    public void endOfLevelUpdates(String currentLevelScore)
    {
        String[] levelInfo = currentLevelScore.split(",");
        
        int tempLevelNum = Integer.parseInt(levelInfo[0].substring(levelInfo[0].length()-1));
        int tempScore = Integer.parseInt(levelInfo[1]);
    
        //Update BestScores
        this.localBestScores.checkBestScore(tempLevelNum,tempScore,levelInfo[2]);
    
        //Update the homeScreen
        this.homeScreen.updateHighScores(this.localBestScores.getNamesAndScores());
    }

    public void startGame()
    {
        // choose level then play
        while(true) {
            if (inMenu) {
                while (!levelChosen);
                levelChosen = false;
                this.inMenu = false;
            }
            game.play();
        }
    }

    public void setInMenu(boolean b) {
        this.inMenu = b;
    }
}
