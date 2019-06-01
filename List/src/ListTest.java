//P711
public class ListTest {

	public static void main(String[] args) {
		List list = new List("list1");
		Boolean bool = Boolean.FALSE;
		Character character = new Character('$');
		Integer integer = new Integer(3456);
		String string = new String("hello");
		list.insertAtFront(bool);
		list.print();
		list.insertAtFront(character);
		list.print();
		list.insertAtEnd(integer);
		list.print();
		list.insertAtEnd(string);
		list.print();
		try {
			Object removeItem = list.removeFromFront();
			System.out.println(removeItem.toString() + " removed");
			list.print();
			removeItem = list.removeFromFront();
			System.out.println(removeItem.toString() + " removed");
			list.print();
			removeItem = list.removeFromEnd();
			System.out.println(removeItem.toString() + " removed");
			list.print();
			removeItem = list.removeFromEnd();
			System.out.println(removeItem.toString() + " removed");
			list.print();
		} catch (EmptyListException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
