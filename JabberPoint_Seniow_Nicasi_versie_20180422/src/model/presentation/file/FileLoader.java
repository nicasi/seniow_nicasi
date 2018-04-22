package model.presentation.file;

import model.presentation.abstraction.Presentation;

/** Model van MVC 
 *  Adapter pattern: de target definieert de domein specifieke interface
 ***********************************************************************
 * 	De abstracte klas voor het laden van XML bestanden. 
 *  XML bestanden kunnen geladen worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/  
public abstract class FileLoader {

	protected Presentation presentation;
	
	/**
	 * De methode laadt een bestand.
	 * @param presentation de presentatie
	 * @param filename de naam van het bestand.
	 */
	public abstract Presentation loadFile(Presentation presentation, String filename);
	
}
