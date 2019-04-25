import javax.swing.JOptionPane;

public class StringTest {
	public static void main(String args[]) {
		// P374 length charAt getChars
		String string = "hello here";
		char charArray[] = new char[5];
		String output = "string: " + string;
		output += "\nLengthof string: " + string.length();
		output += "\nThe string reversed is: ";
		for (int count = string.length() - 1; count >= 0; count--) {
			output += string.charAt(count) + " ";
		}
		string.getChars(0, 5, charArray, 0);
		output += "\nThe charArray is: ";
		for (int count = 0; count < charArray.length; count++) {
			output += charArray[count];
		}
		output += "\n\n";

		// P375 equals == equalsIgnoreCase compareTo regionMatches
		String s1 = new String("hello");
		String s2 = "goodbye";
		String s3 = "happy birthday";
		String s4 = "Happy Birthday";
		if (s1.equals("hello"))
			output += "s1 equals \"hello\"\n";
		else
			output += "s1 does not equal \"hello\"\n";
		if (s1 == "hello")
			output += "s1 and \"hello\" are the same object\n";
		else
			output += "s1 and \"hello\" are not the same object\n";
		if (s3.equalsIgnoreCase(s4))
			output += "s3 equals s4 when you ignore the case\n";
		else
			output += "s3 does not equal s4 even if you ignore the case\n";
		output += "s1.compareTo(s2) is " + s1.compareTo(s2) + "\n";
		output += "s2.compareTo(s1) is " + s2.compareTo(s1) + "\n";
		if (s3.regionMatches(0, s4, 0, 5))
			output += "The first five chars are same in s3 and s4\n";
		else
			output += "The first five chars are not same in s3 and s4\n";
		if (s3.regionMatches(true, 0, s4, 0, 5))
			output += "The first five chars are same in s3 and s4 when you ignore the case\n";
		else
			output += "The first five chars are not same in s3 and s4 when you ignore the case\n";
		output += "\n";

		// P377 startWith endWith
		String strings[] = { "started", "starting", "ended", "ending" };
		for (int count = 0; count < strings.length; count++) {
			if (strings[count].startsWith("st"))
				output += "strings[" + count + "] start with \"st\"\n";
			if (strings[count].startsWith("art", 2))
				output += "strings[" + count + "] start with \"art\" at the 2nd char [0] [1] [2]\n";
			if (strings[count].endsWith("ed"))
				output += "strings[" + count + "] end with \"ed\"\n";
		}
		output += "\n";

		JOptionPane.showMessageDialog(null, output); // cut this line to where you want;

		System.exit(0);
	}
}
