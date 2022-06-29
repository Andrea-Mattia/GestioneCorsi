package it.betacom.businesscomponent.utilities;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class ReportUtility implements DAOConstants {
	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public Vector<String[]> getDocenti() throws DAOException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_MULTI_COURSES);

			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> corsi = new Vector<String[]>();
			rs.beforeFirst();
			while (rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for (int i = 0; i < nColonne; i++) {
					riga[i] = rs.getString(i + 1);
				}
				corsi.add(riga);
			}
			return corsi;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Vector<String[]> getCorsiDisponibili() throws DAOException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_AVAILABLE_COURSES);

			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> corsi = new Vector<String[]>();
			rs.beforeFirst();
			while (rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for (int i = 0; i < nColonne; i++) {
					riga[i] = rs.getString(i + 1);
				}
				corsi.add(riga);
			}
			return corsi;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Vector<String[]> getCorsiPopolari() throws DAOException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_POPULAR_COURSES);

			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> corsi = new Vector<String[]>();
			rs.beforeFirst();
			while (rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for (int i = 0; i < nColonne; i++) {
					riga[i] = rs.getString(i + 1);
				}
				corsi.add(riga);
			}
			return corsi;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

}