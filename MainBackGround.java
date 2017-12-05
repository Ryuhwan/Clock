package Times;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainBackGround extends JPanel {

	ImageIcon ima = new ImageIcon("images/sky.png");
	Image image = ima.getImage();
	
	public MainBackGround(JPanel mainBackGround) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, 1920, 1080, this);
	}

}
