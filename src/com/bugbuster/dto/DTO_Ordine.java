package com.bugbuster.dto;

import com.bugbuster.dao.DAO_Ordine;
import com.bugbuster.model.Ordine;

public class DTO_Ordine {
	DAO_Ordine dao = new DAO_Ordine();
	
	public void listaOrdini(Ordine ordine) {
		dao.getListaOrdini(ordine);
	}
	
	public void inserisci(Ordine ordine) {
		dao.nuovoOrdine(ordine);
	}
	
	public void modifica(Ordine ordine) {
		dao.modificaOrdine(ordine);
	}
	
	public void elimina(Ordine ordine) {
		dao.eliminaOrdine(ordine);
	}
}
