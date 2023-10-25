package com.bugbuster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bugbuster.model.Articolo;
import com.bugbuster.service.ArticoloService;

public class DAO_Articolo implements ArticoloService {
	private Connection conn;

	public DAO_Articolo(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Articolo> getArticoli() throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_ARTICOLI);
		List<Articolo> articoli = new ArrayList<Articolo>();
		rs.last();
		rs.beforeFirst();
		while (rs.next()) {
			Articolo a = new Articolo();
			a.setId_articolo(rs.getLong(1));
			a.setMarca(rs.getString(2));
			a.setModello(rs.getString(3));
			a.setPrezzo(rs.getDouble(4));
			articoli.add(a);
		}
		return articoli;
		
	}

	@Override
	public void inserisciArticolo(String marca, String modello, double prezzo) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(INSERISCI_ARTICOLO,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setString(1, marca);
		ps.setString(2, modello);
		ps.setDouble(3, prezzo);
		int righeInserite = ps.executeUpdate();
        if (righeInserite > 0) {
            System.out.println( "Aggiunto " + marca + " ," + modello + " a carrello.");
        } else {
            System.out.println("Errore durante l'inserimento del prodotto.");
        }
		
	}

	@Override
	public void deleteArticolo(long id_articolo) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_ARTICOLO,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setLong(1, id_articolo);
		int righeInserite = ps.executeUpdate();
        if (righeInserite > 0) {
            System.out.println( "eliminato articolo "+ id_articolo);
        } else {
            System.out.println("Errore durante svuotamento carrello");
        }
        conn.close();
		
	}

	@Override
	public void updateArticolo(Articolo a) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_ARTICOLO,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ps.setLong(1, a.getId_articolo());
		ResultSet rs = ps.executeQuery();
		rs.next();
		rs.updateLong(1, a.getId_articolo());
		rs.updateString(2, a.getMarca());
		rs.updateString(3, a.getModello());
		rs.updateDouble(4, a.getPrezzo());
		rs.updateRow();
		conn.commit();
		System.out.println("Aggiornato articolo "+ a.getId_articolo());
		
	}
	
	
}
