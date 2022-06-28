package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.businesscomponent.AdapterDAO;
import it.betacom.businesscomponent.model.Docente;

public class DocenteDAO extends AdapterDAO<Docente> implements DAOConstants {
	
	
	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}	
	
	private DocenteDAO() {
	}
	
	@Override
	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTI);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Docente a = new Docente();
				a.setCod_docente(rs.getInt(1));
				a.setNomeDocente(rs.getString(2));
				a.setCognomeDocente(rs.getString(3));
				a.setCvDocente(rs.getString(4));
				
				docenti[i] = a;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
}
