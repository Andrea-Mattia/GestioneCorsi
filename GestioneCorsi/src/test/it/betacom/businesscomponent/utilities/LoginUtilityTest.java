package test.it.betacom.businesscomponent.utilities;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.utilities.LoginUtility;

class LoginUtilityTest {
    private static LoginUtility login;

    @BeforeEach
    void setUp() throws Exception {
        login = new LoginUtility();
    }

    @Test
    void testGetPass() {

        try {
            String stringa = login.getAdminPass("Betacom");

            System.out.println("Password: " + stringa);
        } catch (DAOException exc) {
            exc.printStackTrace();
            fail("Get password fallito: " + exc.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
    }

}