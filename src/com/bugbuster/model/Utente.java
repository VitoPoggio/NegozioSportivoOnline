package com.bugbuster.model;

//import java.util.Date;

public class Utente {
	private String nome;
	private String cognome;
	private String indirizzo;
	private int cap;
//	private Date nascita;
	private String username;
	private String password;
	private String email;
	
	
	
	public Utente(String nome, String cognome, String indirizzo, int cap, String username, String password,
			String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + ", cap=" + cap
				+ ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
}
