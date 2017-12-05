package Times;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Times.SnowObject;
import Times.SnowPanel;

public class MainActivity extends JFrame {

	Container ct;
	JPanel analogClockPanel, dateClockPanel, timeClockPanels, dayClockPanel, lecturePanel, deptLogoPanel, Background;
	int top = 30, side = 8;
	int width = 1920 + 2 * side, height = 1080 + top + side;
	int analogClockWidth = 900, analogClockHeight = 900;
	int dateClockWidth = 620, dateClockHeight = 50;
	int timeClockWidth = 620, timeClockHeight = 74;
	int dayClockWidth = 620, dayClockHeight = 50;
	int lectureWidth = 620, lectureHeight = 350;
	int deptLogoWidth = 620, deptLogoHeight = 336;
	Font Datefont = new Font("±º∏≤", Font.BOLD, 28);
	Font Timefont = new Font("±º∏≤", Font.BOLD, 50);
	Font Dayfont = new Font("±º∏≤", Font.BOLD, 28);
	JLabel lectureLabel;
	final int SNOWS = 200;
	final int SNOW_SIZE = 50;
	ArrayList<SnowObject> snowList = new ArrayList<SnowObject>();
	SnowPanel sp;

	public MainActivity() {
		this.setTitle("∆¿∫∞ «¡∑Œ¡ß∆Æ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ct = this.getContentPane();
		ct.setLayout(null);
		ct.setBackground(Color.BLACK);
		
		generateSnow();

		AnalogClockPanel analogPanel = new AnalogClockPanel(analogClockPanel);
		Thread analogTh = new Thread(analogPanel);
		analogTh.start();
		analogPanel.setBounds(150, 90, analogClockWidth, analogClockHeight);
		analogPanel.setOpaque(false);

		DatePanel datePanel = new DatePanel(dateClockPanel);
		Thread dateTh = new Thread(datePanel);
		dateTh.start();
		datePanel.setBounds(1150, 90, dateClockWidth, dateClockHeight);
		datePanel.setFont(Datefont);
		datePanel.setOpaque(false);

		TimePanel timePanel = new TimePanel(timeClockPanels);
		Thread timeTh = new Thread(timePanel);
		timeTh.start();
		timePanel.setBounds(1150, 140, timeClockWidth, timeClockHeight);
		timePanel.setFont(Timefont);
		timePanel.setOpaque(false);

		DayPanel dayPanel = new DayPanel(dayClockPanel);
		Thread dayTh = new Thread(dayPanel);
		dayTh.start();
		dayPanel.setBounds(1150, 214, dayClockWidth, dayClockHeight);
		dayPanel.setFont(Dayfont);
		dayPanel.setOpaque(false);
		
		LectureGuidePanel lectureGuidePanel = new LectureGuidePanel(lecturePanel);
		Thread lectureTh = new Thread(lectureGuidePanel);
		lectureTh.start();
		lectureGuidePanel.setBounds(1150, 300, lectureWidth, lectureHeight);
		lectureGuidePanel.setFont(Dayfont);
		lectureGuidePanel.setOpaque(false);
		
		lectureLabel = new JLabel("∞≠¿« æ»≥ª");
		lectureLabel.setBounds(0, 0, 620, 70);
		lectureLabel.setFont(Timefont);
		lectureLabel.setForeground(Color.WHITE);
		lectureGuidePanel.add(lectureLabel);

		DeptLogoPanel logoPanel = new DeptLogoPanel(deptLogoPanel);
		Thread logoTh = new Thread(logoPanel);
		logoTh.start();
		logoPanel.setBounds(1150, 654, deptLogoWidth, deptLogoHeight);
		logoPanel.setOpaque(false);
		
		sp = new SnowPanel(snowList);
		Thread th = new Thread(sp);
		th.start();
		sp.setOpaque(false);
		sp.setBounds(0, 0, 1920, 1080);
		
		MainBackGround ground = new MainBackGround(Background);
		ground.setBounds(0, 0, 1920, 1080);
		
		ct.add(sp);
		ct.add(analogPanel);
		ct.add(datePanel);
		ct.add(timePanel);
		ct.add(dayPanel);
		ct.add(lectureGuidePanel);
		ct.add(logoPanel);
		ct.add(ground);

		this.setSize(width, height);
		this.setVisible(true);
		System.out.println(this.getInsets());
	}
	
	private void generateSnow() {
		// TODO Auto-generated method stub
		for(int i = 0; i < SNOWS; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			
			Point point = new Point(x, y);
			SnowObject so = new SnowObject(point, SNOW_SIZE);
			snowList.add(so);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainActivity();
	}

}
