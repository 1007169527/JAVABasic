
//P228
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JTextArea;

public class Init2dArray extends JApplet {
	JTextArea outputArea;

	public void init() {
		outputArea = new JTextArea();
		Container container = getContentPane();
		container.add(outputArea);
		int array1[][] = { { 1, 2, 3 }, { 4, 5, 6, } };
		int array2[][] = { { 1, 2 }, { 3 }, { 4, 5, 6 } };
		int array3[][] = new int[3][];
		array3[0] = new int[1];
		array3[1] = new int[2];
		array3[2] = new int[3];
		array3[0][0] = 1;
		array3[1][0] = 2;
		array3[1][1] = 3;
		array3[2][0] = 4;
		array3[2][1] = 5;
		array3[2][2] = 6;
		outputArea.setText("Values in array1 by row are\n");
		buildOutput(array1);
		outputArea.append("Values in array2 by row are\n");
		buildOutput(array2);
		outputArea.append("Values in array3 by row are\n");
		buildOutput(array3);
	}

	public void buildOutput(int array[][]) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				outputArea.append(array[row][column] + " ");
			}
			outputArea.append("\n");
		}
	}

}
