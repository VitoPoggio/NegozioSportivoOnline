package com.bugbuster.model;

public class OrdineArticolo {
	private long id_oa;
	private long id_ordine;
    private long id_articolo;
    private int qta;
	public long getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
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
	@Override
	public String toString() {
		return "OrdineArticolo [id_ordine=" + id_ordine + ", id_articolo=" + id_articolo + ", qta=" + qta + "]";
	}
	public long getId_oa() {
		return id_oa;
	}
	public void setId_oa(long id_oa) {
		this.id_oa = id_oa;
	}
    
    
}
