
//P847
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	private static final String colors[] = { "red", "white", "blue", "black", "yellow", "purple", "tan", "pink" };
	private List list;

	public BinarySearch() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<String>(Arrays.asList(colors));
		Collections.sort(list);
		System.out.println("Sorted list is: " + list);
	}

	private void printSearchResults() {
		printSearchResultsHelper(colors[3]);
		printSearchResultsHelper(colors[0]);
		printSearchResultsHelper(colors[7]);
		printSearchResultsHelper("aardvark");
		printSearchResultsHelper("goat");
		printSearchResultsHelper("zebra");
	}

	private void printSearchResultsHelper(String key) {
		int result = 0;
		System.out.println("Search for " + key);
		result = Collections.binarySearch(list, key);
		System.out.println(result >= 0 ? "Found at index " + result : "Not Found " + result);
	}

	public static void main(String[] args) {
		new BinarySearch().printSearchResults();
	}
}
