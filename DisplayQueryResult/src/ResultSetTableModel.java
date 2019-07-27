import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;

	private boolean connectedToDatabase = false;

	public ResultSetTableModel(String url, String query) throws SQLException {
		// TODO Auto-generated constructor stub
		connection = DriverManager.getConnection(url);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		connectedToDatabase = true;
		System.out.println("query begin");
		setQuery(query);
		System.out.println("query end");
	}

	// public Class getColumnClass(int column) throws IllegalStateException {
	// if (!connectedToDatabase)
	// throw new IllegalStateException("Not Connect to Database");
	// System.out.println("getColumnClass called with colume = " + column);
	// try {
	// String className = metaData.getColumnClassName(column + 1);
	// return Class.forName(className);
	// } catch (Exception e) { // TODO: handle exception
	// e.printStackTrace();
	// }
	// return Object.class;
	// }

	@Override
	public int getColumnCount() throws IllegalStateException {
		// TODO Auto-generated method stub

		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to DataBase");
		//System.out.println("getColumnCount called");
		try {
			return metaData.getColumnCount();
		} catch (SQLException e) { // TODO: handle
			e.printStackTrace();
		}

		return 0;
	}

	public String getColumnName(int colume) throws IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to DataBase");
		System.out.println("getColumeName called with colume = " + colume);
		try {
			return metaData.getColumnName(colume + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int getRowCount() throws IllegalStateException {
		// TODO Auto-generated method stub

		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to DataBase"); //
		//System.out.println("getRowCount called");
		return numberOfRows;
	}

	public Object getValueAt(int row, int column) throws IllegalStateException {
		// TODO Auto-generated method stub
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to DataBase");
		//System.out.println("getValueAt called with row = " + row + " column = " + column);
		try {
			resultSet.absolute(row + 1);
			return resultSet.getObject(column + 1);
		} catch (SQLException e) { // TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}

	public void setQuery(String query) throws SQLException, IllegalStateException {
		// TODO Auto-generated method stub
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to DataBase");
		// System.out.println("setQuery called with query = " + query);
		resultSet = statement.executeQuery(query);
		// System.out.println("executeQuery called");
		metaData = resultSet.getMetaData();
		resultSet.last();
		numberOfRows = resultSet.getRow();
		fireTableStructureChanged();
	}

	public void disconnectFromDataBase() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connectedToDatabase = false;
		}
	}

}
