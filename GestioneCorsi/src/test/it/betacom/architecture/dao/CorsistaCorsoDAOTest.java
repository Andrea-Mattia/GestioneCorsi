package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaCorsoDAO;
import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.CorsistaCorso;
import it.betacom.businesscomponent.model.Corso;

class CorsistaCorsoDAOTest {
	private Corsista corsista;
	private Corso corso;
	private CorsistaCorso cc;
	private Connection conn;

	@BeforeEach
	void setUp() throws Exception {  //set di dati prova
		corsista = new Corsista();
		corsista.setCodCorsista(20);
		corsista.setNomeCorsista("Giovanni");
		corsista.setCognomeCorsista("Rana");
		corsista.setPrecedentiFormativi(1);
		
		corso = new Corso();
		corso.setCodCorso(20);
		corso.setCodDocente(1);
		corso.setDataInizio(new GregorianCalendar(12,6,2022).getTime());
		corso.setDataFine(new GregorianCalendar(12,8,2022).getTime());
		corso.setCostoCorso(1200);
		corso.setCommentiCorso("figa");
		corso.setAulaCorso("EA12");
		
		cc = new CorsistaCorso();
		cc.setCodCorsista(20);
		cc.setCodCorso(20);
	}
	@Test
	void testCreate() throws ClassNotFoundException, IOException {
		try {
			CorsistaDAO.getFactory().create(DBAccess.getConnection(), corsista);
			CorsoDAO.getFactory().create(DBAccess.getConnection(), corso);
			CorsistaCorsoDAO.getFactory().create(DBAccess.getConnection(), cc);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: "+ exc.getMessage());
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		try {
			conn = DBAccess.getConnection();
			CorsistaDAO.getFactory().delete(DBAccess.getConnection(), 1);
			Statement stmt = conn.createStatement();
			stmt.executeQuery("Delete from corsista where nomecorsista = 'Giovanni'");
			conn.commit();
			stmt.close();
			Statement stmt2 = conn.createStatement();
			stmt2.executeUpdate("Delete from corsista_corso where cod_corso = 20 and cod_corsista = 20");
			conn.commit();			
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: "+ exc.getMessage());
		}
	}
}
