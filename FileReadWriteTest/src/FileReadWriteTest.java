import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

import javax.swing.JFrame;

public class FileReadWriteTest extends JFrame {
	File inputFile, outputFile;
	FileInputStream iFStream;
	FileOutputStream oFStream;
	RandomAccessFile randomAccessFile;

	public FileReadWriteTest() {
		// TODO Auto-generated constructor stub
		try {
			outputFile = new File("testFile");
			inputFile = new File("testFile");
			if (!outputFile.exists())
				System.out.println("testFile does not exist");
			oFStream = new FileOutputStream(outputFile);
			if (outputFile.exists())
				System.out.println("testFile exists Now");
			System.out.println("Call getPath returns: " + outputFile.getParent());
			System.out.println("Call getAbsolutePath returns: " + outputFile.getAbsolutePath());
			String testString = "Hello world !\nMy name is GCP !\nNow I am learning JAVA !\n";
			byte[] byteBuffer = testString.getBytes();
			oFStream.write(byteBuffer);
			oFStream.flush();
			oFStream.close();
			randomAccessFile = new RandomAccessFile(inputFile, "r");
			StringBuffer stringBuffer = new StringBuffer("File content is:\n");
			String orgString;
			while (true) {
				try {
					orgString = randomAccessFile.readLine();
					if (orgString == null)
						break;
					else
						stringBuffer.append(orgString + "\n");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					break;
				}
			}
			randomAccessFile.close();
			System.out.println(stringBuffer);
			//
			// inputFile.delete();
			// iFStream = new FileInputStream(inputFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		FileReadWriteTest fileReadWriteTest = new FileReadWriteTest();
	}

}
