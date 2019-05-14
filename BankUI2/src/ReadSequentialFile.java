import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReadSequentialFile extends JFrame {
	private ObjectInputStream input;
	private BankUI userInterface;
	private JButton nextButton, openButton;

	public ReadSequentialFile() {
		// TODO Auto-generated constructor stub
		super("Reading a Sequential File of Object");
		userInterface = new BankUI(4);
		getContentPane().add(userInterface, BorderLayout.CENTER);
		openButton = userInterface.getDoTask1Button();
		openButton.setText("Open File");
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});

		nextButton = userInterface.getDoTask2Button();
		nextButton.setText("Next Record");
		nextButton.setEnabled(false);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readRecord();
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				if (input != null) {
					closeFile();
				}
				System.exit(0);
			}
		});

		pack();
		setSize(300, 200);
		setVisible(true);
	}

	protected void readRecord() {
		// TODO Auto-generated method stub
		AccountRecord record;
		try {
			record = (AccountRecord) input.readObject();
			String values[] = { String.valueOf(record.getAccount()), String.valueOf(record.getFirstName()),
					String.valueOf(record.getLastName()), String.valueOf(record.getBalance()) };
			userInterface.setFieldValues(values);
		} catch (EOFException e) {
			// TODO: handle exception
			nextButton.setEnabled(false);
			JOptionPane.showMessageDialog(this, "No more records in file");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Class not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error during read from file");
		}
	}

	private void openFile() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);

		if (result == JFileChooser.CANCEL_OPTION)
			return;
		File fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name");
		else {
			try {
				input = new ObjectInputStream(new FileInputStream(fileName));
				openButton.setEnabled(false);
				nextButton.setEnabled(true);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error Opening File");
			}
		}
	}

	private void closeFile() {
		// TODO Auto-generated method stub
		try {
			input.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error closing file");
			System.exit(1);
		}
	}

	public static void main(String args[]) {
		new ReadSequentialFile();
	}
}
