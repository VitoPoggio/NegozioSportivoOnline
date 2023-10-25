package com.bugbuster.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bugbuster.dao.DAO_Carrello;
import com.bugbuster.model.Carrello;

public class DTO_Carrello {

	DAO_Carrello car;

	public DTO_Carrello(Connection conn) {
		car = new DAO_Carrello(conn);
	}
	
	public List<Carrello> getCarrello(String username) throws SQLException{
		return car.getCarrello(username);
		
	}
	
	public ResultSet getArtCart(String username) throws SQLException{
		return car.getArtCart(username);
	}
	
	public void aggiungiArtCart(String username, long id_articolo, int qta) throws SQLException{
		car.aggiungiArtCart(username, id_articolo, qta);
	}
	
	public void aumentaQta(String username, long id_articolo, int qta) throws SQLException{
		car.aumentaQta(username, id_articolo, qta);
	}
	
	public void deleteCarrello(String username) throws SQLException{
		car.deleteCarrello(username);
	}
	
	public void deleteArtCart(String username, long id_articolo) throws SQLException{
		car.deleteArtCart(username, id_articolo);
	}
	
	public void acquista(String username) throws SQLException{
		car.acquista(username);
	}
	
}
