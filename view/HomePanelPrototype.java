package view;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;


public class HomePanelPrototype
{
    private JFrame mainFrame;
    private int frameHeight;
    private int frameWidth;
    
    public HomePanelPrototype(int frameSize)
    {
        this.mainFrame = new JFrame("Tower of Hanoi: Home");
        
        //Set the dimensions of the main window.
        this.frameHeight = 5/3*frameSize;
        this.frameWidth = frameSize;
        this.mainFrame.setPreferredSize(new Dimension(this.frameWidth, this.frameHeight));
        
        //Setup defualt close operation.
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add the levelSelectPanel
        
        this.mainFrame.add(new HomePanel(this.frameWidth,this.frameHeight));
        
                
        mainFrame.pack();
        mainFrame.setVisible(true);
        
    }
    
    public JFrame getFrame()
    {
        return this.mainFrame;
    }
    

}
