package it.betacom.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {
	private static final long serialVersionUID = -11231215152532L;
	
	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;
	
	private String message;
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	public DAOException(SQLException sql) {
		String chiave = "";
		if(sql != null) {
			switch(sql.getErrorCode()) {
			case ORA1017:
				chiave = "Credenziali di accesso al DB errate";
				log(sql);
				break;
			case ORA17002:
				chiave = "I/O exception di Oracle DB. Impossibile connettersi alla base dati";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
			
			}
		}
		message = chiave;
		
	}
	

	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: " + sql.getMessage());
		System.err.println("Stato app: " + sql.getSQLState());
		System.err.println("Codice errore: " + sql.getErrorCode());
		System.err.println("Causa eccezione: " + sql.getCause());
		
	}
}
