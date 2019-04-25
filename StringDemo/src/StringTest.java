
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class StringTest extends JFrame {
	private JTextArea outputArea;
	private ScrollPane scrollPane;
	private Container container;
	private String output;

	public StringTest() {
		outputArea = new JTextArea();
		scrollPane = new ScrollPane();
		scrollPane.add(outputArea);
		container = getContentPane();
		container.add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
		displayFunctions();
		outputArea.append(output);
	}

	public void displayFunctions() {
		// P374 length charAt getChars
		String string = "hello here , The string index alaways begin at 0";
		char charArray[] = new char[5];
		output += "string: " + string;
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
		output += "s1 " + s1 + " s2 " + s2 + "\n";
		output += "s3 " + s3 + " s4 " + s4 + "\n";
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
			output += "strings[" + count + "] is \"" + strings[count] + "\"\n";
			if (strings[count].startsWith("st"))
				output += "strings[" + count + "] start with \"st\"\n";
			if (strings[count].startsWith("art", 2))
				output += "strings[" + count + "] start with \"art\" at the 2nd char\n";
			if (strings[count].endsWith("ed"))
				output += "strings[" + count + "] end with \"ed\"\n";
		}
		output += "\n";

		// P378 indexOf lastIndexOf
		String letters = "abcdefghijklmnopqrstuvwxyzabcdefgabcdefg";
		output += "letters is " + letters + "\n";
		output += "c is located at index: " + letters.indexOf('c') + "\n";
		output += "After the first char, a is located at index: " + letters.indexOf('a', 1) + "\n";
		output += "last c is located at index: " + letters.lastIndexOf('c') + "\n";
		output += "After the 30th char, last a is located at index: " + letters.lastIndexOf('a', 30) + "\n";
		output += "Last '$' is located at index: " + letters.lastIndexOf('$') + "\n";
		output += "\"def\" is located at index: " + letters.indexOf("def") + "\n";
		output += "After the 26th char, \"def\" is located at index: " + letters.indexOf("def", 26) + "\n";
		output += "\"hello\" is located at index: " + letters.indexOf("hello") + "\n";
		output += "After the 26th char, \"hello\" is located at index: " + letters.indexOf("hello", 26) + "\n";
		output += "The last \"def\" is located at index: " + letters.lastIndexOf("def") + "\n";
		output += "After the 26th char, the last \"def\" is located at index: " + letters.lastIndexOf("def", 26) + "\n";
		output += "The last \"hello\" is located at index: " + letters.lastIndexOf("hello") + "\n";
		output += "After the 26th char, the last \"hello\" is located at index: " + letters.lastIndexOf("hello", 26)
				+ "\n";
		output += "\n";

		// P380 subString
		String letters1 = "abcdefghijklmnopqrstuvwxyzabcdefgabcdefg";
		output += "letters1 is " + letters1 + "\n";
		output += "SubString from index 20 to end is " + "\"" + letters1.substring(20) + "\"\n";
		output += "SubString from index 20 to 30 is " + "\"" + letters1.substring(20, 30) + "\"\n";

		// P380 concat +
		s1 = "Hello";
		s2 = "World";
		output += "s1 " + s1 + " s2 " + s2 + "\n";
		output += "s1.concat(s2) returns " + s1.concat(s2) + "\n";
		output += "s1 + s2 returns " + s1 + s2 + "\n";
		output += "\n";

		// P380 replace toUpCase toLowCase trim
		s1 = "hello man";
		s2 = "GOODBYE";
		s3 = " space ";
		output += "s1 " + s1 + " s2 " + s2 + " s3 " + s3 + "\n";
		output += "Replace 'l' with 'L' in s1: " + s1.replace('l', 'L') + "\n";
		output += "s1.toUpCase() returns " + s1.toUpperCase() + "\n";
		output += "2.toLowCase() returns " + s2.toLowerCase() + "\n";
		output += "s3 after trim returns " + s3.trim() + "\n";
		charArray = s1.toCharArray();
		output += "we init char charArray[] with new char[5], but it seems work as char[9] !!!!!!\n";
		for (int count = 0; count < charArray.length; count++) {
			output += charArray[count];
		}
		output += "\n";

		// P383 valueOf
		boolean booleanValue = true;
		char characterValue = 'Z';
		int integerValue = 7;
		long longValue = 10000000L;
		float floatValue = 22.5f;
		double doubleValue = 33.333;
		Object objectRef = "hello";
		output += "char array = " + String.valueOf(charArray) + "\n";
		output += "boolean = " + String.valueOf(booleanValue) + "\n";
		output += "character = " + String.valueOf(characterValue) + "\n";
		output += "integ = " + String.valueOf(integerValue) + "\n";
		output += "long = " + String.valueOf(longValue) + "\n";
		output += "float = " + String.valueOf(floatValue) + "\n";
		output += "double = " + String.valueOf(doubleValue) + "\n";
		output += "object = " + String.valueOf(objectRef) + "\n";
		output += "\n";
	}

	public static void main(String args[]) {
		StringTest application = new StringTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
