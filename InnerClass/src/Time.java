
//P264
import java.text.DecimalFormat;

public class Time {
	private int hour;
	private int minute;
	private int second;
	private DecimalFormat twoDigits = new DecimalFormat("00");

	public Time() {
		this(0, 0, 0);
	}

	public Time(int hour) {
		this(hour, 0, 0);
	}

	public Time(int hour, int minute) {
		this(hour, minute, 0);
	}

	public Time(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	public Time(Time time) {
		this(time.hour, time.minute, time.second);
	}

	public void setTime(int hour, int minute, int second) {
		this.hour = ((hour >= 0 && hour < 24) ? hour : 0);
		this.minute = ((minute >= 0 && minute < 60) ? minute : 0);
		this.second = ((second >= 0 && second < 60) ? second : 0);
	}

	public void setHour(int hour) {
		this.hour = ((hour >= 0 && hour < 24) ? hour : 0);
	}

	public void setMinute(int minute) {
		this.minute = ((minute >= 0 && minute < 60) ? minute : 0);
	}

	public void setSecond(int second) {
		this.second = ((second >= 0 && second < 60) ? second : 0);
	}

	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	public String toUniversalString() {
		return twoDigits.format(hour) + ":" + twoDigits.format(minute) + ":" + twoDigits.format(second);
	}

	public String toStandardString() {
		return ((hour == 12 || hour == 0) ? 0 : hour % 12) + ":" + twoDigits.format(minute) + ":"
				+ twoDigits.format(second) + (hour < 12 ? "AM" : "PM");
	}
}