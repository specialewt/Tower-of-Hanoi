package view;

import controller.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

public class GameFrame implements GameFrameInterface
{
    protected JFrame mainFrame;
    public static int frameSize = 800;
    private int frameHeight;
    private int frameWidth;
    
    public GameFrame()
    {
        this.mainFrame = new JFrame("Tower of Hanoi Game");
        
        //Set the dimensions of the main window.
        this.frameHeight = 5/3*frameSize;
        this.frameWidth = frameSize;
        this.mainFrame.setPreferredSize(new Dimension(this.frameWidth, this.frameHeight));
        
        //Setup defualt close operation.
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add the levelSelectPanel
                        
        mainFrame.pack();
        mainFrame.setVisible(true);
        
    }
    
    public int getFrameWidth()
    {
        return this.frameWidth;
    }
    
    public int getFrameHeight()
    {
        return this.frameHeight;
    }
    
    public JFrame getFrame()
    {
        return this.mainFrame;
    }
    
    //Interface Method
    public void swapMainPanel(JPanel newPanel)
    {
//        this.mainFrame.setVisible(false);
        this.mainFrame.getContentPane().removeAll();
        
        this.mainFrame.getContentPane().add(newPanel);

        this.mainFrame.revalidate();
        this.mainFrame.repaint();
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }

}
