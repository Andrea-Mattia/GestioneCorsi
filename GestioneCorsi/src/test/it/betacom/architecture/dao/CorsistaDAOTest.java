package test.it.betacom.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {

	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();

		corsista = new Corsista();

		corsista.setCodCorsista(6);
		corsista.setNomeCorsista("Giuseppe");
		corsista.setCognomeCorsista("Giangi");
		corsista.setPrecedentiFormativi(1);

	}

	@Test
	@Order(1)
	void testCreate() {

		try {

			CorsistaDAO.getFactory().create(conn, corsista);

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Eccezione dovuta al create: " + exc.getMessage());
		}

	}

	@Test
	@Order(2)
	void testUpdate() {

		try {

			corsista = new Corsista();
			corsista.setCodCorsista(13);
			corsista.setNomeCorsista("Fabio");
			corsista.setCognomeCorsista("Volo");
			corsista.setPrecedentiFormativi(0);

			CorsistaDAO.getFactory().update(conn, corsista);
			System.out.println("Aggiornato Corsista: " + corsista);

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Update fallito: " + exc.getMessage());
		}

	}

	@Test
	@Order(3)
	void testGetCorsisti() {

		try {

			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);

			
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Get all fallito: " + exc.getMessage());
		}

	}

	@Test
	@Order(4)
	void testSearcCorsisti() {

		try {

			Corsista[] corsisti = CorsistaDAO.getFactory().searchCorsista(conn, "r");
			assertNotNull(corsisti);

			for (Corsista cor : corsisti)
				System.out.println("Corsista: " + cor.getCodCorsista() + " " + cor.getNomeCorsista() + " "
						+ cor.getCognomeCorsista() + " " + cor.getPrecedentiFormativi());

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Get all fallito: " + exc.getMessage());
		}

	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {

		try {

			CorsistaDAO.getFactory().delete(conn, 13);

			System.out.println("Corsista eliminato");

			DBAccess.closeConnection();

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Metodo di pulizia fallito: " + exc.getMessage());
		}
	}

}