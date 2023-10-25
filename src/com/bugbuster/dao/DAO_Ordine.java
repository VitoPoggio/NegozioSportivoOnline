package com.bugbuster.dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.bugbuster.dbacces.DBAccess;
import com.bugbuster.model.Ordine;

public class DAO_Ordine {
	
	public void getListaOrdini(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = "INSERIRE COSTANTE QUERY";
			//fare un controllo per l'esecuzione della query
			//se va a buon fine 
			//stampare la lista ordini
			//altrimenti stampare un messaggio errore recupero dati
			conn.closeConnection();
		}catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
	}
	
	public void inserisci(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = "";//NUOVO_ORDINE
			PreparedStatement pstm = conn.getConnection().prepareStatement(query);
			pstm.setLong(1, ordine.getId_ordine());
	        pstm.setDouble(2, ordine.getTotale());
	        pstm.setDate(3, (Date) ordine.getData());
	        pstm.setString(4, ordine.getUsername());
	        
	        int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
	            System.out.println( "Prodotto inserito con successo.");
	        } else {
	        	System.out.println("Errore durante l'inserimento del prodotto.");
	        }
			conn.closeConnection();
			
		}catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}

	public void modifica(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = "";//MODIFICA_ORDINE
			PreparedStatement pstm = conn.getConnection().prepareStatement(query);
			pstm.setLong(1, ordine.getId_ordine());
			pstm.setDouble(2, ordine.getTotale());
			
		}catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
	}

	public void elimina(Ordine ordine) {

	}
}
