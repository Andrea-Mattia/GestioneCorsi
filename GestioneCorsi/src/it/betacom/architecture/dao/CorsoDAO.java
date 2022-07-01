package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.adapter.AdapterDAO;
import it.betacom.businesscomponent.model.Corso;

public class CorsoDAO extends AdapterDAO<Corso> implements DAOConstants{
	private CachedRowSet rowSet;
	
	private CorsoDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}
	//----------CREATE
	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorso());
			rowSet.updateLong(2, entity.getCodDocente());
			rowSet.updateString(3, entity.getNomeCorso());
			rowSet.updateDate(4, new java.sql.Date(entity.getDataInizio().getTime()));
			rowSet.updateDate(5, new java.sql.Date(entity.getDataFine().getTime()));
			rowSet.updateDouble(6, entity.getCostoCorso());
			rowSet.updateString(7, entity.getCommentiCorso());
			rowSet.updateString(8, entity.getAulaCorso());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	//----------UPDATE
	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setDate(1, new java.sql.Date(entity.getDataInizio().getTime()));
			ps.setDate(2, new java.sql.Date(entity.getDataFine().getTime()));
			ps.setDouble(3, entity.getCostoCorso());
			ps.setString(4, entity.getCommentiCorso());
			ps.setString(5, entity.getAulaCorso());
			ps.setLong(6, entity.getCodCorso());
			
			ps.execute();

			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	//----------DELETE
	@Override
	public void delete(Connection conn, long id) throws DAOException {
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, id);
			
			ps.execute();

			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return super.getById(conn, id);
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corsi = null;
		
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			
			rs.last();
			corsi = new Corso[rs.getRow()];
			rs.beforeFirst();
			
			for(int i = 0; rs.next(); i++) {
				Corso c = new Corso();
				c.setCodCorso(rs.getInt(1));
				c.setCodDocente(rs.getInt(2));
				c.setNomeCorso(rs.getString(3));
				c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				c.setCostoCorso(rs.getDouble(6));
				c.setCommentiCorso(rs.getString(7));
				c.setAulaCorso(rs.getString(8));
				corsi[i] = c;
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	public Corso[] searchCorso(Connection conn, String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Corso[] getCorsiAttivi(Connection conn) throws DAOException {
		Corso[] corsi = null;
		
		try {
			Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(SELECT_NOME_DATA);
            rs.last();
            corsi = new Corso[rs.getRow()];
            rs.beforeFirst();
            for(int i = 0; rs.next(); i++) {
				Corso c = new Corso();
				c.setCodCorso(rs.getLong(1));
				c.setCodDocente(rs.getLong(2));
				c.setNomeCorso(rs.getString(3));
				c.setDataInizio(new java.util.Date(rs.getDate(4).getTime()));
				c.setDataFine(new java.util.Date(rs.getDate(5).getTime()));
				c.setCostoCorso(rs.getDouble(6));
				c.setCommentiCorso(rs.getString(7));
				c.setAulaCorso(rs.getString(8));
				corsi[i] = c;
			}
			rs.close();		
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
}