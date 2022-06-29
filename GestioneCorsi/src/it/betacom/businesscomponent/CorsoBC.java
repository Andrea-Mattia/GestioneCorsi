package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;

public class CorsoBC {
private Connection conn;
	
	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		try {
			CorsoDAO.getFactory().create(conn, corso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void update(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		try {
			CorsoDAO.getFactory().update(conn, corso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(long id) throws ClassNotFoundException, DAOException, IOException {
		try {
			CorsoDAO.getFactory().delete(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}	
	}
	
	public Corso[] getCorso() throws DAOException {
		Corso[] corsi = null;

		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	public Corso[] searchCorso(String query) throws DAOException {
		Corso[] corsi = null;
		
		try {
			corsi = CorsoDAO.getFactory().searchCorso(conn, query);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
}
