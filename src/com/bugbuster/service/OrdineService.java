package com.bugbuster.service;

import com.bugbuster.model.Ordine;

public interface OrdineService {
	
	// creare costanti delle query da richiamare nel dao
	String LISTA_ORDINI = "SELECT * FROM negozio_sportivo_online.ordine;"; // ASSEGNARE LA QUERY
	String NUOVO_ORDINE = "INSERT INTO negozio_sportivo_online.ordine( totale , data , username ) VALUES ( ? , ? , ? ) ";
	String MODIFICA_ORDINE = "UPDATE negozio_sportivo_online.ordine SET totale = ? , data = ? , username = ? , WHERE ordine.idordine = ? ";
	String ELIMINA_ORDINE = " DELETE FROM negozio_sportivo_online.ordine WHERE ordine.idordine = ? ";
	
	void getListaOrdini(Ordine ordine);
	void nuovoOrdine(Ordine ordine);
	void modificaOrdine(Ordine ordine);
	void eliminaOrdine(Ordine ordine);
}
