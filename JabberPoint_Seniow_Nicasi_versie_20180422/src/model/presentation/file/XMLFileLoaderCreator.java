package model.presentation.file;

/** Model van MVC 
 * 	Factory method pattern: 'concreet file loader creator' declareren van de factory methode 
 *******************************************************************************************
 * 	De concrete klas specifieert de factory methode. 
 *  XML bestanden kunnen geladen worden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class XMLFileLoaderCreator extends FileLoaderCreator{

	@Override
	public FileLoader createFileLoader() {
		
		return new XMLFileLoader(new XMLAccessor());
	}

	
}
