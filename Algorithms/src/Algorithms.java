
//P845
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms {
	private String letters[] = { "F", "C", "M" }, lettersCopy[];
	private List list, copyList;

	public Algorithms() {
		// TODO Auto-generated constructor stub
		list = Arrays.asList(letters);
		lettersCopy = new String[3];
		copyList = Arrays.asList(lettersCopy);

		System.out.println("Initial List:");
		output(list);

		Collections.reverse(list);
		System.out.println("\nAfter calling reverse:");
		output(list);

		Collections.copy(copyList, list);
		System.out.println("\nAfter call copy:");
		output(copyList);

		Collections.fill(list, "R");
		System.out.println("\nAfter call fill:");
		output(list);
	}

	private void output(List listRef) {
		// TODO Auto-generated method stub
		System.out.print("The list is: ");
		for (int k = 0; k < listRef.size(); k++)
			System.out.print(listRef.get(k) + " ");

		System.out.print("     Max: " + Collections.max(listRef));
		System.out.print("  Min: " + Collections.min(listRef));
	}

	public static void main(String[] args) {
		new Algorithms();
	}
}
