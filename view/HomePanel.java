package view;

import controller.HomePanelInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;


public class HomePanel extends JPanel implements HomePanelInterface
{
    private JLabel homeScreenTitle;
    private LevelSelectPanel localLevelPanel;
    private BoxLayout customBox;
    private Font titleFont =  new Font(Font.SANS_SERIF, Font.ITALIC, 24);
    
    
    public HomePanel(int frameWidth,int frameHeight)
    {
        super();
        this.setBackground(Color.CYAN);
        this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.WHITE));
        
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));
        
        //this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        this.homeScreenTitle = new JLabel("Tower of Hanoi");
        this.homeScreenTitle.setForeground(Color.BLACK);
        this.homeScreenTitle.setFont(this.titleFont);
        this.homeScreenTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.homeScreenTitle.setPreferredSize(new Dimension(frameWidth,frameHeight*1/5));
        
        
        //this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createSoftBevelBorder(Color.WHITE,Color.CYAN), BorderFactory.createSoftBevelBorder(Color.WHITE,Color.CYAN)));
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        
        this.localLevelPanel = new LevelSelectPanel(frameWidth,frameHeight);
        this.localLevelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(this.homeScreenTitle);
        this.add(this.localLevelPanel);
            
    }
    
    //Interface Method
    public void updateHighScores(ArrayList<String> newScores)
    {
        int levelNum = 0;
        for (String score : newScores)
        {
            levelNum++;
            this.localLevelPanel.updateLevelButtonText(levelNum,score);
        }    
    }
    
    //Interface Method
    public void setOnLevelSelect(ActionListener selectListener,int levelNumber)
    {
        JButton tempButtonList= this.localLevelPanel.getButtons().get(levelNumber-1);
        tempButtonList.addActionListener(selectListener);
    }
    
    //Interface Method
    public JPanel getHomePanel()
    {
        return this;
    }

}
