
//P848
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetTest {
	private static final String colors[] = { "red", "white", "blue", "green", "gray", "orange", "tan", "white", "cyan",
			"peach", "gray", "orange" };

	public SetTest() {
		// TODO Auto-generated constructor stub
		List list = new ArrayList<String>(Arrays.asList(colors));
		System.out.println("ArrayList: " + list);
		printNonDuplicates(list);
	}

	private void printNonDuplicates(Collection collection) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>(collection);
		Iterator iterator = set.iterator();
		System.out.print("NonDuplicates are: ");
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		new SetTest();
	}
}
