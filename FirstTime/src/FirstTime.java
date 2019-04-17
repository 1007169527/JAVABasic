
//P253
import java.text.DecimalFormat;

public class FirstTime {
	private int hour;
	private int minute;
	private int second;
	private DecimalFormat twoDigits = new DecimalFormat("00");

	public FirstTime() {
		setTime(0, 0, 0);
	}

	public void setTime(int h, int m, int s) {
		hour = ((h >= 0 && h < 24) ? h : 0);
		minute = ((m >= 0 && m < 60) ? m : 0);
		second = ((s >= 0 && s < 60) ? s : 0);
	}

	public String toUniversalString() {
		return twoDigits.format(hour) + ":" + twoDigits.format(minute) + ":" + twoDigits.format(second);
	}

	public String toStandardString() {
		return ((hour == 12 || hour == 0) ? 0 : hour % 12) + ":" + twoDigits.format(minute) + ":"
				+ twoDigits.format(second) + (hour < 12 ? "AM" : "PM");
	}
}
