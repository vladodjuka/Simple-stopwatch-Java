import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stopwatch extends Thread {
	private int sec = 0;
	private int min = 0;
	private int hours = 0;
	private JLabel panel;
	private int speed;

	public Stopwatch(JLabel panel, int speed) {
		super();
		this.panel = panel;
		this.speed = speed;
	}

	@Override
	public void run() {
		panel.removeAll();
		boolean stop = false;

		while (!stop) {
			String time = "";

			sec++;

			if (sec == 60) {
				min++;
				sec = 0;
			}

			if (min == 60) {
				hours++;
				min = 0;
			}

			panel.setText(hours+"h"+" : "+min+"m"+" : "+sec+"s");
			

			try {
				Thread.sleep(speed);
			} catch (InterruptedException d) {
				stop = true;
				break;
				//Thread.interrupted();
			}

		}

	}

}
