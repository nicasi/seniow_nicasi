package model.presentation.file;

import java.io.IOException;

import errorhandle.JabberPointException;
import model.presentation.abstraction.Presentation;

/** Model van MVC 
 *  Adapter pattern: adapter past de interface van de adaptee aan de target interface
 * 	Factory method pattern: een product 
 ************************************************************************************
 * 	De concrete klas voor het bewaren van XML bestanden. 
 *  XML bestanden kunnen bewaard worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class XMLFileSaver extends FileSaver {

	private Accessor accessor;
	
	/**
	 * Constructor
	 * Initialisatie: de adaptee
	 * @param accessor
	 */
	public XMLFileSaver(Accessor accessor)
	{
		this.accessor = accessor;
	}
	
	@Override
	public void saveFile(Presentation presentation, String filename) 
	{
		
		try {
				accessor.saveFile(presentation, filename);
			} 
		catch (IOException e) 
			{
				JabberPointException.showError(e.getMessage());
			}
	}
}
