
//P803
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorTest {
	private static final String colors[] = { "red", "white", "blue" };

	public VectorTest() {
		// TODO Auto-generated constructor stub
		Vector vector = new Vector();
		printVector(vector);
		vector.add("megenta");
		for (int count = 0; count < colors.length; count++) {
			vector.add(colors[count]);
		}

		vector.add("cyan");
		printVector(vector);

		try {
			System.out.println("First element: " + vector.firstElement());
			System.out.println("Last element: " + vector.lastElement());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (vector.contains("red"))
			System.out.println("\n\"red\" found at index " + vector.indexOf("red") + "\n");
		else
			System.out.println("\n\"red\" not found");

		vector.remove("cyan");
		System.out.println("\"cyan\" removed");
		printVector(vector);

		if (vector.contains("cyan"))
			System.out.println("\"cyan\" found at index " + vector.indexOf("cyan"));
		else
			System.out.println("\"cyan\" not found");

		System.out.println("\nSize: " + vector.size() + " Capacity: " + vector.capacity());
	}

	private void printVector(Vector vectorToOutput) {
		// TODO Auto-generated method stub
		if (vectorToOutput.isEmpty())
			System.out.println("Vector is empty");
		else {
			System.out.println("Vector contains: ");
			Enumeration items = vectorToOutput.elements();
			while (items.hasMoreElements()) {
				System.out.print(items.nextElement() + " ");
			}
		}
		System.out.println("\n");
	}

	public static void main(String args[]) {
		new VectorTest();
	}
}
