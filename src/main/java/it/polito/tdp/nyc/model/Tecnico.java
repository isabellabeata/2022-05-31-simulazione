package it.polito.tdp.nyc.model;

public class Tecnico {
	
	private int id;
	private int nInterventi;
	public Tecnico(int id) {
		super();
		this.id = id;
		this.nInterventi = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getnInterventi() {
		return nInterventi;
	}
	
	
	public void incrementanInterventi() {
		this.nInterventi++;
	}
	
	

}
