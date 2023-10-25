package com.bugbuster.model;

public class Carrello {
	private long id_car;
	private String username;
	private long id_articolo;
	private int qta;
	
	public Carrello() {
		
	}

	public Carrello(String username, long id_articolo, int qta) {
		this.username = username;
		this.id_articolo = id_articolo;
		this.qta = qta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId_articolo() {
		return id_articolo;
	}

	public void setId_articolo(long id_articolo) {
		this.id_articolo = id_articolo;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public String toString() {
		return "Carrello [username=" + username + ", id_articolo=" + id_articolo + ", qta=" + qta + "]";
	}

	public long getId_car() {
		return id_car;
	}

	public void setId_car(long id_car) {
		this.id_car = id_car;
	}

}
