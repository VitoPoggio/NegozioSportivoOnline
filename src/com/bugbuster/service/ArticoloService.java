package com.bugbuster.service;

import java.sql.SQLException;
import java.util.List;

import com.bugbuster.model.Articolo;

public interface ArticoloService {
	String SELECT_ARTICOLI = "SELECT * FROM articolo";
	String INSERISCI_ARTICOLO = "INSERT INTO articolo (marca, modello, prezzo) VALUES (?,?,?)";
	String DELETE_ARTICOLO = "DELETE FROM articolo WHERE id_articolo=?";
	String UPDATE_ARTICOLO = "SELECT * FROM articolo WHERE id_articolo = ?";

	List<Articolo> getArticoli() throws SQLException;

	void inserisciArticolo(String marca, String modello, double prezzo) throws SQLException;

	void deleteArticolo(long id_articolo) throws SQLException;

	void updateArticolo(Articolo a) throws SQLException;

}
