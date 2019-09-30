import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class XmlTool extends JFrame {
	File inputFile, outputFile;
	private RandomAccessFile randomReadAccessFile;
	private RandomAccessFile randomWriteAccessFile;
	StringBuffer stringBuffer = new StringBuffer("");

	TestAtom testAtom = new TestAtom();

	public XmlTool() {
		// TODO Auto-generated constructor stub
		openFile();
		praseFile();
	}

	protected void openFile() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION)
			return;
		inputFile = fileChooser.getSelectedFile();
		if (inputFile == null || inputFile.equals("")) {
			JOptionPane.showMessageDialog(this, "Invaild File Name");
		} else {
			outputFile = new File(inputFile.getParent() + "/result.xml");
			if (!outputFile.delete()) {
				System.out.println("Delete" + outputFile + "failed !!!");
			}
			outputFile = new File(inputFile.getParent() + "/result.xml");
		}
	}

	protected void praseFile() {
		String orgString = "";
		int count = 0;
		try {
			randomReadAccessFile = new RandomAccessFile(inputFile, "r");
			randomWriteAccessFile = new RandomAccessFile(outputFile, "rw");
			while (true) {
				orgString = randomReadAccessFile.readLine();
				if (orgString == null)
					break;
				else {
					randomWriteAccessFile.writeBytes(testAtom.praseFile(orgString));
				}
			}
			randomReadAccessFile.close();
			randomWriteAccessFile.close();
		} catch (Exception e) {
			System.out.println("Why here?");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		XmlTool fileReadWriteTest = new XmlTool();
		System.out.println("All done");
		fileReadWriteTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.exit(0);
	}
}
