//P337

public class SalariedEmployee extends Employee {
	private double mWeeklySalary;
	
	public SalariedEmployee(String firstName,String lastName,String socialSecurityNumber,double weeklySalary) {
		super(firstName,lastName,socialSecurityNumber);
		setWeeklySalary(weeklySalary);
	}
	
	public void setWeeklySalary(double weeklySalary) {
		mWeeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary() {
		return mWeeklySalary;
	}
	
	public String toString() {
		return "\nSalariedEmployee " + super.toString();
	}
	
	public double earning() {
		return getWeeklySalary();
	}
}
