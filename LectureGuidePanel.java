package Times;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JPanel;

public class LectureGuidePanel extends JPanel implements Runnable {

	String reuslt;

	public LectureGuidePanel(JPanel lectureGuidePanel) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		// g.drawString("강의 안내", 150, 50);

		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int min = Calendar.getInstance().get(Calendar.MINUTE);
		int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		int time = (((hour - 9) * 60) + min) / 30;

		if (day >= 2 && day <= 6 && time >= 0 && time <= 20) {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + time;
				String[] sb = TimeTable.sb[i][j];
				reuslt = ((i + 1) + "학년 : " + sb[0] + "    " + sb[1] + "  " + sb[2]);
				if (i == 0) {
					g.drawString(reuslt, 10, 145);
				} else {
					g.drawString(reuslt, 10, ((i + 1) * 55) + 90);
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int j = ((day - 2) * 21) + time;
				String[] sb = TimeTable.sb[i][j];
				reuslt = ((i + 1) + "학년 : 집으로 귀가");
				if (i == 0) {
					g.drawString(reuslt, 10, 145);
				} else {
					g.drawString(reuslt, 10, ((i + 1) * 55) + 90);
				}
			}
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
