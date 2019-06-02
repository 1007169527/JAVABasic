
public class QueueComposition {
	private List queueList;

	public QueueComposition() {
		queueList = new List("stack");
	}

	public synchronized void enqueue(Object object) {
		queueList.insertAtEnd(object);
	}

	public synchronized Object dequeue() {
		return queueList.removeFromFront();
	}

	public void print() {
		queueList.print();
	}
}
