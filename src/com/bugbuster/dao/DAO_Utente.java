package com.bugbuster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bugbuster.dbacces.DBAccess;
import com.bugbuster.model.Utente;
import com.bugbuster.service.UtenteService;

public class DAO_Utente implements UtenteService {
	private Connection conn;
	
	
	public DAO_Utente(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void getUtenti() throws SQLException {
			PreparedStatement pstm = conn.prepareStatement(LISTA_UTENTI);
			ResultSet res = pstm.executeQuery();
			DBAccess.stampaRes(res);
			
	}
		
	@Override
	public void nuovoUtente(Utente utente) throws SQLException {

			PreparedStatement pstm = conn.prepareStatement(NUOVO_UTENTE);
	        pstm.setString(1, utente.getNome());
	        pstm.setString(2, utente.getCognome());
	        pstm.setString(3, utente.getIndirizzo());
	        pstm.setInt(4, utente.getCap());
	        pstm.setString(5, utente.getUsername());
	        pstm.setString(6, utente.getPassword());
	        pstm.setString(7, utente.getEmail());
	        
	        int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
	            System.out.println( "Utente inserito con successo.");
	        } else {
	        	System.out.println( "Utente non inserito con successo.");
	        }
		
		
	}
		
	@Override
	public void modificaUtente(String username, String campo, String valore) throws SQLException {
			PreparedStatement pstm = conn.prepareStatement(MODIFICA_UTENTE);
	        pstm.setString(1, campo);
	        pstm.setString(2, valore);
	        pstm.setString(3, username);

	        int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
	            System.out.println( "Utente modificato con successo.");
	        } else {
	        	System.out.println("Errore durante modifica dell'utente.");
	        }
			DBAccess.closeConnection();
		
		
	}

	@Override
	public void eliminaUtente(String username) throws SQLException {
			PreparedStatement pstm = conn.prepareStatement(ELIMINA_UTENTE);
			pstm.setString(1, username);
	        int righeInserite = pstm.executeUpdate();
			if (righeInserite > 0) {
	            System.out.println( "Utente eliminato con successo.");
	        } else {
	        	System.out.println("Errore durante eliminazione dell'utente.");
	        }
			DBAccess.closeConnection();
		

		
	}
}
