package model.presentation.file;

/** Model van MVC 
 * 	Factory method pattern: 'abstract file saver creator' declareren van de factory methode 
 ******************************************************************************************
 * 	De abstracte klas declareert de factory methode.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class FileSaverCreator {

	/**
	 * De methode geeft en creeert een file saver creator object.
	 * @param fileLoaderCreators de enumeratie waarde voor een creator.
	 * @return FileSaverCreator object.
	 */
	public static FileSaverCreator getFileSaverCreator(FileLoaderCreators fileLoaderCreators)
	{
		switch(fileLoaderCreators) {
		   case XMLFILELOADER :
		      return new XMLFileSaverCreator();
		   default : return null;
		}
	}
	
	/**
	 * De methode geeft en creeert een file saver object. 
	 * @return FileSaver object.
	 */
	public abstract FileSaver createFileSaver();
	
}
