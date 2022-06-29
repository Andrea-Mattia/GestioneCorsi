package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.adapter.AdapterDAO;
import it.betacom.businesscomponent.model.CorsistaCorso;

public class CorsistaCorsoDAO extends AdapterDAO<CorsistaCorso> implements DAOConstants {

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
    public void create(Connection conn, CorsistaCorso entity) throws DAOException {

        try {
            rowSet.setCommand(SELECT_CORSISTA_CORSO);
            rowSet.execute(conn);

            rowSet.moveToInsertRow();
            rowSet.updateLong(1, entity.getCodCorsista());
            rowSet.updateLong(2, entity.getCodCorso());

            rowSet.insertRow();
            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();

        } catch (SQLException sql) {
            throw new DAOException(sql);
        }
    }

    @Override
    public void delete(Connection conn, long codCorsista, long codCorso) throws DAOException {

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(DELETE_CORSISTA_CORSO);
            ps.setLong(1, codCorsista);
            ps.setLong(2, codCorso);
            ps.execute();

            conn.commit();

        } catch (SQLException sql) {
            throw new DAOException(sql);
        }
    }
}