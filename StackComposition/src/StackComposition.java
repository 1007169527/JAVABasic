
public class StackComposition {
	private List stackList;

	public StackComposition() {
		stackList = new List("stack");
	}

	public synchronized void push(Object object) {
		stackList.insertAtFront(object);
	}

	public synchronized Object pop() {
		return stackList.removeFromFront();
	}

	public void print() {
		stackList.print();
	}
}
