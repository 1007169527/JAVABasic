//P274
public class Employee {
	private String firstName;
	private String lastName;
	private static int count = 0;
	
	public Employee(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		++ count;
		System.out.println("Employee constructor: " + this.firstName + " " + this.lastName);
	}
	
	protected void finalize() {
		--count;
		System.out.println("Employee finalizer: " + firstName + " " + lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public static int getCount() {
		return count;
	}
  }
