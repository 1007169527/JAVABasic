import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransactionProcessor extends JFrame {
	private BankUI userInterface;
	private JMenuItem newItem, updateItem, deleteItem, openItem, exitItem;
	private JTextField fields[];
	private JTextField accountField, transactionField;
	private JButton actionButton, cancelButton;
	private FileEditor dataFile;
	private RandomAccessAccountRecord record;

	public TransactionProcessor() {
		super("Transaction Processor");
		userInterface = new BankUI(5);
		getContentPane().add(userInterface);
		userInterface.setVisible(false);
		actionButton = userInterface.getDoTask1Button();
		actionButton.setText("Save changes");
		actionButton.setEnabled(false);

		actionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String action = arg0.getActionCommand();
				performAction(action);
			}
		});

		cancelButton = userInterface.getDoTask2Button();
		cancelButton.setText("Cancel");
		cancelButton.setEnabled(false);

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userInterface.clearFields();
			}
		});

		fields = userInterface.getField();
		accountField = fields[BankUI.ACCOUNT];
		accountField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayRecord("0");
			}
		});

		transactionField = fields[BankUI.TRANSACTION];
		transactionField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayRecord(transactionField.getText());
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		newItem = new JMenuItem("New Record");
		newItem.setEnabled(false);

		newItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fields[BankUI.ACCOUNT].setEnabled(true);
				fields[BankUI.FIRSTNAME].setEnabled(true);
				fields[BankUI.LASTNAME].setEnabled(true);
				fields[BankUI.BALANCE].setEnabled(true);
				fields[BankUI.TRANSACTION].setEnabled(false);
				actionButton.setEnabled(true);
				actionButton.setText("Create");
				cancelButton.setEnabled(true);
				userInterface.clearFields();
			}
		});

		updateItem = new JMenuItem("Update Record");
		updateItem.setEnabled(false);

		updateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fields[BankUI.ACCOUNT].setEnabled(true);
				fields[BankUI.FIRSTNAME].setEnabled(false);
				fields[BankUI.LASTNAME].setEnabled(false);
				fields[BankUI.BALANCE].setEnabled(false);
				fields[BankUI.TRANSACTION].setEnabled(true);
				actionButton.setEnabled(true);
				actionButton.setText("Update");
				cancelButton.setEnabled(true);
				userInterface.clearFields();
			}
		});

		deleteItem = new JMenuItem("Delete Record");
		deleteItem.setEnabled(false);

		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fields[BankUI.ACCOUNT].setEnabled(true);
				fields[BankUI.FIRSTNAME].setEnabled(false);
				fields[BankUI.LASTNAME].setEnabled(false);
				fields[BankUI.BALANCE].setEnabled(false);
				fields[BankUI.TRANSACTION].setEnabled(false);
				actionButton.setEnabled(true);
				actionButton.setText("Delete");
				cancelButton.setEnabled(true);
				userInterface.clearFields();
			}
		});

		openItem = new JMenuItem("New/Open File");
		openItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!openFile())
					return;
				newItem.setEnabled(true);
				updateItem.setEnabled(true);
				deleteItem.setEnabled(true);
				openItem.setEnabled(false);

				userInterface.setVisible(true);

				fields[BankUI.ACCOUNT].setEnabled(false);
				fields[BankUI.FIRSTNAME].setEnabled(false);
				fields[BankUI.LASTNAME].setEnabled(false);
				fields[BankUI.BALANCE].setEnabled(false);
				fields[BankUI.TRANSACTION].setEnabled(false);
			}
		});

		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dataFile.closeFile();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(TransactionProcessor.this, "Error closing file");
				} finally {
					System.exit(0);
				}
			}
		});

		fileMenu.add(openItem);
		fileMenu.add(newItem);
		fileMenu.add(updateItem);
		fileMenu.add(deleteItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		setSize(400, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TransactionProcessor();
	}

	protected boolean openFile() {
		// TODO Auto-generated method stub

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.CANCEL_OPTION)
			return false;
		File fileName = fileChooser.getSelectedFile();
		if (fileName == null || fileName.equals("")) {
			JOptionPane.showMessageDialog(this, "Invaild File Name");
			return false;
		} else {
			try {
				dataFile = new FileEditor(fileName);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "File does not exist");
				return false;
			}
		}
		return true;
	}

	protected void performAction(String action) {
		// TODO Auto-generated method stub
		try {
			String[] values = userInterface.getFieldValues();
			int accountNumber = Integer.parseInt(values[BankUI.ACCOUNT]);
			String firstName = values[BankUI.FIRSTNAME];
			String lastName = values[BankUI.LASTNAME];
			double balance = Double.parseDouble(values[BankUI.BALANCE]);
			if (action.equals("Create"))
				dataFile.newRecord(accountNumber, firstName, lastName, balance);
			else if (action.equals("Update"))
				dataFile.updateRecord(accountNumber, firstName, lastName, balance);
			else if (action.equals("Delete"))
				dataFile.deleteRecord(accountNumber);
			else
				JOptionPane.showMessageDialog(this, "Bad Action");
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e.getMessage());
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			// e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			// e.printStackTrace();
		}
	}

	protected void displayRecord(String transaction) {
		// TODO Auto-generated method stub
		try {
			int accountNumber = Integer.parseInt(userInterface.getFieldValues()[BankUI.ACCOUNT]);
			RandomAccessAccountRecord record = dataFile.getRecord(accountNumber);
			if (record.getAccount() == 0)
				JOptionPane.showMessageDialog(this, "Record does not exist");
			double change = Double.parseDouble(transaction);
			String[] values = { String.valueOf(record.getAccount()), record.getFirstName(), record.getLastName(),
					String.valueOf(record.getBalance() + change), "Charge(+) or payment(-)" };
			userInterface.setFieldValues(values);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "NumberFormat Error");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "IO Error");
		}
	}
}
