import java.text.DecimalFormat;

import javax.swing.JOptionPane;

class Time {
	private int hour;
	private int minute;
	private int second;
	private DecimalFormat twoDigits = new DecimalFormat("00");

	public Time(int hour, int minute, int second) {
		this.hour = ((hour >= 0 && hour < 24) ? hour : 0);
		this.minute = ((minute >= 0 && minute < 60) ? minute : 0);
		this.second = ((second >= 0 && second < 60) ? second : 0);
	}

	public String toUniversalString() {
		return twoDigits.format(hour) + ":" + twoDigits.format(minute) + ":" + twoDigits.format(second);
	}

	public String toStandardString() {
		return ((hour == 12 || hour == 0) ? 0 : hour % 12) + ":" + twoDigits.format(minute) + ":"
				+ twoDigits.format(second) + (hour < 12 ? "AM" : "PM");
	}

	public String buildString() {
		return "this.toUniversalString(): " + this.toUniversalString() + "\nthis.toStandardString(): "
				+ this.toStandardString() + "\ntoUniversalString(): " + toUniversalString() + "\ntoStandardString(): "
				+ toStandardString();
	}
}

public class ThisTest {
	public static void main(String args[]) {
		Time time = new Time(13, 27, 6);
		JOptionPane.showMessageDialog(null, time.buildString(), "Testing This in class",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
