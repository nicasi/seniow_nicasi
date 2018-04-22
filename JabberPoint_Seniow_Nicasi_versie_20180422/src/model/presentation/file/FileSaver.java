package model.presentation.file;

import model.presentation.abstraction.Presentation;

/** Model van MVC 
 *  Adapter pattern: de target definieert de domein specifieke interface
 ***********************************************************************
 * 	De abstracte klas voor het bewaren van XML bestanden. 
 *  XML bestanden kunnen bewaard worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/ 
public abstract class FileSaver {

	protected Presentation presentation;
	
	/**
	 * De methode bewaart een bestand.
	 * @param presentation de presentatie
	 * @param filename de naam van het bestand.
	 */
	public abstract void saveFile(Presentation presentation, String filename);
	
}
