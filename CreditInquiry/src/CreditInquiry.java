
//P636
import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CreditInquiry extends JFrame {
	private JTextArea recordDisplayArea;
	private JButton openButton, creditButton, debitButton, zeroButton;
	private JPanel buttonPanel;

	private ObjectInputStream input;
	private FileInputStream fileInput;
	private File fileName;
	private String accountType;

	public CreditInquiry() {
		// TODO Auto-generated constructor stub
		super("Credit Inquiry Program");
		Container container = getContentPane();
		buttonPanel = new JPanel();
		openButton = new JButton("Open File");
		buttonPanel.add(openButton);
		openButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				openFile();
			}
		});
		creditButton = new JButton("Credit balances");
		buttonPanel.add(creditButton);
		creditButton.addActionListener(new ButtonHandler());

		debitButton = new JButton("Debit balances");
		buttonPanel.add(debitButton);
		debitButton.addActionListener(new ButtonHandler());

		zeroButton = new JButton("Zero balances");
		buttonPanel.add(zeroButton);
		zeroButton.addActionListener(new ButtonHandler());

		recordDisplayArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(recordDisplayArea);

		container.add(scrollPane, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

		creditButton.setEnabled(false);
		debitButton.setEnabled(false);
		zeroButton.setEnabled(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				closeFile();
				System.exit(0);
			}
		});

		pack();
		setSize(600, 250);
		setVisible(true);
	}

	protected void closeFile() {
		// TODO Auto-generated method stub
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Error Closing file");
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
		fileName = fileChooser.getSelectedFile();

		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name");
		else {
			try {
				if (input != null)
					input.close();
				fileInput = new FileInputStream(fileName);
				input = new ObjectInputStream(fileInput);
				openButton.setEnabled(false);
				creditButton.setEnabled(true);
				debitButton.setEnabled(true);
				zeroButton.setEnabled(true);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Error Opening File");
			}
		}
	}

	private void readRecord() {
		// TODO Auto-generated method stub
		AccountRecord record;
		try {
			if (input != null)
				input.close();
			fileInput = new FileInputStream(fileName);
			input = new ObjectInputStream(fileInput);
			recordDisplayArea.setText("The records are:\n");
			while (true) {
				record = (AccountRecord) input.readObject();
				if (shouldDisplay(record.getBalance())) {
					recordDisplayArea.append(String.valueOf(record.getAccount()) + "\t"
							+ String.valueOf(record.getFirstName()) + "\t" + String.valueOf(record.getLastName()) + "\t"
							+ String.valueOf(record.getBalance()) + "\n");
				}
			}
		} catch (EOFException e) {
			// TODO: handle exception
			closeFile();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Class not found");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error during read from file");
		}
	}

	private boolean shouldDisplay(double balance) {
		// TODO Auto-generated method stub
		if (accountType.equals("Credit balances") && balance < 0)
			return true;
		if (accountType.equals("Debit balances") && balance > 0)
			return true;
		if (accountType.equals("Zero balances") && balance == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		new CreditInquiry();
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			accountType = e.getActionCommand();
			readRecord();
		}
	}
}
