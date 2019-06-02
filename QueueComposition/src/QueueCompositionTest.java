
public class QueueCompositionTest {
	public static void main(String[] args) {
		QueueComposition stack = new QueueComposition();
		Boolean bool = Boolean.TRUE;
		Character character = new Character('$');
		Integer integer = new Integer(3456);
		String string = "hello";

		stack.enqueue(bool);
		stack.print();
		stack.enqueue(character);
		stack.print();
		stack.enqueue(integer);
		stack.print();
		stack.enqueue(string);
		stack.print();

		try {
			Object removeItem = null;
			while (true) {
				removeItem = stack.dequeue();
				System.out.println(removeItem.toString() + " popped");
				stack.print();
			}

		} catch (EmptyListException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
