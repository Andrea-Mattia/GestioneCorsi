package it.betacom.businesscomponent.model;

public class Corsista {

	private long CodCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private int precedentiFormativi;

	public long getCodCorsista() {
		return CodCorsista;
	}

	public void setCodCorsista(long codCorsista) {
		CodCorsista = codCorsista;
	}

	public String getNomeCorsista() {
		return nomeCorsista;
	}

	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}

	public String getCognomeCorsista() {
		return cognomeCorsista;
	}

	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}

	public int getPrecedentiFormativi() {
		return precedentiFormativi;
	}

	public void setPrecedentiFormativi(int precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}

	@Override
	public String toString() {
		return "Corsista [CodCorsista=" + CodCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precedentiFormativi=" + precedentiFormativi + "]";
	}
}