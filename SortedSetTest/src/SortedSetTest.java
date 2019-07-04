
//P849
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	private static final String colors[] = { "yellow", "green", "black", "tan", "grey", "white", "orange", "red",
			"green" };

	public SortedSetTest() {
		// TODO Auto-generated constructor stub
		SortedSet<String> tree = new TreeSet<String>(Arrays.asList(colors));

		System.out.println("set: ");
		printSet(tree);

		System.out.println("\nhead set orange:");
		printSet(tree.headSet("orange"));

		System.out.println("\ntail set orange:");
		printSet(tree.tailSet("orange"));

		System.out.println("\nfirst: " + tree.first());
		System.out.println("\nlast: " + tree.last());
	}

	private void printSet(SortedSet<String> tree) {
		// TODO Auto-generated method stub
		Iterator<String> iterator = tree.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		new SortedSetTest();
	}
}
