import java.awt.Container;
import javax.swing.*;

public class PassArray extends JApplet {
	public void init() {
		JTextArea outputArea = new JTextArea();
		Container container = getContentPane();
		container.add(outputArea);
		
		int array[] = { 1, 2, 3, 4, 5 };
		String output = "Effects of passing array by reference\n";
		output += "Before function\n";
		for(int counter=0;counter < array.length;counter++)
			output += " " + array[counter];
		modifyArray(array);
		output += "\nAfter function\n";
		for(int counter=0;counter < array.length;counter++)
			output += " " + array[counter];
		
		output += "\n\nEffects of passing array element by value\n";
		output += "Before function\n";
		output += "array[2] = " + array[2] + "\n";
		modifyElement(array[2]);
		output += "After function\n";
		output += "array[2] = " + array[2] + "\n";
		
		outputArea.setText(output);
	}
	
	//pass the value of the Array' reference to the function
	public void modifyArray(int array[]) {
		for(int counter=0;counter < array.length;counter++) {
			array[counter] = array[counter] * 2;
		}
	}
	
	//pass value to the function
	public void modifyElement(int element) {
		element = element * 2;
	}
}
