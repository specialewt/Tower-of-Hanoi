package view;

import model.*;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel
{
	private int width;
	private int height;
		
	private PostPanel leftPost;
	private PostPanel middlePost;
	private PostPanel rightPost;
	
	public GamePanel(int width)
	{
		this.width = width;
		this.height = (int)(width / 2);
				
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// add posts to game panel
		int postWidth = (int)(this.width / 3);
		this.leftPost = new PostPanel(postWidth, this.height);
		this.middlePost = new PostPanel(postWidth, this.height);
		this.rightPost = new PostPanel(postWidth, this.height);
		this.add(this.leftPost);
		this.add(this.middlePost);
		this.add(this.rightPost);
		
//		this.leftPost.addRing(new Ring(6));
//		this.leftPost.addRing(new Ring(5));
//		this.leftPost.addRing(new Ring(4));
		
//		this.leftPost.addRing(new Ring(3));
//		this.leftPost.addRing(new Ring(2));
//		this.leftPost.addRing(new Ring(1));
		
//		this.middlePost.addRing(new Ring(4));
		
//		this.middlePost.addRing(new Ring(2));
//		this.middlePost.addRing(new Ring(1));
//		
//		this.rightPost.addRing(new Ring(6));
//		this.rightPost.addRing(new Ring(5));
		
//		this.rightPost.addRing(new Ring(4));		
	}
	
	public PostPanel getLeftPost()
	{
		return this.leftPost;
	}
	
	public PostPanel getMiddlePost()
	{
		return this.middlePost;
	}
	
	public PostPanel getRightPost()
	{
		return this.rightPost;
	}
	
	public void removeRingsAllPosts()
	{
		this.leftPost.removeAllRings();
		this.middlePost.removeAllRings();
		this.rightPost.removeAllRings();
	}
}
