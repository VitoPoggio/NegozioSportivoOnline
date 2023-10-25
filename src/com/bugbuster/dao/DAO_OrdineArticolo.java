package com.bugbuster.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bugbuster.model.Articolo;
import com.bugbuster.model.Ordine;
import com.bugbuster.service.OrdineArticoloService;

public class DAO_OrdineArticolo implements OrdineArticoloService {
	private Connection conn;

	public DAO_OrdineArticolo(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<String[]> getListaOrdArt(long id_ordine) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_ORD_ART);
		return null;
	}

	@Override
	public void aggiungiOrdArt(Ordine ord, Articolo art, int qta) throws SQLException {
		// TODO Auto-generated method stub

	}

}
