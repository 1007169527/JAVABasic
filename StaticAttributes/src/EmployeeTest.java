//P275
import javax.swing.JOptionPane;

public class EmployeeTest {
	public static void main(String args[]) {
		String output = "Employee before instantiation: " + Employee.getCount();
		Employee num1 = new Employee("Susan", "Baker");
		Employee num2 = new Employee("Bob","Jones");
		output += "\nEmployee after instantiation: " + 
		"\n num1.getCount: " + num1.getCount() + 
		"\n num2.getCount: " + num2.getCount() +
		"\n Employee.getCount: " + Employee.getCount();
		
		num1=null;
		num2=null;
		System.gc();
		
		output += "\nEmployee after 2 gc(): " + 
		"\n Employee.getCount: " + Employee.getCount();
				
		JOptionPane.showMessageDialog(null, output,"Test Class Employee",JOptionPane.INFORMATION_MESSAGE);
	}
}
