package it.betacom.businesscomponent.idgenerator;
import java.io.IOException;

import it.betacom.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException, DAOException, IOException; //per gestire gli id da inserire all'interno della tabella
	
}