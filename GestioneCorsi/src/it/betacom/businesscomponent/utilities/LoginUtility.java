package it.betacom.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants{
	private Connection conn;
	
	public LoginUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public String getAdminPass(String codAdmin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, codAdmin);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public String getAdminName() throws DAOException, ClassNotFoundException, IOException {
		
		try {
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_ADMIN_NAME);
			
			if(rs.next()) {
				return rs.getString(1);
			}
			return null;
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}