import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateSequentialFile extends JFrame {
	private ObjectOutput output;
	private BankUI userInterface;
	private JButton enterButton, openButton;

	public CreateSequentialFile() {
		// TODO Auto-generated constructor stub
		super("Creating a Sequential File of Objects");
		userInterface = new BankUI(4);
		getContentPane().add(userInterface, BorderLayout.CENTER);
		openButton = userInterface.getDoTask1Button();
		openButton.setText("Save into File ...");
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openFile();
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

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				if (output != null) {
					addRecord();
				}
				closeFile();
			}
		});

		setSize(300, 200);
		setVisible(true);
	}

	private void openFile() {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showSaveDialog(this);

		if (result == JFileChooser.CANCEL_OPTION)
			return;

		File fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
		else {
			try {
				output = new ObjectOutputStream(new FileOutputStream(fileName));
				openButton.setEnabled(false);
				enterButton.setEnabled(true);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error Opening File", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void closeFile() {
		// TODO Auto-generated method stub
		try {
			output.close();
			System.exit(0);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error Closing File", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	private void addRecord() {
		// TODO Auto-generated method stub
		int accountNumber = 0;
		AccountRecord record;
		String fieldValues[] = userInterface.getFieldValues();

		if (!fieldValues[BankUI.ACCOUNT].equals("")) {
			try {
				accountNumber = Integer.parseInt(fieldValues[BankUI.ACCOUNT]);
				if (accountNumber > 0) {
					record = new AccountRecord(accountNumber, fieldValues[BankUI.FIRSTNAME],
							fieldValues[BankUI.LASTNAME], Double.parseDouble(fieldValues[BankUI.BALANCE]));
					output.writeObject(record);
					output.flush();
				} else {
					JOptionPane.showMessageDialog(this, "Account number must be greater than 0", "Bad account number",
							JOptionPane.ERROR_MESSAGE);
				}
				userInterface.clearFields();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Bad account number or ba;ance", "IO Exception",
						JOptionPane.ERROR_MESSAGE);
				closeFile();
			}
		}
	}

	public static void main(String[] args) {
		new CreateSequentialFile();
	}
}
