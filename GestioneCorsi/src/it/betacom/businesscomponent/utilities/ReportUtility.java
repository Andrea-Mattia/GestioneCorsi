package it.betacom.businesscomponent.utilities;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;

public class ReportUtility implements DAOConstants {
	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public Vector<String[]> getCorsiDocenti() throws DAOException {
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
				String[] riga = new String[nColonne];
				for (int i = 0; i < nColonne; i++) {
					if(i == 2) {
						String[] stringaData = rs.getString(i + 1).toLowerCase().split(" ");
						riga[i] = stringaData[0];
					} else {
						riga[i] = rs.getString(i + 1);						
					}
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
	
	public int getAvgDurata() throws DAOException, ParseException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DATE_CORSO);
			int avgInizio = 0;
			int avgFine = 0;
			int i = 0;

			Calendar cal = new GregorianCalendar();
			
			rs.beforeFirst();
			while (rs.next()) {
				cal.setTime(rs.getDate(1));
				avgInizio += cal.get(Calendar.DAY_OF_YEAR);
				cal.setTime(rs.getDate(2));
				avgFine += cal.get(Calendar.DAY_OF_YEAR);
				i++;
			}
		
			return (avgFine - avgInizio)/i;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public int getCorsistiNum() throws DAOException, ParseException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA_SUM);
			rs.next();
			
			return rs.getInt(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Vector<String[]> getLastCourse() throws DAOException, ParseException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_LAST_COURSE);
			ResultSetMetaData meta = rs.getMetaData();
			int nColonne = meta.getColumnCount();
			Vector<String[]> corsi = new Vector<String[]>();
			rs.beforeFirst();
			while (rs.next()) {
				String[] riga = new String[meta.getColumnCount()];
				for (int i = 0; i < nColonne; i++) {
					if(i == 3 || i == 4) {
						String[] stringaData = rs.getString(i + 1).toLowerCase().split(" ");
						riga[i] = stringaData[0];
					} else {
						riga[i] = rs.getString(i + 1);						
					}
				}
				corsi.add(riga);
			}
			return corsi;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public int getCommentiNum() throws DAOException, ParseException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_COMMENT_SUM);
			rs.next();
			
			return rs.getInt(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Vector<String[]> getCorsiCorsista(long id) throws DAOException {
		try {
			PreparedStatement pr = conn.prepareStatement(
					SELECT_CORSISTA_COURSES,  
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			pr.setLong(1, id);
			ResultSet rs = pr.executeQuery();

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