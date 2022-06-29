package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void testNextId() {
		
		try {
			
			CorsistaIdGenerator idGen = CorsistaIdGenerator.getInstance();
			assertNotNull(idGen, "Istanza del generatore creata correttamente");
			
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() - 1);
			
			System.out.println(valore);
			
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("IdGenerator exception: " + exc.getMessage());
		}
		
	}

}
