//P339

public class CommissionEmployee extends Employee {
	private double mGrossSales;
	private double mCommissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
	}

	public void setGrossSales(double grossSales) {
		mGrossSales = grossSales <= 0 ? 0 : grossSales;
	}

	public double getGrossSales() {
		return mGrossSales;
	}

	public void setCommissionRate(double commissionRate) {
		mCommissionRate = (commissionRate > 0.0 && commissionRate < 1.0) ? commissionRate : 0.0;
	}

	public double getCommissionRate() {
		return mCommissionRate;
	}

	public String toString() {
		return "CommissionEmploy: " + super.toString();
	}

	public double earning() {
		return mGrossSales * mCommissionRate;
	}
}
