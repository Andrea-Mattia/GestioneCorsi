package test.it.betacom.architecture.dao;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;

class CorsoDAOTest {
	Corso corso;
	@BeforeEach
	void setUp() throws Exception {
		corso = new Corso();
		corso.setCodCorso(10);
		corso.setCodDocente(1);
		corso.setNomeCorso("PERL");
		corso.setDataInizio(new GregorianCalendar(2022, 7, 31).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 8, 30).getTime());
		corso.setCostoCorso(500);
		corso.setCommentiCorso("Linguaggio di scripting");
		corso.setAulaCorso("A23Z");
	}

	

	@Test
	void testCreate() throws DAOException, ClassNotFoundException, IOException {
		CorsoDAO.getFactory().create(DBAccess.getConnection(), corso);
		System.out.println(corso);
		assertNotNull(corso);
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Corso " + corso.getNomeCorso() + " cancellato");
		CorsoDAO.getFactory().delete(DBAccess.getConnection(), 10);
		
	}
}
