package Times;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DeptLogoPanel extends JPanel implements Runnable {
	
	int logoWidth, logoHeight;
	int second;
	ImageIcon imageIcon = new ImageIcon("images/whitelogo.png");
	Image image = imageIcon.getImage();
	
	public DeptLogoPanel(JPanel deptLogoPanel) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, logoWidth, logoHeight, this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			try {
				second = Calendar.getInstance().get(Calendar.SECOND);
				iconSize(second);
//				System.out.println(second);
//				System.out.println(logoWidth + " " + logoHeight);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void iconSize(int s) {
		logoWidth = (s * 10) ;
		logoHeight = (s * 10) / 2 ;
		return;
	}
	
}
