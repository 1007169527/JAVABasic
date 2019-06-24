
//P842
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3 {
	public void printElements() {
		List<Time2> list = new ArrayList<Time2>();
		list.add(new Time2(6, 24, 34));
		list.add(new Time2(18, 14, 05));
		list.add(new Time2(12, 07, 58));
		list.add(new Time2(6, 14, 22));
		list.add(new Time2(8, 05, 00));

		System.out.println("Unsorted elements:\n" + list);

		Collections.sort(list, new TimeComparator());

		System.out.println("Sorted elements:\n" + list);
	}

	public static void main(String[] args) {
		new Sort3().printElements();
	}
}

class TimeComparator implements Comparator<Time2> {
	int hourCompare, minuteCompare, secondCompare;
	// Time2 time1, time2;

	@Override
	public int compare(Time2 o1, Time2 o2) {
		// TODO Auto-generated method stub
		hourCompare = new Integer(o1.getHour()).compareTo(o2.getHour());
		if (hourCompare != 0)
			return hourCompare;
		minuteCompare = new Integer(o1.getMinute()).compareTo(o2.getMinute());
		if (minuteCompare != 0)
			return minuteCompare;
		secondCompare = new Integer(o1.getSecond()).compareTo(o2.getSecond());
		return secondCompare;
	}

}

class Time2 {
	private int mHour;
	private int mMinute;
	private int mSecond;

	private DecimalFormat twoDigits = new DecimalFormat("00");

	public Time2(int hour, int minute, int second) {
		// TODO Auto-generated constructor stub
		mHour = hour;
		mMinute = minute;
		mSecond = second;
	}

	public int getHour() {
		return mHour;
	}

	public int getMinute() {
		return mMinute;
	}

	public int getSecond() {
		return mSecond;
	}

	public String toString() {
		return twoDigits.format(mHour) + ":" + twoDigits.format(mMinute) + ":" + twoDigits.format(mSecond);
	}

}