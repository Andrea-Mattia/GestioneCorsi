package it.betacom.businesscomponent.model;

public class CorsistaCorso {
	private long codCorsista;
	private long codCorso;
	
	public long getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}
	public long getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(long codCorso) {
		this.codCorso = codCorso;
	}
	@Override
	public String toString() {
		return "CorsistaCorso [codCorsista=" + codCorsista + ", codCorso=" + codCorso + "]";
	}
}