//P338

public class HourlyEmployee extends Employee {
	private double mWage;
	private double mHours;
	
	public HourlyEmployee(String firstName,String lastName,String socialSecurityNumber,double wage,double hours) {
		super(firstName,lastName,socialSecurityNumber);
		setWage(wage);
		setHours(hours);
	}
	
	public void setWage(double wage) {
		mWage = wage;
	}
	
	public double getWage() {
		return mWage;
	}
	
	public void setHours(double hours) {
		mHours = (hours >= 0.0 && hours <= 168.0) ? hours:0.0;
 	}
	
	public double getHours() {
		return mHours;
	}
	
	public String toString() {
		return "\nHourlyEmployee " + super.toString();
	}
	
	public double earning() {
		if(mHours <= 40)
			return mWage*mHours;
		else
			return 40*mWage + (mHours-40) *mWage*1.5;
	}
}
