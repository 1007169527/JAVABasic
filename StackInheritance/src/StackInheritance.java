
public class StackInheritance extends List {
	public StackInheritance() {
		// TODO Auto-generated constructor stub
		super("stack");
	}

	public synchronized void push(Object object) {
		insertAtFront(object);
	}

	public synchronized Object pop() {
		return removeFromFront();
	}
}
