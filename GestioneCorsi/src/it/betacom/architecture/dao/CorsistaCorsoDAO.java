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

public class CorsistaCorsoDAO extends AdapterDAO<Corsista> implements DAOConstants {

    private CachedRowSet rowSet;

    private CorsistaCorsoDAO() throws DAOException {

        try {

            rowSet = RowSetProvider.newFactory().createCachedRowSet();

        } catch (SQLException sql) {
            throw new DAOException(sql);
        }
    }

    public static CorsistaCorsoDAO getFactory() throws DAOException {
        return new CorsistaCorsoDAO();
    }

    @Override
    public void create(Connection conn, Corsista entity1, Corso entity2) throws DAOException {

        try {
            rowSet.setCommand(SELECT_CORSISTA_CORSO);
            rowSet.execute(conn);

            rowSet.moveToInsertRow();
            rowSet.updateLong(1, entity1.getCodCorsista());
            rowSet.updateLong(2, entity2.getCodCorso());

            rowSet.insertRow();
            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();

        } catch (SQLException sql) {
            throw new DAOException(sql);
        }
    }

    @Override
    public void delete(Connection conn, long idCorsista, long idCorso) throws DAOException {

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(DELETE_CORSISTA_CORSO);
            ps.setLong(1, idCorsista);
            ps.setLong(2, idCorso);
            ps.execute();

            conn.commit();

        } catch (SQLException sql) {
            throw new DAOException(sql);
        }
    }
}