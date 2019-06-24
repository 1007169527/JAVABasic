
//P840
import java.util.Arrays;
import java.util.LinkedList;

public class UsingArray {
	public UsingArray() {
		// TODO Auto-generated constructor stub
		String colors[] = { "black", "blue", "yellow" };
		LinkedList<String> links = new LinkedList<String>(Arrays.asList(colors));
		links.addLast("red");
		links.add("pink");
		links.add(3, "green");
		links.addFirst("cyan");

		colors = (String[]) links.toArray(new String[links.size()]);

		System.out.println("colors is: ");
		for (int count = 0; count < colors.length; count++)
			System.out.println(colors[count]);

	}

	public static void main(String[] args) {
		new UsingArray();
	}
}
