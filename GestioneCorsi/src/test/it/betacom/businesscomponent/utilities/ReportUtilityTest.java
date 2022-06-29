package test.it.betacom.businesscomponent.utilities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.utilities.ReportUtility;

class ReportUtilityTest {
	ReportUtility rU;
	@BeforeEach
	void setUp() throws Exception {
		rU = new ReportUtility();
	}
	

	@Test
	void testGetDocenti() {
		try {
			Vector<String[]> lista = rU.getCorsiDocenti();
			for (String[] a : lista) {
				for (String s : a) {
					System.out.println("dato: " + s);
				}
			}
			assertNotNull(lista);

		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getDocenti" + e.getMessage());
		}
	}
	
	
	@Test
	void testGetCorsiDisponibili() {
		System.out.println("###############################################################################");
		try {
			Vector<String[]> lista2 = rU.getCorsiDisponibili();
			for (String[] a : lista2) {
				for (String s : a) {
					System.out.println("dato: " + s);
				}
			}
			assertNotNull(lista2);

		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiDisponibili" + e.getMessage());
		}
	}
	
	@Test
	void testGetCorsiPopolari() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {
			Vector<String[]> lista3 = rU.getCorsiPopolari();
			for (String[] a : lista3) {
				for (String s : a) {
					System.out.println("dato: " + s);
				}
			}
			assertNotNull(lista3);
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiPopolari" + e.getMessage());
		}
	}
	
	@Test
	void testGetAverage() throws ParseException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {
			System.out.println("media durata corso: " + rU.getAvgDurata());
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiPopolari" + e.getMessage());
		}
	}
	
	@Test
	void testGetNumCorsisti() throws ParseException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {
			System.out.println("Totale Corsisti: " + rU.getCorsistiNum());
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiPopolari" + e.getMessage());
		}
	}
	
	@Test
	void testGetNumCommenti() throws ParseException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {
			System.out.println("Totale Commenti: " + rU.getCommentiNum());
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiPopolari" + e.getMessage());
		}
	}
	
	@Test
	void testGetUltimoCorso() throws ParseException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		try {
			Vector<String[]> lista3 = rU.getLastCourse();
			for (String[] a : lista3) {
				for (String s : a) {
					System.out.println("Dato ultimo corso: " + s);
				}
			}
			assertNotNull(lista3);
			
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Eccezione dovuta al getCorsiPopolari" + e.getMessage());
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}

}