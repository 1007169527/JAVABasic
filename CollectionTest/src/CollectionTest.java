
//836
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
	private static final String colors[] = { "red", "white", "blue" };

	public CollectionTest() {
		// TODO Auto-generated constructor stub
		List list = new ArrayList();
		list.add(Color.MAGENTA);

		for (int count = 0; count < colors.length; count++)
			list.add(colors[count]);

		list.add(Color.CYAN);

		System.out.println("\nArrayList: ");

		for (int count = 0; count < list.size(); count++)
			System.out.print(list.get(count) + " ");

		removeStrings(list);

		System.out.println("\nArrayList after calling removeStrings: ");

		for (int count = 0; count < list.size(); count++)
			System.out.print(list.get(count) + " ");
	}

	private void removeStrings(Collection collection) {
		// TODO Auto-generated method stub
		Iterator iterator = collection.iterator();
		while (iterator.hasNext())
			if (iterator.next() instanceof String)
				iterator.remove();
	}

	public static void main(String[] args) {
		new CollectionTest();
	}
}
