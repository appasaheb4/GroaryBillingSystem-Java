package Class;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Pages.LoginPage;

/**
 *
 * @author Sam, slightly adjusted by Piet
 */

public class Clock extends JPanel implements Runnable {

	Thread thread = null;
	SimpleDateFormat formatter = new SimpleDateFormat("s", Locale.getDefault());
	Date currentDate;
	int xcenter = 175, ycenter = 175, lastxs = 0, lastys = 0, lastxm = 0,
			lastym = 0;
	static int lastxh = 0;
	int lastyh = 0;

	private void drawStructure(Graphics normal_g) {
		Graphics2D g = (Graphics2D) normal_g.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.setColor(Color.black);
		g.fillOval(xcenter - 100, ycenter - 100, 5, 5);
		g.setColor(Color.blue);

		g.setColor(Color.green);
		g.drawString("9", xcenter - 200, ycenter + 0);
		g.drawString("3", xcenter + 135, ycenter + 0);
		g.drawString("12", xcenter - 10, ycenter - 130);
		g.drawString("6", xcenter - 10, ycenter + 145);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xhour, yhour, xminute, yminute, xsecond, ysecond, second, minute, hour;
		drawStructure(g);
		currentDate = new Date();
		formatter.applyPattern("s");
		second = Integer.parseInt(formatter.format(currentDate));
		formatter.applyPattern("m");
		minute = Integer.parseInt(formatter.format(currentDate));
		formatter.applyPattern("h");
		hour = Integer.parseInt(formatter.format(currentDate));
		xsecond = (int) (Math.cos(second * 3.14f / 30 - 3.14f / 2) * 120 + xcenter);
		ysecond = (int) (Math.sin(second * 3.14f / 30 - 3.14f / 2) * 120 + ycenter);
		xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + xcenter);
		yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + ycenter);
		xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f
				/ 2) * 80 + xcenter);
		yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f
				/ 2) * 80 + ycenter);

		g.drawLine(xcenter, ycenter, xsecond, ysecond);
		g.setColor(Color.red);
		g.drawLine(xcenter, ycenter - 1, xminute, yminute);
		g.drawLine(xcenter - 1, ycenter, xminute, yminute);
		g.setColor(Color.green);
		g.drawLine(xcenter, ycenter - 1, xhour, yhour);
		g.drawLine(xcenter - 1, ycenter, xhour, yhour);
		lastxs = xsecond;
		lastys = ysecond;
		lastxm = xminute;
		lastym = yminute;
		lastxh = xhour;
		lastyh = yhour;
	}

	// public void start(){
	// if(thread==null){
	// thread=new Thread(this);
	// thread.start();
	// }
	// }
	//
	// public void stop(){
	// thread=null;
	// }

	public void startClock() {
		thread = new Thread(this);
		thread.start();
		System.out.println("thred start");
	}

	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			repaint();
		}
		thread = null;
	}

	// public void update(Graphics g){
	// paint(g);
	// }

	public static void Start() {
		
		Clock clock = new Clock();
		clock.startClock();
		//LoginPage.panelWatchShow.add(clock);
		System.out.println("start method call");

	}

}
