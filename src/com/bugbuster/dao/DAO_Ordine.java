package com.bugbuster.dao;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.bugbuster.dbacces.DBAccess;
import com.bugbuster.model.Ordine;
import com.bugbuster.service.OrdineService;

public class DAO_Ordine implements OrdineService{
	
	public void getListaOrdini(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = LISTA_ORDINI;
			//fare un controllo per l'esecuzione della query
			//se va a buon fine 
			//stampare la lista ordini
			//altrimenti stampare un messaggio errore recupero dati
			conn.closeConnection();
		}catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
	}
	
	public void nuovoOrdine(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = NUOVO_ORDINE;
			PreparedStatement pstm = conn.getConnection().prepareStatement(query);
//			pstm.setLong(1, ordine.getId_ordine()); // togliere id perchè sono auto incrementali 
	        pstm.setDouble(1, ordine.getTotale());
	        pstm.setDate(2, (Date) ordine.getData());
	        pstm.setString(3, ordine.getUsername());
	        
	        int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
	            System.out.println( "Ordine inserito con successo.");
	        } else {
	        	System.out.println("Errore durante l'inserimento dell'ordine.");
	        }
			conn.closeConnection();
			
		}
		catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}

	public void modificaOrdine(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = MODIFICA_ORDINE;
			PreparedStatement pstm = conn.getConnection().prepareStatement(query);
			pstm.setDouble(1, ordine.getTotale());
			pstm.setDate(2, (Date) ordine.getData());
			pstm.setString(3, ordine.getUsername());
			pstm.setLong(4, ordine.getId_ordine());
			
			
			int righeInserite = pstm.executeUpdate();
			if(righeInserite > 0) {
				 System.out.println("Ordine modificato con successo.");
	        } else {
	        	System.out.println("Errore durante la modifica dell'ordine.");
	        }
			conn.closeConnection();
		}
		catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
	}

	public void eliminaOrdine(Ordine ordine) {
		try {
			DBAccess conn = new DBAccess();
			conn.getConnection();
			String query = ELIMINA_ORDINE;
			PreparedStatement pstm = conn.getConnection().prepareStatement(query);
			pstm.setLong(1, ordine.getId_ordine());
			int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
				System.out.println( "Ordine eliminato con successo.");
			} else {
				System.out.println("Errore durante l'eliminazione dell'ordine.");				
			}
			conn.closeConnection();
		}
		catch(Exception e){
			System.out.println("Errore: " + e.getMessage());
		}
		
		
	}
}
