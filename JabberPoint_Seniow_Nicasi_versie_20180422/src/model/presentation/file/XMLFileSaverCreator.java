package model.presentation.file;

/** Model van MVC 
 * 	Factory method pattern: 'concreet file saver creator' declareren van de factory methode 
 *******************************************************************************************
 * 	De concrete klas specifieert de factory methode. 
 *  XML bestanden kunnen bewaard worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class XMLFileSaverCreator extends FileSaverCreator{

	@Override
	public FileSaver createFileSaver() 
	{	
		return new XMLFileSaver(new XMLAccessor());		
	}
}
