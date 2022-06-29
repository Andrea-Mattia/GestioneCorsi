package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;

import it.betacom.architecture.dbaccess.DBAccess;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;

public class CorsoIdGenerator implements IdGeneratorInterface, DAOConstants{
	private static CorsoIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsoIdGenerator()
			throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public static CorsoIdGenerator getInstance()
			throws ClassNotFoundException, DAOException, IOException{
		if(idGen == null)
			idGen = new CorsoIdGenerator();
		return idGen;
	}
	
	@Override
	public long getNextId() 
			throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSO_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
