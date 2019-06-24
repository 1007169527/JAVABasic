
//P841
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort1 {
	private static final String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

	public void printElements() {
		List<String> list = new ArrayList<String>(Arrays.asList(suits));
		System.out.println("Unsorted array elements: " + list);
		Collections.sort(list);
		System.out.println("Sorted array elements: " + list);
	}

	public static void main(String[] args) {
		new Sort1().printElements();
	}
}
