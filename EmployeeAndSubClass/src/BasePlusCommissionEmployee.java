//P340

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double mBaseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		setBaseSalary(baseSalary);
	}

	public void setBaseSalary(double baseSalary) {
		mBaseSalary = baseSalary < 0.0 ? 0 : baseSalary;
	}

	public double getBaseSalary() {
		return mBaseSalary;
	}

	public String toString() {
		return "BasePlusCommisionEmploy: " + super.getFirstName() + " " + super.getLastName() + " "
				+ super.getSocialSecurityNumber();
	}

	public double earning() {
		return mBaseSalary + super.earning();
	}
}
