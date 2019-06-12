import java.util.Arrays;
import java.util.List;

public class UsingAsList {
	private static final String values[] = { "red", "white", "blue" };
	private List list;

	public UsingAsList() {
		// TODO Auto-generated constructor stub
		list = Arrays.asList(values);
		list.set(1, "green");
	}

	public void printElments() {
		System.out.print("List elements: ");
		for (int count = 0; count < list.size(); count++)
			System.out.print(list.get(count) + " ");
		System.out.print("\nArray element: ");
		for (int count = 0; count < values.length; count++)
			System.out.print(values[count] + " ");
	}

	public static void main(String[] args) {
		new UsingAsList().printElments();
	}
}
