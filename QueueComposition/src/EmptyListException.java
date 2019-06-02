//P770
public class EmptyListException extends RuntimeException {
	public EmptyListException() {
		this("list");
	}

	public EmptyListException(String listName) {
		// TODO Auto-generated constructor stub
		super(listName + " is empty");
	}
}
