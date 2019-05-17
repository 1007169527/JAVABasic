import java.io.Serializable;

public class AccountRecord implements Serializable {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	public AccountRecord() {
		// TODO Auto-generated constructor stub
		this(0, "", "", 0.0);
	}

	public AccountRecord(int account, String firstName, String lastName, double balance) {
		setAccount(account);
		setFirstName(firstName);
		setLastName(lastName);
		setBalance(balance);
	}

	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		this.balance = balance;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
	}

	public void setAccount(int account) {
		// TODO Auto-generated method stub
		this.account = account;
	}

	public int getAccount() {
		return account;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getBalance() {
		return balance;
	}

	public String getLastName() {
		return lastName;
	}
}
