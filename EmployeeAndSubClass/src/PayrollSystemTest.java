import javax.swing.JOptionPane;

//P340
public class PayrollSystemTest {
	public static void main(String args[]) {
		Employee employees[] = new Employee[4];
		employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800);
		employees[1] = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, 0.06);
		employees[2] = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, 0.04, 300);
		employees[3] = new HourlyEmployee("Karen", "Price", "444-44-4444", 16, 40);

		String output = "";

		for (int i = 0; i < employees.length; i++) {
			output += employees[i].toString();
			if (employees[i] instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee currentEmployee = (BasePlusCommissionEmployee) employees[i];
				double oldBaseSalary = currentEmployee.getBaseSalary();
				currentEmployee.setBaseSalary(oldBaseSalary * 1.1);
			}
			output += "\nearned $" + employees[i].earning() + "\n";
		}

		for (int j = 0; j < employees.length; j++) {
			output += "\nEmployee " + j + " is a " + employees[j].getClass().getName();
		}

		JOptionPane.showMessageDialog(null, output);
	}
}
