package net.rtfsc;

public class GuestBean {
    private String firstName, lastName, email;
	
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getEmail() {
    	return email;
    }
}
