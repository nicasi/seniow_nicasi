package model.presentation.file;

import java.io.IOException;
import model.presentation.abstraction.Presentation;

/** Model van MVC 
 *  Adapter pattern: abstracte adaptee, een bestaande interface
 **************************************************************
 * 	De abstracte klas voor het laden en bewaren van bestanden. 
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class Accessor {
	
	protected Presentation presentation;
	
	/**
	 * De methode laadt een bestand en geeft een presentatie object.
	 * @param presentation de presentatie.
	 * @param filename de naam van het bestand.
	 * @return Presentation object
	 * @throws IOException object
	 */
	abstract public Presentation loadFile(Presentation presentation, String filename) throws IOException;
	
	/**
	 * De methode bewaart een bestand.
	 * @param presentation de presentatie.
	 * @param filename de naam van het bestand.
	 * @throws IOException object
	 */
	abstract public void saveFile(Presentation presentation, String filename) throws IOException;

}
