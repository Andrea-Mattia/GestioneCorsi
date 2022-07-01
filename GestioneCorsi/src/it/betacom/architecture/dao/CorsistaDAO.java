package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.adapter.AdapterDAO;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaDAO extends AdapterDAO<Corsista> implements DAOConstants {

	private CachedRowSet rowSet;
	
	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	@Override
	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);

			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorsista());
			rowSet.updateString(2, entity.getNomeCorsista());
			rowSet.updateString(3, entity.getCognomeCorsista());
			rowSet.updateInt(4, entity.getPrecedentiFormativi());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsista entity) throws DAOException {
		
		PreparedStatement ps;

		try {

			ps = conn.prepareStatement(UPDATE_CORSISTA);
			ps.setString(1, entity.getNomeCorsista());
			ps.setString(2, entity.getCognomeCorsista());
			ps.setInt(3, entity.getPrecedentiFormativi());
			ps.setLong(4, entity.getCodCorsista());
			ps.execute();

			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	@Override
	public Corsista[] getAll(Connection conn) throws DAOException {
		
		Corsista[] corsisti = null;

		try {

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);

			rs.last();
			corsisti = new Corsista[rs.getRow()];

			rs.beforeFirst();

			for (int i = 0; rs.next(); i++) {
				Corsista c = new Corsista();
				c.setCodCorsista(rs.getLong(1));
				c.setNomeCorsista(rs.getString(2));
				c.setCognomeCorsista(rs.getString(3));
				c.setPrecedentiFormativi(rs.getInt(4));
				corsisti[i] = c;
			}

			rs.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return corsisti;
	}

	@Override
	public Corsista[] searchCorsista(Connection conn, String query) throws DAOException {

		try {
			ArrayList<Corsista> lista = new ArrayList<Corsista>();

			String[] criterioDiRicerca = query.toLowerCase().split(" ");
			
			boolean find = false;
			
			if(criterioDiRicerca.length == 1) {
				
				PreparedStatement pr = conn.prepareStatement(SEARCH_CORSISTA);
				
				for(int i = 1; i <= 2; i++) {
					
					pr.setString(i, criterioDiRicerca[0]);
					
					if(i == 1)
						pr.setString(2, "");
					else
						pr.setString(1, "");
					
					ResultSet rs = pr.executeQuery();
					
					while(rs.next()) {
						
						Corsista cor = new Corsista();
						cor.setCodCorsista(rs.getLong(1));
						cor.setNomeCorsista(rs.getString(2));
						cor.setCognomeCorsista(rs.getString(3));
						cor.setPrecedentiFormativi(rs.getInt(4));
						
						for(Corsista c : lista)
	                        if(c.getCodCorsista() == cor.getCodCorsista())
	                            find = true;
	                    if(!find)
	                        lista.add(cor);
					}
					
				}
				
			} else {
				PreparedStatement pr = conn.prepareStatement(SEARCH_CORSISTA);
				
				pr.setString(1, criterioDiRicerca[0]);
				pr.setString(2, criterioDiRicerca[1]);
				
				ResultSet rs = pr.executeQuery();
				
				while(rs.next()) {
					Corsista cor = new Corsista();
					cor.setCodCorsista(rs.getLong(1));
					cor.setNomeCorsista(rs.getString(2));
					cor.setCognomeCorsista(rs.getString(3));
					cor.setPrecedentiFormativi(rs.getInt(4));
					
					for(Corsista c : lista)
                        if(c.getCodCorsista() == cor.getCodCorsista())
                            find = true;
                    if(!find)
                        lista.add(cor);
				}
			}

			Corsista[] corsisti = lista.toArray(new Corsista[lista.size()]);

			return corsisti;
			
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista getById(Connection conn, long id) throws DAOException {
		Corsista cor = null;
		try {
			PreparedStatement pr = conn.prepareStatement(SELECT_CORSISTA_BYID);
			pr.setLong(1, id);
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				cor = new Corsista();
				cor.setCodCorsista(rs.getLong(1));
				cor.setNomeCorsista(rs.getString(2));
				cor.setCognomeCorsista(rs.getString(3));
				cor.setPrecedentiFormativi(rs.getInt(4));
			} 
			
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return cor;
		
	}
}
