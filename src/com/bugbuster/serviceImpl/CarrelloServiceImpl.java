package com.bugbuster.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bugbuster.service.CarrelloService;

public class CarrelloServiceImpl implements CarrelloService {
	private Connection conn;

	public CarrelloServiceImpl(Connection conn) {
		this.conn = conn;
	}

	public ResultSet getCarrello(String username) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_ALL_CARRELLO_USER);
		return rs;
	}

	public ResultSet getArtCart(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void aggiungiArtCart(String username, long id_articolo, int qta) {
		// TODO Auto-generated method stub

	}

	public void deleteCarrello(String username) {
		// TODO Auto-generated method stub

	}

	public void deleteArtCart(String username, long id_articolo) {
		// TODO Auto-generated method stub

	}

	public void acquista(String username) {
		// TODO Auto-generated method stub

	}

}
