package com.bugbuster.dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bugbuster.dao.DAO_OrdineArticolo;
import com.bugbuster.model.Articolo;
import com.bugbuster.model.Ordine;

public class DTO_OrdineArticolo {
	private DAO_OrdineArticolo oa;

	public DTO_OrdineArticolo(Connection conn) {
		oa = new DAO_OrdineArticolo(conn);
	}
	
	public List<String[]> getListaOrdArt(long id_ordine) throws SQLException{
		return oa.getListaOrdArt(id_ordine);
	}
	public void aggiungiOrdArt(Ordine ord, Articolo art, int qta) throws SQLException{
		oa.aggiungiOrdArt(ord, art, qta);
	}
	
}
