
//P220
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JTextArea;

public class BubbleSort extends JApplet {
	public void init() {
		JTextArea outputArea = new JTextArea();
		Container container = getContentPane();
		container.add(outputArea);
		int array[] = { 10, 3, 2, 5, 7, 4, 1, 9, 6, 8 };

		String output = "Data items in original order\n";
		for (int counter = 0; counter < array.length; counter++) {
			output += counter + "\t" + array[counter] + "\n";
		}

		bubbleSort(array);

		output += "\nAfter BubbleSort\n";
		for (int counter = 0; counter < array.length; counter++) {
			output += counter + "\t" + array[counter] + "\n";
		}
		outputArea.setText(output);
	}

	public void bubbleSort(int array[]) {
		for (int loop = 0; loop < array.length - 1; loop++) {
			for (int counter = 0; counter < array.length - 1; counter++) {
				if (array[counter] < array[counter + 1])
					swap(array, counter);
			}
		}
	}

	public void swap(int array[], int counter) {
		int tmp = array[counter];
		array[counter] = array[counter + 1];
		array[counter + 1] = tmp;
	}
}
