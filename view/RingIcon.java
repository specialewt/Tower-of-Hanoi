package view;

import model.*;
import java.awt.*;
import javax.swing.*;

public class RingIcon implements Icon
{
	private int width;
	private int height;
	private Ring ring;
	
	private Color color;
	private Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA};
	
	public RingIcon(int height, Ring ring)
	{
		this.ring = ring;

		this.height = (int)(height / 10);
		this.width = this.ring.getSize() * this.height;
		
		this.color = this.colors[this.ring.getSize() - 1];
	}

	public Ring getRing() {
		return this.ring;
	}

	@Override
	public int getIconWidth()
	{
		return this.width;
	}
	
	@Override
	public int getIconHeight()
	{
		return this.height;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(this.color);
		g2.fillRect(x, y, this.width, this.height);
		Stroke stroke = new BasicStroke(2);
		g2.setColor(Color.BLACK);
		g2.setStroke(stroke);
		g2.drawRect(x, y, this.width, this.height);
	}
}
