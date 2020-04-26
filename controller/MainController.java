package controller;

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
    

    
    public MainController(HomePanelInterface homeScreen,GameFrameInterface gameFrame)
    {
        
        this.homeScreen = homeScreen;
        this.gameFrame = gameFrame;
        
        this.levelButtonSetup();
        this.gameFrame.swapMainPanel(this.homeScreen.getHomePanel());
    
    }
    
    private void levelButtonSetup()
    {
        for (int i=1;i<7;i++)
        {
            final int tempInt = i;
            ActionListener tempListener = new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    //Add the proper inteface fuction here
                    final int levelNum = tempInt;
//                  System.out.println("BUTTON WAS PRESSED"+levelNum);
                    selectLevel(tempInt);
                }
            };
            this.homeScreen.setOnLevelSelect(tempListener,i);
        }
    
    }
        
    private void selectLevel(int levelNum)
    {
        System.out.println("You pressed button "+levelNum);
    
    }
    
    private void playLevel()
    {
        
    }
}
