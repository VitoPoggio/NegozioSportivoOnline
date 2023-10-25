package com.bugbuster.dbacces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess implements Constants{
	private static Connection conn;
	

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		Class.forName(Driver);
		conn = DriverManager.getConnection(URL,username,password);
		conn.setAutoCommit(false);

		return conn;
	}
	
	

	public static void closeConnection() throws SQLException {
		if (conn != null)
			conn.close();
	}
	
	

}

