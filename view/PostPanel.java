package view;

import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PostPanel extends JPanel
{
	private int width;
	private int height;
	
	private JPanel rings;
	private JButton post;
	private JLabel ringLabel;

	private ArrayList<RingIcon> ringIcons = new ArrayList<RingIcon>();
	private ArrayList<JLabel> ringLabels = new ArrayList<JLabel>();
	
	public PostPanel(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(this.width, this.height));
		this.setLayout(new BorderLayout());
		
		// create ring panel
		this.rings = new JPanel();
		this.rings.setBackground(Color.WHITE);
		this.rings.setLayout(new BoxLayout(this.rings, BoxLayout.Y_AXIS));
		
		// create post button
		int postWidth = (int)(this.width / 15);
		this.post = new JButton();
		this.post.setBackground(Color.BLACK);
		this.post.setPreferredSize(new Dimension(postWidth, this.height * 100));
		
		// add post button to post button panel (this formats the post correctly)
		JPanel postButtonPanel = new JPanel();
		postButtonPanel.setLayout(new FlowLayout());
		postButtonPanel.setBackground(Color.WHITE);
		postButtonPanel.add(this.post);
		
		// add ring panel and post button panel to post panel
		this.add(this.rings, BorderLayout.SOUTH);
		this.add(postButtonPanel, BorderLayout.CENTER);
	}

	public JPanel getRingsPanel()
	{
		return this.rings;
	}
	
	public JButton getPostButton()
	{
		return this.post;
	}
	
	public void setPostButton(ActionListener l)
	{
		this.post.addActionListener(l);
	}

	public void removeListener(ActionListener l) {
		this.post.removeActionListener(l);
	}
	
	public void enablePostButton()
	{
		this.post.setEnabled(true);
	}
	
	public void disablePostButton()
	{
		this.post.setEnabled(false);
	}
	
	public void addRing(Ring r)
	{
//		RingIcon ringIcon = new RingIcon(this.height, r);
//		JLabel ringLabel = new JLabel(ringIcon);
//		ringLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		this.rings.add(ringLabel, 0);
//		this.rings.revalidate();
//		this.rings.repaint();

		RingIcon newIcon = new RingIcon(this.height, r);
		this.ringIcons.add(newIcon);

		JLabel newRing = new JLabel(newIcon);
		this.ringLabels.add(newRing);
		newRing.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.rings.add(newRing, 0);
		this.rings.revalidate();
		this.rings.repaint();

	}

	public RingIcon removeTopRing() {
		JLabel topRing = this.ringLabels.get(this.ringLabels.size() - 1);
		this.ringLabels.remove(topRing);
		this.rings.remove(topRing);

		RingIcon topIcon = this.ringIcons.get(this.ringIcons.size() - 1);
		this.ringIcons.remove(topIcon);

		return topIcon;
	}

//	public Ring getTopRing() {
//		return this.ringIcon.getRing();
//	}
	
	public void removeAllRings()
	{
		this.rings.removeAll();
	}
}
