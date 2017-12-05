package Times;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatePanel extends JPanel implements Runnable {

	String result;
	JLabel month;
	SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM dd yyyy", Locale.US);
	
	public DatePanel(JPanel datePanel) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.drawString(result, 130, 35);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Date toDaye = new Date();
				result = sdf.format(toDaye);
				//System.out.println(result);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
