package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
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
	
	@BeforeEach
	void setUp() throws Exception {  
		corsista = new Corsista();
		corsista.setCodCorsista(13);
		corsista.setNomeCorsista("Giovanni");
		corsista.setCognomeCorsista("Rana");
		corsista.setPrecedentiFormativi(1);
		
		
		corso = new Corso();
		corso.setCodCorso(10);
		corso.setCodDocente(1);
		corso.setNomeCorso("PERL");
		corso.setDataInizio(new GregorianCalendar(2022, 7, 31).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 8, 30).getTime());
		corso.setCostoCorso(500);
		corso.setCommentiCorso("Linguaggio di scripting");
		corso.setAulaCorso("A23Z");
		
		
		cc = new CorsistaCorso();
		cc.setCodCorsista(corsista.getCodCorsista());
		cc.setCodCorso(corso.getCodCorso());
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
			CorsistaDAO.getFactory().delete(DBAccess.getConnection(), 13);
			CorsoDAO.getFactory().delete(DBAccess.getConnection(), 10);
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: "+ exc.getMessage());
		}
	}
}
