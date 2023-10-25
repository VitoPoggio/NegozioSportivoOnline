package com.bugbuster.service;

import java.sql.SQLException;
import java.util.List;

import com.bugbuster.model.Articolo;
import com.bugbuster.model.Ordine;

public interface OrdineArticoloService {
	String SELECT_ORD_ART = "select marca, modello, prezzo, qta from articolo, ordine_articolo where articolo.id_articolo = ordinearticolo.id_articolo and id_ordine = ?";
	String AGGIUNGI_ORDINE = "INSERT INTO ordinearticolo (id_ordine, id_articolo, qta) VALUES (?,?,?)";
	
	List<String[]> getListaOrdArt(long id_ordine) throws SQLException;
	void aggiungiOrdArt(Ordine ord, Articolo art, int qta) throws SQLException;
	
	
}
