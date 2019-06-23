
//P837
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	private static final String colors[] = { "black", "yellow", "green", "blue", "violet", "silver" };
	private static final String colors2[] = { "gold", "white", "brown", "blue", "gray", "silver" };

	public ListTest() {
		// TODO Auto-generated constructor stub
		List link = new LinkedList();
		List link2 = new LinkedList();

		for (int count = 0; count < colors.length; count++) {
			link.add(colors[count]);
			link2.add(colors2[count]);
		}

		link.addAll(link2);
		link2 = null;

		printList(link);

		uppercaseStrings(link);

		printList(link);

		System.out.print("\nDeleting elements 4 to 6... (begin at index 0) ");

		removeItems(link, 4, 7);

		printList(link);

		printReversedList(link);
	}

	private void printList(List list) {
		// TODO Auto-generated method stub
		System.out.print("\nList: ");

		for (int count = 0; count < list.size(); count++)
			System.out.print(list.get(count) + " ");

		System.out.println();
	}

	private void uppercaseStrings(List list) {
		// TODO Auto-generated method stub
		ListIterator iterator = list.listIterator();

		while (iterator.hasNext()) {
			Object object = iterator.next();

			if (object instanceof String)
				iterator.set(((String) object).toUpperCase());
		}
	}

	private void removeItems(List list, int start, int end) {
		// TODO Auto-generated method stub
		list.subList(start, end).clear();
	}

	private void printReversedList(List list) {
		// TODO Auto-generated method stub
		ListIterator iterator = list.listIterator(list.size());

		System.out.print("\nReserversed List: ");

		while (iterator.hasPrevious()) {
			Object object = iterator.previous();
			if (object instanceof String)
				System.out.print(object + " ");
		}
	}

	public static void main(String[] args) {
		new ListTest();
	}
}
