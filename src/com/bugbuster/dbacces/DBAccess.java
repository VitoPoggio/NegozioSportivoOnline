package com.bugbuster.dbacces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	
	
	public static void stampaRes(ResultSet res) {
		try {
			// creo il meta res
			ResultSetMetaData resMeta = res.getMetaData();
			//inizio la stampa
			System.out.println("----RISULTATO QUERY-----");
			//calcolo il numero di colonne
			int colnum = resMeta.getColumnCount();
			String colnames = "";
			//stampo i nomi delle colonne
			for (int i=1; i<=colnum; i++) {
				if (i == colnum ) {
					colnames += resMeta.getColumnName(i);
				} else {
					colnames += resMeta.getColumnName(i) + " - ";
				}
			}
			System.out.println(colnames);
			// stampo il contenuto delle colonne
			while(res.next()) {
				String colval = "";
				for (int i=1; i<=colnum; i++) {
					if (i == colnum ) {
						colval += res.getString(i);
					} else {
						colval += res.getString(i) + " - ";
					}
				}
				System.out.println(colval);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}

