package com.bugbuster.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bugbuster.model.Carrello;

public interface CarrelloService {
	String SELECT_ALL_CARRELLO_USER = "SELECT * FROM carrello WHERE username = ?";
	String SELECT_PROD_CARRELLO_USER = "SELECT articolo.marca, articolo.modello, articolo.prezzo, carrello.qta FROM carrello, articolo"
			+ "WHERE username = ? AND articolo.id_articolo = carrello.id_articolo";
	
	String AGGIUNGI_CARRELLO_INS = "INSERT INTO carrello (username, id_articolo,qta) VALUES(?,?,?)";
	String AGGIUNGI_CARRELLO_SEL= "SELECT * FROM carrello WHERE username = ? AND id_articolo = ? "; //si potrebbe usare per fare controllo qta e nel caso fare update
	
	String DELETE_CARRELLO = "DELETE FROM carrello where username = ?";
	String DELETE_ARTICOLO = "DELETE FROM carrello WHERE username = ? AND id_articolo = ?";
	
	/*
	 * se aggiungi articolo a carrello ti aggiunge relazione FATTo
	 * se elimini articolo ti toglie relazione (delete where username AND id_articolo) 
	 *  svuota carrello (delete where username) acquista query un po' più complicata. 
	 * recupera carrello (select cose where username) FATTO
	 */
	
	List<Carrello> getCarrello(String username) throws SQLException;
	ResultSet getArtCart(String username) throws SQLException;
	void aggiungiArtCart(String username, long id_articolo, int qta) throws SQLException;
	void aumentaQta(String username, long id_articolo, int qta) throws SQLException;
	void deleteCarrello(String username) throws SQLException;
	void deleteArtCart(String username, long id_articolo) throws SQLException;
	void acquista(String username) throws SQLException;
}
