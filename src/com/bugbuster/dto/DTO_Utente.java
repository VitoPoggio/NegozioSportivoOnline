package com.bugbuster.dto;

import java.sql.SQLException;

import com.bugbuster.dao.DAO_Utente;
import com.bugbuster.dbacces.DBAccess;
import com.bugbuster.model.Utente;

public class DTO_Utente {
	
	DAO_Utente uDao;
	
	
	
	public DTO_Utente() {
		try {
			this.uDao = new DAO_Utente(DBAccess.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void visualizza() {
		try {
			uDao.getUtenti();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserisci(Utente utente) {
		try {
			uDao.nuovoUtente(utente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifica(String username, String campo, String valore) {
		try {
			uDao.modificaUtente(username, campo, valore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elimina(String username) {
		try {
			uDao.eliminaUtente(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//getters and setter
	public DAO_Utente getuDao() {
		return uDao;
	}

	public void setuDao(DAO_Utente uDao) {
		this.uDao = uDao;
	}
	
	
}
