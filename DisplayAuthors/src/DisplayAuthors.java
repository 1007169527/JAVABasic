
//P870 we use derby instead of CouldScape
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayAuthors extends JFrame {
	static final String framework = "embedded";
	static final String protocol = "jdbc:derby:";
	static final String dbName = "books";
	static final String databaseUrl = protocol + dbName;

	private Connection connection;
	private Statement statement;

	public DisplayAuthors() {
		// TODO Auto-generated constructor stub
		super("Authors Table of Books Database");

		try {
			Properties props = new Properties();
			props.put("user", "user1");
			props.put("password", "user1");
			connection = DriverManager.getConnection(databaseUrl, props);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * from authors");
			StringBuffer results = new StringBuffer();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			for (int i = 1; i <= numberOfColumns; i++)
				results.append(metaData.getColumnName(i) + "\t");
			results.append("\n");
			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					results.append(resultSet.getObject(i) + "\t");
				results.append("\n");
			}
			JTextArea textArea = new JTextArea(results.toString());
			Container container = getContentPane();

			container.add(new JScrollPane(textArea));

			setSize(300, 100);
			setVisible(true);
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(1);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e.getMessage());
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) {
		DisplayAuthors window = new DisplayAuthors();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
