//P272
public class Employee {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date hireDate;
	
	public Employee(String firstName,String lastName,Date birthDate,Date hireDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	}
	
	public String toEmployeeString() {
		return lastName + "," + firstName + " BirthDate: " + birthDate.toDateString() + " HireDate: "  + hireDate.toDateString();
	}
}
