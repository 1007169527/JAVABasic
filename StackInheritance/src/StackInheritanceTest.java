
public class StackInheritanceTest {
	public static void main(String[] args) {
		StackInheritance stack = new StackInheritance();
		Boolean bool = Boolean.TRUE;
		Character character = new Character('$');
		Integer integer = new Integer(3456);
		String string = "hello";

		stack.push(bool);
		stack.print();
		stack.push(character);
		stack.print();
		stack.push(integer);
		stack.print();
		stack.push(string);
		stack.print();

		try {
			Object removeItem = null;
			while (true) {
				removeItem = stack.pop();
				System.out.println(removeItem.toString() + " popped");
				stack.print();
			}

		} catch (EmptyListException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
