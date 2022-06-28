package it.betacom.businesscomponent;

import java.sql.Connection;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.GenericDAO;

public abstract class AdapterDAO<T> implements GenericDAO<T>{
	
	@Override
	public void create(Connection conn, T entity) throws DAOException {
	}
	
	@Override
	public void update(Connection conn, T entity) throws DAOException {
		
	}
	
	@Override
	public void delete(Connection conn, long id) throws DAOException {
		
	}
	
	public void delete(Connection conn, long id1, long id2) throws DAOException {
		
	}
	
	@Override
	public T getById(Connection conn, long id) throws DAOException {
		return null;
	}
	
	@Override
	public T[] getAll(Connection conn) throws DAOException {
		return null;
	}
	
	
	public T[] searchCorsista(Connection conn, String query) throws DAOException {
		return null;
	}
}

