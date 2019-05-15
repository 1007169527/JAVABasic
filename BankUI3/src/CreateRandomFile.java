
//P642
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CreateRandomFile {

	private static final int NUMBER_RECORDS = 100;

	public void createFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
			return;
		File fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(null, "Invalid File Name");
		else {
			try {
				RandomAccessFile file = new RandomAccessFile(fileName, "rw");
				RandomAccessAccountRecord blankRecord = new RandomAccessAccountRecord();
				for (int count = 0; count < NUMBER_RECORDS; count++) {
					blankRecord.write(file);
				}
				file.close();
				JOptionPane.showMessageDialog(null, "Create File " + fileName);
				System.exit(0);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error Creating File");
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		CreateRandomFile createRandomFile = new CreateRandomFile();
		createRandomFile.createFile();
	}
}
