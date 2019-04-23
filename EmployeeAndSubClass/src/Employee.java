//P336

public abstract class Employee {
	private String mFirstName;
	private String mLastName;
	private String mSocialSecurityNumber;
	
	public Employee(String firstName,String lastName, String socialSecurityNumber) {
		mFirstName = firstName;
		mLastName = lastName;
		mSocialSecurityNumber = socialSecurityNumber;
	}
	
	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}
	
	public void setLastName(String lastName) {
		mLastName = lastName;
	}
	
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		mSocialSecurityNumber = socialSecurityNumber;
	}
	
	public String getFirstName() {
		return mFirstName;
	}
	
	public String getLastName() {
		return mLastName;
	}
	
	public String getSocialSecurityNumber() {
		return mSocialSecurityNumber;
	}
 	
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getSocialSecurityNumber();
	}

	public abstract double earning();
}
