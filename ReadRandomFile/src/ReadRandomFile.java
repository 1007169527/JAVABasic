import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReadRandomFile extends JFrame {
	private BankUI userInterface;
	private RandomAccessFile input;
	private JButton nextButton, openButton;

	private static DecimalFormat twoDigits = new DecimalFormat("0.00");

	public ReadRandomFile() {
		// TODO Auto-generated constructor stub
		super("Read Client File");
		userInterface = new BankUI(4);
		getContentPane().add(userInterface, BorderLayout.CENTER);
		openButton = userInterface.getDoTask1Button();
		openButton.setText("Open ...");
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openFile();
			}
		});

		nextButton = userInterface.getDoTask2Button();
		nextButton.setText("Next");
		nextButton.setEnabled(false);

		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				readRecord();
			}
		});

		addWindowListener(new WindowAdapter() {
			public void closingWindow(WindowEvent event) {
				closeFile();
			}
		});

		setSize(300, 150);
		setVisible(true);
	}

	protected void closeFile() {
		// TODO Auto-generated method stub
		try {
			if (input != null)
				input.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error closing file");
			System.exit(1);
		}
	}

	protected void readRecord() {
		// TODO Auto-generated method stub
		RandomAccessAccountRecord record = new RandomAccessAccountRecord();
		try {
			do {
				record.read(input);
			} while (record.getAccount() == 0);
			String values[] = { String.valueOf(record.getAccount()), record.getFirstName(), record.getLastName(),
					String.valueOf(record.getBalance()) };
			userInterface.setFieldValues(values);
		} catch (EOFException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "No more record");
			closeFile();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error reading file");
			System.exit(1);
		}
	}

	protected void openFile() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION)
			return;
		File fileName = fileChooser.getSelectedFile();
		if (fileName == null || fileName.equals("")) {
			JOptionPane.showMessageDialog(this, "Invaild File Name");
		} else {
			try {
				input = new RandomAccessFile(fileName, "r");
				nextButton.setEnabled(true);
				openButton.setEnabled(false);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "File does not exist");
			}
		}
	}

	public static void main(String[] args) {
		new ReadRandomFile();
	}
}
