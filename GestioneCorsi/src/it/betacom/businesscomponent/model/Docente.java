package it.betacom.businesscomponent.model;

public class Docente {
	private long cod_docente;
	private String nomeDocente;
	private String cognomeDocente;
	private String cvDocente;

	public long getCod_docente() {
		return cod_docente;
	}

	public void setCod_docente(long cod_docente) {
		this.cod_docente = cod_docente;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

	public String getCvDocente() {
		return cvDocente;
	}

	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}
}
