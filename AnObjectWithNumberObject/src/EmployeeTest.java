//P272
import javax.swing.JOptionPane;

public class EmployeeTest {
	public static void main(String argsp[]) {
		Date birthDate = new Date(4,17,1992);
		Date hireDate = new Date(7,15,2017);
		Employee me = new Employee("Guo","ChuPeng",birthDate,hireDate);
		JOptionPane.showMessageDialog(null, me.toEmployeeString(), "Testing Class Employee", JOptionPane.INFORMATION_MESSAGE);
	}
}
