import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FileSystem extends JFrame implements ActionListener {
	private JTextField mEnterField;
	private JTextArea mOutputArea;

	public FileSystem() {
		super("A demo for FileSystem");
		mEnterField = new JTextField("Enter file or directory name here");
		mEnterField.addActionListener(this);
		mOutputArea = new JTextArea();

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(mOutputArea);

		Container container = getContentPane();
		container.add(mEnterField, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.CENTER);

		setSize(400, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		File file = new File(actionEvent.getActionCommand());
		if (file.exists()) {
			mOutputArea.setText(file.getName() + (file.isDirectory() ? " is a directory" : " is not a directory\n")
					+ "\n" + (file.isAbsolute() ? "it's a absolute path" : ",it's not a absolute path\n") + "\n"
					+ "Length: " + file.length() + "\n" + "Path:" + file.getPath() + "\n" + "Absolute Path"
					+ file.getAbsolutePath() + "\n" + "Last modified:" + file.lastModified());
		}

		if (file.isFile()) {
			try {
				BufferedReader input = new BufferedReader(new FileReader(file));
				StringBuffer buffer = new StringBuffer();
				String text;
				mOutputArea.append("\n\nFile contents:\n");
				while ((text = input.readLine()) != null) {
					buffer.append(text + "\n");
				}
				mOutputArea.append(buffer.toString());
			} catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "FILE ERROR", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else if (file.isDirectory()) {
			String directory[] = file.list();
			mOutputArea.append("\n\nDirectory contents:\n");
			for (int i = 0; i < directory.length; i++) {
				mOutputArea.append(directory[i] + "\n");
			}
		} else {
			JOptionPane.showMessageDialog(this, actionEvent.getActionCommand() + "does not exist", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	} // end actionPerformed

	public static void main(String args[]) {
		FileSystem application = new FileSystem();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
