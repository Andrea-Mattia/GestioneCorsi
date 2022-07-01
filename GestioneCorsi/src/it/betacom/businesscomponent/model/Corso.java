package it.betacom.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long codCorso;
	private long codDocente;
	private String nomeCorso;
	private Date dataInizio;
	private Date dataFine;
	private double costoCorso;
	private String commentiCorso;
	private String aulaCorso;

	public long getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}

	public long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(long codDocente) {
		this.codDocente = codDocente;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public double getCostoCorso() {
		return costoCorso;
	}

	public void setCostoCorso(double costoCorso) {
		this.costoCorso = costoCorso;
	}

	public String getCommentiCorso() {
		return commentiCorso;
	}

	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}

	public String getAulaCorso() {
		return aulaCorso;
	}

	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}
}
