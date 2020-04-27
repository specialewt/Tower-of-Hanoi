package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class LevelSelectPanel extends JPanel
{
    private ArrayList<JButton> levelList;
    private Box levelBox;
    private Font buttonFont =new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    
    public LevelSelectPanel(int parentWidth, int parentHeight)
    {
        super();
        
        
        this.levelList = new ArrayList<JButton>();
        
        
        this.setPreferredSize(new Dimension(parentWidth,parentHeight));
        
        //this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Set the color of the panel.
        this.setBackground(Color.CYAN);
        
        
        //Set the layout.
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        this.levelBox = Box.createVerticalBox();
        //this.levelBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredSoftBevelBorder(),BorderFactory.createRaisedSoftBevelBorder()));
        
        this.levelBox.add(Box.createGlue());
        
        for (int i =0; i<5;i++)
        {
            int levelNum = i+1;
            JButton newLevelButton = new JButton("Level "+levelNum+"    "+"[Best Score]");
            //newLevelButton.setPreferredSize(new Dimension(parentWidth,parentHeight));
            newLevelButton.setFont(this.buttonFont);
            newLevelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            newLevelButton.setBorder(BorderFactory.createSoftBevelBorder(-1,Color.GRAY,Color.WHITE));
            this.levelBox.add(newLevelButton);
            this.levelBox.add(Box.createGlue());
            
            this.levelList.add(newLevelButton);
        }
                
        this.add(this.levelBox);
        
    }
    
  
    public void updateLevelButtonText(int level, String newText)
    {
        String[] tempLevelInfo = newText.split(",");
//        String baseText = tempLevelInfo[0]+"    "+"[Best Score]";
        String baseText = "Level " + level + "    " + "[Best Score]";
        JButton tempButton = this.levelList.get(level-1);
        
        
        if (tempLevelInfo[2].equals("0"))
        {
            tempButton.setText(baseText);
            return;
        
        }else{
            baseText = "Level "+level+"    "+"["+tempLevelInfo[1]+": "+tempLevelInfo[2]+"]";
            tempButton.setText(baseText);
            return;
        }
    }
    
    public ArrayList<JButton> getButtons()
    {
        return this.levelList;
    }

}
