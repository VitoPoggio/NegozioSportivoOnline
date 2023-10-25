package com.bugbuster.service;


import java.sql.SQLException;

import com.bugbuster.model.Utente;

public interface UtenteService {
	
	// creare costanti delle query da richiamare nel dao
		String LISTA_UTENTI = "SELECT * FROM Utente;"; // ASSEGNARE LA QUERY
		String NUOVO_UTENTE = "INSERT INTO Utente VALUES(? , ? ,? , ?,? ,? , ? );";
		String MODIFICA_UTENTE = "UPDATE Utente SET ? = ? WHERE username = ?;"; 
		String ELIMINA_UTENTE = "DELETE FROM Utente WHERE username = ?;";
		
		void getUtenti() throws SQLException;
		void nuovoUtente(Utente utente) throws SQLException;
		void modificaUtente(String username, String campo, String valore) throws SQLException;
		void eliminaUtente(String username) throws SQLException;
}
