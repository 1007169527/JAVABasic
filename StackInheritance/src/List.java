//P769
class ListNode {
	Object data;
	ListNode nextNode;

	public ListNode(Object object) {
		this(object, null);
	}

	public ListNode(Object object, ListNode node) {
		data = object;
		nextNode = node;
	}

	public Object getObject() {
		return data;
	}

	public ListNode getNext() {
		return nextNode;
	}
}

public class List {
	private ListNode firstNode;
	private ListNode lastNode;
	private String name;

	public List() {
		this("list");
	}

	public List(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	public synchronized void insertAtFront(Object insertItem) {
		if (isEmpty())
			firstNode = lastNode = new ListNode(insertItem);
		else
			firstNode = new ListNode(insertItem, firstNode);
	}

	public synchronized void insertAtEnd(Object insertItem) {
		if (isEmpty())
			firstNode = lastNode = new ListNode(insertItem);
		else
			lastNode = lastNode.nextNode = new ListNode(insertItem);
	}

	public synchronized Object removeFromFront() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);
		Object removeItem = firstNode.data;
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;
		return removeItem;
	}

	public synchronized Object removeFromEnd() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException(name);
		Object removeItem = lastNode.data;
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else {
			ListNode pNode, qNode;
			pNode = qNode = firstNode;
			while (pNode != lastNode) {
				qNode = pNode;
				pNode = pNode.getNext();
			}
			lastNode = qNode;
			qNode.nextNode = null;
			pNode = null;
		}
		return removeItem;
	}

	public synchronized boolean isEmpty() {
		return firstNode == null;
	}

	public synchronized void print() {
		if (isEmpty()) {
			System.out.println("Empty " + name);
			return;
		}
		ListNode currentNode = firstNode;
		System.out.print("List " + name + " : ");
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println("");
	}
}
