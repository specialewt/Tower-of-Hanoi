import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel
{
	private int width;
        private int height;
	
	public GamePanel(int width)
	{
		this.setBackground(Color.WHITE);
		this.width = width;
                this.height = width / 2;
		this.setLayout(new BorderLayout());
                this.setPreferredSize(new Dimension(this.width, this.height));
	}
	
	public void paintComponent(Graphics g)
	{
		 super.paintComponent(g);
		 
		 g.setColor(Color.BLACK);
		 int rodHeight = (int)(3 * height / 5);
		 int rodWidth = (int)(width / 50);
		 int rody = (int)(height / 5);
		 
		 int rod1x = (int)(width / 5);
		 int rod2x = (int)(width / 2);
		 int rod3x = (int)(4 * width / 5);
		 
		 g.fillRect(rod1x - rodWidth / 2, rody, rodWidth, rodHeight);
		 g.fillRect(rod2x - rodWidth / 2, rody, rodWidth, rodHeight);
		 g.fillRect(rod3x - rodWidth / 2, rody, rodWidth, rodHeight);
		 
		 int diskHeight = (int)(height / 20);
		 int disky = (int)(rodHeight + rody);
		 
		 int diskWidth1 = (int)(width / 10);
		 int diskWidth2 = (int)(3 * width / 20);
		 int diskWidth3 = (int)(width / 5);
		 int diskWidth4 = (int)(width /4);
		 		 
		 g.setColor(Color.RED);
		 g.fillRect(rod1x - diskWidth1 / 2, disky - diskHeight, diskWidth1, diskHeight);
		 
		 g.setColor(Color.YELLOW);
		 g.fillRect(rod3x - diskWidth2 / 2, disky - 2 * diskHeight, diskWidth2, diskHeight);
		 
		 g.setColor(Color.GREEN);
		 g.fillRect(rod3x - diskWidth3 / 2, disky - diskHeight, diskWidth3, diskHeight);

		 g.setColor(Color.BLUE);
		 g.fillRect(rod2x - diskWidth4 / 2, disky - diskHeight, diskWidth4, diskHeight);
	}
}
