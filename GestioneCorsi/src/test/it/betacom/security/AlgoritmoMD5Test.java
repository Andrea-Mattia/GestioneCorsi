package test.it.betacom.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.betacom.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void testConversione() {
		
		String pass = AlgoritmoMD5.convertiMD5("Pass01$");
		assertNotNull(pass);
		
		System.out.println(pass);
	}

}
