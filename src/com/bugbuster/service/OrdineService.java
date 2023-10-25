package com.bugbuster.service;

import com.bugbuster.model.Ordine;

public interface OrdineService {
	
	// creare costanti delle query da richiamare nel dao
	String LISTA_ORDINI = ""; // ASSEGNARE LA QUERY
	String NUOVO_ORDINE = "";
	String MODIFICA_ORDINE = "";
	String ELIMINA_ORDINE = "";
	
	void getOrdini(Ordine ordine);
	void nuovoOrdine(Ordine ordine);
	void modificaOrdine(Ordine ordine);
	void eliminaOrdine(Ordine ordine);
}
