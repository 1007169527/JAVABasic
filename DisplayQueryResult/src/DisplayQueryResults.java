import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DisplayQueryResults extends JFrame {
	static final String DATABASE_URL = "jdbc:derby:books";
	static final String DEFAULT_QUERY = "SELECT * FROM authors";

	private ResultSetTableModel tableModel;
	private JTextArea queryArea;

	public DisplayQueryResults() {
		// TODO Auto-generated constructor stub
		super("Displaying Query Results");
		try {
			tableModel = new ResultSetTableModel(DATABASE_URL, DEFAULT_QUERY);
			queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
			queryArea.setWrapStyleWord(true);
			queryArea.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane(queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			JButton submitButton = new JButton("Submit Query");
			Box box = Box.createHorizontalBox();
			box.add(scrollPane);
			box.add(submitButton);
			JTable resultTable = new JTable(tableModel);
			Container container = getContentPane();
			container.add(box, BorderLayout.NORTH);
			container.add(new JScrollPane(resultTable), BorderLayout.CENTER);

			submitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						tableModel.setQuery(queryArea.getText());
					} catch (SQLException e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2.getMessage());
						tableModel.disconnectFromDataBase();
						try {
							tableModel.setQuery(DEFAULT_QUERY);
							queryArea.setText(DEFAULT_QUERY);
						} catch (SQLException e3) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, e3.getMessage());
							tableModel.disconnectFromDataBase();
							System.exit(1);
						}
					}
				}
			});
			setSize(500, 250);
			setVisible(true);
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
			tableModel.disconnectFromDataBase();
			System.exit(1);
		}

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent event) {
				tableModel.disconnectFromDataBase();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		new DisplayQueryResults();
	}
}
