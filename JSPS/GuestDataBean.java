package net.rtfsc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class GuestDataBean {
    static final String protocol = "jdbc:derby://localhost:1527/";
    static final String dbName = "guestbook";
    static final String databaseUrl = protocol + dbName;
	private Connection connection;
	private Statement statement;
	
	public GuestDataBean() throws Exception {
		connection = DriverManager.getConnection(databaseUrl);
        statement = connection.createStatement();
	}
	
	public List getGuestList() throws SQLException {
		List guestList = new ArrayList();
		ResultSet results = statement.executeQuery("SELECT firstName, lastName, email FROM guests");
		while(results.next()) {
			GuestBean guest = new GuestBean();
			guest.setFirstName(results.getString(1));
			guest.setLastName(results.getString(2));
			guest.setEmail(results.getString(3));
			guestList.add(guest);
		}
		return guestList;
	}
	
	public void addGuest(GuestBean guest) throws SQLException {
		statement.executeQuery("INSERT INTO guests (firstName, " + "lastName, email) " +
			"VALUES('" + guest.getFirstName() +
			"', '" + guest.getLastName() + 
			"', '" +  guest.getEmail() + "')");
	}
	
	protected void finalize() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}