import javax.swing.*;

public class RollDie {
	public static void main(String args[]) {
		int frequency[] = new int[7];
		for(int roll = 1; roll <= 6000; roll++) {
			frequency[1+(int)(Math.random()*6)]++;  
		}
		String output = "Face\tFrequency\n";
		for(int face = 1; face < frequency.length; face++) {
			output += face + "\t" + frequency[face] + "\n";
		}
		JTextArea outputArea = new JTextArea();
		outputArea.setText(output);
		JOptionPane.showMessageDialog(null, outputArea, "Rolling a Die 6000 Times", JOptionPane.INFORMATION_MESSAGE);
	}
}
