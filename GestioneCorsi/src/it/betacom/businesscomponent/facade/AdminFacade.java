package it.betacom.businesscomponent.facade;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.model.Corsista;

public class AdminFacade {
	private static AdminFacade aF;
	private static CorsistaBC cBC;
	
	private AdminFacade() {
	}
	
	public static AdminFacade getIstance() {  //singleton
		if(aF == null) {
			aF = new AdminFacade();
		}
		return aF;
	}
	
	public void createCorsista(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		cBC.create(corsista);
	}
	
	public void updateCorsista(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		cBC.update(corsista);
	}
	
	public void deleteCorsista(long id) throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		cBC.delete(id);
	}
	
	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		return cBC.getCorsisti();
	}
	
	//aggiungere metodi di CorsoBC e CorsistaCorsoBC
}