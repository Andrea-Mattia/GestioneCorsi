package it.betacom.businesscomponent.facade;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.CorsistaCorsoBC;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.CorsistaCorso;
import it.betacom.businesscomponent.model.Corso;

public class AdminFacade {
	private static AdminFacade aF;
	private static CorsistaBC cBC;
	private static CorsoBC corsoBC;
	private static CorsistaCorsoBC ccBC;
	
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
	
	public Corsista getByIdCorsista(long id) throws DAOException, ClassNotFoundException, IOException {
		cBC = new CorsistaBC();
		return cBC.getByID(id);
	}
	
	public void createCorso(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.create(corso);
	}
	
	public void updateCorso(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.update(corso);
	}
	
	public void deleteCorso(long id) throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.delete(id);
	}
	
	public Corso[] getCorsi() throws ClassNotFoundException, DAOException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getCorso();
	}
	
	public void createCorsistaCorso(CorsistaCorso corsistaCorso) throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsistaCorsoBC();
		ccBC.create(corsistaCorso);
	}
	
	public void deleteCorsistaCorso(long id, long id2) throws ClassNotFoundException, DAOException, IOException {
		ccBC = new CorsistaCorsoBC();
		ccBC.delete(id, id2);
	}
}