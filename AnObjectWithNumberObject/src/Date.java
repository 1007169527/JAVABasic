//P271
public class Date {
	private int month;
	private int day;
	private int year;

	public Date(int month, int day, int year) {
		this.month = checkMonth(month);
		this.day = checkDay(day);
		this.year = year;
	}

	public int checkMonth(int month) {
		if (month > 0 && month <= 12)
			return month;
		else {
			System.out.println("Invalid month (" + this.month + ") set to 1");
			return 1;
		}
	}

	public int checkDay(int day) {
		int dayPerMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (day > 0 && day <= dayPerMonth[this.month])
			return day;
		if (day == 29 && this.month == 2 && (this.year%400 == 0 || (this.year %4 == 0 && this.year%100 !=0)))
			return 29;
		System.out.println("Invalid day (" + this.day + ") set to 1");
		return 1;
	}
	
	public String toDateString() {
		return month + "/" + day + "/" +year;
	}
}
