import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class StringBufferTest extends JFrame {
	private JTextArea outputArea;
	private ScrollPane scrollPane;
	private Container container;
	private String output = "";

	public StringBufferTest() {
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
		// P384 constructor
		StringBuffer buffer1 = new StringBuffer();
		StringBuffer buffer2 = new StringBuffer(10);
		StringBuffer buffer3 = new StringBuffer("hello");
		output += "buffer1 is: " + "\"" + buffer1.toString() + "\"" + "\n";
		output += "buffer2 is: " + "\"" + buffer2.toString() + "\"" + "\n";
		output += "buffer3 is: " + "\"" + buffer3.toString() + "\"" + "\n";
		output += "\n";

		// P385 toString length capacity ensureCapacity setLength
		StringBuffer buffer4 = new StringBuffer("Hello, how are you?");
		output += "buffer4 is: " + "\"" + buffer4.toString() + "\"" + "\n";
		output += "buffer4.length() is: " + buffer4.length() + "\n";
		output += "buffer4.capacity() is: " + buffer4.capacity() + "\n";
		buffer4.ensureCapacity(75);
		output += "buffer4.capacity() is: " + buffer4.capacity() + "\n";
		buffer4.setLength(10);
		output += "buffer4.length() is: " + buffer4.length() + "\n";
		output += "\n";

		// P386 charAt getChars setCharAt reverse
		StringBuffer buffer5 = new StringBuffer("hello there");
		output += "buffer5 is: " + "\"" + buffer5.toString() + "\"" + "\n";
		output += "chat at index 4 is: " + buffer5.charAt(4) + "\n";
		char charArray[] = new char[buffer5.length()];
		buffer5.getChars(0, buffer5.length(), charArray, 0);
		output += "The character are: ";
		for (int count = 0; count < charArray.length; count++)
			output += charArray[count] + " ";
		output += "\n";
		buffer5.setCharAt(0, 'H');
		output += "buffer5 is: " + buffer5.toString() + "\n";
		buffer5.reverse();
		output += "buffer5 is: " + buffer5.toString() + "\n";
		output += "\n";

		// P387 append
		Object objectRef = "world";
		String string = "goodbye";
		boolean booleanValue = true;
		char characterValue = 'Z';
		int integerValue = 7;
		long longValue = 10000000L;
		float floatValue = 22.5f;
		double doubleValue = 33.333;
		StringBuffer buffer7 = new StringBuffer("7th StringBuffer");
		StringBuffer buffer6 = new StringBuffer();
		buffer6.append(objectRef);
		buffer6.append("  ");
		buffer6.append(string);
		buffer6.append("  ");
		buffer6.append(charArray);
		buffer6.append("  ");
		buffer6.append(charArray, 0, 3);
		buffer6.append("  ");
		buffer6.append(booleanValue);
		buffer6.append("  ");
		buffer6.append(characterValue);
		buffer6.append("  ");
		buffer6.append(integerValue);
		buffer6.append("  ");
		buffer6.append(longValue);
		buffer6.append("  ");
		buffer6.append(floatValue);
		buffer6.append("  ");
		buffer6.append(doubleValue);
		buffer6.append("  ");
		buffer6.append(buffer7);
		output += buffer6.toString();
		output += "\n";

		// P389
		StringBuffer buffer8 = new StringBuffer();
		buffer8.insert(0, objectRef);
		buffer8.insert(0, "  ");
		buffer8.insert(0, string);
		buffer8.insert(0, charArray);
		buffer8.insert(0, charArray, 3, 3);
		buffer8.insert(0, booleanValue);
		buffer8.insert(0, characterValue);
		buffer8.insert(0, integerValue);
		buffer8.insert(0, longValue);
		buffer8.insert(0, floatValue);
		buffer8.insert(0, doubleValue);
		output += "After insert buffer8 is: " + buffer8.toString() + "\n";
		buffer8.delete(0, 10);
		buffer8.deleteCharAt(0);
		output += "After delete buffer8 is: " + buffer8.toString() + "\n";

	}

	public static void main(String args[]) {
		StringBufferTest application = new StringBufferTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
