
package controller;

import javax.swing.*;
import java.awt.*;

public interface GameFrameInterface
{
    public void swapMainPanel(JPanel newPanel);
    public int getFrameWidth();
    public int getFrameHeight();
    public JFrame getFrame();
}
