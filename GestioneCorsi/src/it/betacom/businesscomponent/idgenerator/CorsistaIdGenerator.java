package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;

import it.betacom.architecture.dbaccess.DBAccess;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;

public class CorsistaIdGenerator implements IdGeneratorInterface, DAOConstants{
	private static CorsistaIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsistaIdGenerator()
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsistaIdGenerator getInstance()
			throws ClassNotFoundException, DAOException, IOException{
		if(idGen == null)
			idGen = new CorsistaIdGenerator();
		return idGen;
	}
	
	@Override
	public long getNextId() 
			throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
