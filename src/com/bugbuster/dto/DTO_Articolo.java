package com.bugbuster.dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bugbuster.dao.DAO_Articolo;
import com.bugbuster.model.Articolo;

public class DTO_Articolo {
	private DAO_Articolo art;

	public DTO_Articolo(Connection conn) {
		art = new DAO_Articolo(conn);
	}
	
	
	public List<Articolo> getArticoli() throws SQLException{
		return art.getArticoli();
	}

	public void inserisciArticolo(String marca, String modello, double prezzo) throws SQLException{
		art.inserisciArticolo(marca, modello, prezzo);
	}

	public void deleteArticolo(long id_articolo) throws SQLException{
		art.deleteArticolo(id_articolo);
	}

	public void updateArticolo(Articolo a) throws SQLException{
		art.updateArticolo(a);
	}
	
}
