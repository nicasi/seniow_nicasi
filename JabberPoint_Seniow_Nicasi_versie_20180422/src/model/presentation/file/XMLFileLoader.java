package model.presentation.file;

import java.io.IOException;

import errorhandle.JabberPointException;
import model.presentation.abstraction.Presentation;

/** Model van MVC 
 *  Adapter pattern: adapter past de interface van de adaptee aan de target interface
 * 	Factory method pattern: een product 
 ************************************************************************************
 * 	De concrete klas voor het laden van XML bestanden. 
 *  XML bestanden kunnen geladen worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class XMLFileLoader extends FileLoader{

	private Accessor accessor;
	
	/**
	 * Constructor
	 * Initialisatie: de adaptee
	 */
	public XMLFileLoader(Accessor accessor) 
	{
		this.accessor = accessor;
	}
	
	@Override
	public Presentation loadFile(Presentation presentation, String filename)  {
		
		try {
				return accessor.loadFile(presentation, filename);
			} 
		catch (IOException e) 
			{
				JabberPointException.showError(e.getMessage());
			}
		return null;
	}
}
