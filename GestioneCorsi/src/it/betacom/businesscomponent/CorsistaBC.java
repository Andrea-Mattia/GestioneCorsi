package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {

	private Connection conn;

	public CorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		
		try {

			corsista.setCodCorsista(CorsistaIdGenerator.getInstance().getNextId());
			CorsistaDAO.getFactory().create(conn, corsista);
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void update(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {

		try {

			CorsistaDAO.getFactory().update(conn, corsista);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public void delete(long id) throws ClassNotFoundException, DAOException, IOException {

		try {

			CorsistaDAO.getFactory().delete(conn, id);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public Corsista[] getCorsisti() throws DAOException {

		Corsista[] corsisti = null;

		try {

			corsisti = CorsistaDAO.getFactory().getAll(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsisti;
	}

	public Corsista[] searchCorsista(String query) throws DAOException {

		Corsista[] corsisti = null;

		try {

			corsisti = CorsistaDAO.getFactory().searchCorsista(conn, query);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsisti;
	}
	
	public Corsista getByID(long id) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getById(conn, id);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}