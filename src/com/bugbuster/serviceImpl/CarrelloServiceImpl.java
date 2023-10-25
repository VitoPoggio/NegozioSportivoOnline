package com.bugbuster.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bugbuster.model.Carrello;
import com.bugbuster.service.CarrelloService;

public class CarrelloServiceImpl implements CarrelloService {
	private Connection conn;

	public CarrelloServiceImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Carrello> getCarrello(String username) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_ALL_CARRELLO_USER);
		List<Carrello> carrello = new ArrayList<Carrello>();
		rs.last();
		rs.beforeFirst();
		while (rs.next()) {
			Carrello c = new Carrello();
			c.setId_car(rs.getLong(1));
			c.setUsername(rs.getString(2));
			c.setId_articolo(rs.getLong(3));
			c.setQta(rs.getInt(4));
			carrello.add(c);
		}
		return carrello;
	}

	@Override
	public ResultSet getArtCart(String username) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		return stmt.executeQuery(SELECT_PROD_CARRELLO_USER);
		
	}

	@Override
	public void aggiungiArtCart(String username, long id_articolo, int qta) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(AGGIUNGI_CARRELLO_INS,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, username);
		ps.setLong(2, id_articolo);
		ps.setInt(3, qta);
		int righeInserite = ps.executeUpdate();
        if (righeInserite > 0) {
            System.out.println( "Aggiunto " + id_articolo + " a carrello.");
        } else {
            System.out.println("Errore durante l'inserimento del prodotto.");
        }
        conn.close();
		 

	}
	
	//controllo se esiste già articolo in carrello da fare a livello superiore
	//qta dovrebbe arrivare già modificato
	@Override
	public void aumentaQta(String username, long id_articolo, int qta) throws SQLException { 
		PreparedStatement ps = conn.prepareStatement(AGGIUNGI_CARRELLO_SEL,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, username);
		ps.setLong(2, id_articolo);
		ResultSet rs = ps.executeQuery();
		rs.next();
		rs.updateInt(1, rs.getInt(1));
		rs.updateString(2, username);
		rs.updateLong(3, id_articolo);
		rs.updateInt(4, qta);
		rs.updateRow();
		conn.commit();
		System.out.println("aggiornata qta di " + id_articolo);
		
		
	}

	@Override
	public void deleteCarrello(String username) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_CARRELLO,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, username);
		int righeInserite = ps.executeUpdate();
        if (righeInserite > 0) {
            System.out.println( "Carrello svuotato");
        } else {
            System.out.println("Errore durante svuotamento carrello");
        }
        conn.close();

	}

	@Override
	public void deleteArtCart(String username, long id_articolo) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_ARTICOLO,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, username);
		ps.setLong(2, id_articolo);
		int righeInserite = ps.executeUpdate();
        if (righeInserite > 0) {
            System.out.println( "Eliminato articolo " + id_articolo + " da carrello");
        } else {
            System.out.println("Errore durante svuotamento carrello");
        }
        conn.close();

	}

	@Override
	public void acquista(String username) throws SQLException {
		// dovrà creare un nuovo ordine con le cose nel carrello?
		//oppure si potrà fare il getCarrello e fare l'acquisto ad un livello più alto
		// sicuro sarà da fare elimina carrello

	}

	

}
