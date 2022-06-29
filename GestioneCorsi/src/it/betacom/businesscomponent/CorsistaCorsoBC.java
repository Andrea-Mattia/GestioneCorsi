package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.CorsistaCorso;
import it.betacom.architecture.dao.CorsistaCorsoDAO;

public class CorsistaCorsoBC {
private Connection conn;
	
	public CorsistaCorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsistaCorso cC) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaCorsoDAO.getFactory().create(conn, cC);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(long codCorsista, long codCorso) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsistaCorsoDAO.getFactory().delete(conn, codCorsista, codCorso);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}