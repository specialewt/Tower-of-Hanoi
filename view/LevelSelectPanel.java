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
        this.setPreferredSize(new Dimension(parentWidth,parentHeight));
        
        //this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Set the color of the panel.
        this.setBackground(Color.CYAN);
        
        
        //Set the layout.
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        this.levelBox = Box.createVerticalBox();
        //this.levelBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredSoftBevelBorder(),BorderFactory.createRaisedSoftBevelBorder()));
        
        this.levelBox.add(Box.createGlue());
        
        for (int i =0; i<6;i++)
        {
            int levelNum = i+1;
            JButton newLevelButton = new JButton("Level "+levelNum+"    "+"[Highscore Score]"+"    "+"[Best Score]");
            //newLevelButton.setPreferredSize(new Dimension(parentWidth,parentHeight));
            newLevelButton.setFont(this.buttonFont);
            newLevelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            newLevelButton.setBorder(BorderFactory.createSoftBevelBorder(-1,Color.GRAY,Color.WHITE));
            this.levelBox.add(newLevelButton);
            this.levelBox.add(Box.createGlue());
        }
                
        this.add(this.levelBox);
        
    }

}
