
//P644
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WriteRandomFile extends JFrame {
	private RandomAccessFile output;
	private BankUI userInterface;
	private JButton enterButton, openButton;

	private final int NUMBER_RECORD = 100;

	public WriteRandomFile() {
		// TODO Auto-generated constructor stub
		super("Write Random File");
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

		addWindowFocusListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				if (output != null)
					addRecord();
				closeFile();
			}
		});

		enterButton = userInterface.getDoTask2Button();
		enterButton.setText("Enter");
		enterButton.setEnabled(false);
		enterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addRecord();
			}
		});
		setSize(300, 150);
		setVisible(true);
	}

	protected void closeFile() {
		// TODO Auto-generated method stub
		try {
			if (output != null)
				output.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error closing file");
			System.exit(1);
		}
	}

	protected void addRecord() {
		// TODO Auto-generated method stub
		int accountNumber = 0;
		String fields[] = userInterface.getFieldValues();
		RandomAccessAccountRecord record = new RandomAccessAccountRecord();
		if (!fields[BankUI.ACCOUNT].equals("")) {
			try {
				accountNumber = Integer.parseInt(fields[BankUI.ACCOUNT]);
				if (accountNumber > 0 && accountNumber < NUMBER_RECORD) {
					record.setAccount(accountNumber);
					record.setFirstName(fields[BankUI.FIRSTNAME]);
					record.setLastName(fields[BankUI.LASTNAME]);
					record.setBalance(Double.parseDouble(fields[BankUI.BALANCE]));
					output.seek((accountNumber - 1) * RandomAccessAccountRecord.SIZE);
					record.write(output);
				} else {
					JOptionPane.showMessageDialog(this, "Invaild accountNumber");
				}
				userInterface.clearFields();
			} catch (NumberFormatException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Bad account number of accountNumber or balance");
			} catch (IOException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error write to file");
				closeFile();
			}
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
		if (fileName == null || fileName.equals(""))
			JOptionPane.showMessageDialog(this, "Invaild file name");
		else {
			try {
				output = new RandomAccessFile(fileName, "rw");
				enterButton.setEnabled(true);
				openButton.setEnabled(false);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "File does not exist");
			}
		}
	}

	public static void main(String[] args) {
		WriteRandomFile writeRandomFile = new WriteRandomFile();
	}
}
