package it.betacom.businesscomponent.model;

import java.util.Date;

public class Corso {
	private int codCorso;
	private int codDocente;
	private String nomeCorso;
	private Date dataInizio;
	private Date dataFine;
	private double costoCorso;
	private String commentiCorso;
	private String aulaCorso;
	
	public int getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(int cod_corso) {
		this.codCorso = cod_corso;
	}
	public int getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(int cod_docente) {
		this.codDocente = cod_docente;
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
	@Override
	public String toString() {
		return "Corso [cod_corso=" + codCorso + ", cod_docente=" + codDocente + ", nomeCorso=" + nomeCorso
				+ ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", costoCorso=" + costoCorso
				+ ", commentiCorso=" + commentiCorso + ", aulaCorso=" + aulaCorso + "]";
	}
}

