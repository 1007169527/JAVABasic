
//P806
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Stack;

public class StackTest {
	public StackTest() {
		// TODO Auto-generated constructor stub
		Stack stack = new Stack();
		Boolean bool = Boolean.TRUE;
		Character character = '@';
		Integer integer = 2345;
		String string = "hello";

		stack.push(bool);
		printStack(stack);
		stack.push(character);
		printStack(stack);
		stack.push(integer);
		printStack(stack);
		stack.push(string);
		printStack(stack);

		try {
			Object removeObject = null;
			while (true) {
				removeObject = stack.pop();
				System.out.print(removeObject.toString() + " popped. ");
				printStack(stack);
			}
		} catch (EmptyStackException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void printStack(Stack stack) {
		// TODO Auto-generated method stub
		if (stack.isEmpty())
			System.out.print("Stack is empty");
		else {
			System.out.print("stack contains: ");
			Enumeration items = stack.elements();
			while (items.hasMoreElements())
				System.out.print(items.nextElement() + " ");
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		new StackTest();
	}
}
