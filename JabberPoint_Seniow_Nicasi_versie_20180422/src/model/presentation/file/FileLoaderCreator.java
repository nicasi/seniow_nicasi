package model.presentation.file;

/** Model van MVC 
 * 	Factory method pattern: 'abstract file loader creator' declareren van de factory methode 
 *******************************************************************************************
 * 	De abstracte klas declareert de factory methode.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class FileLoaderCreator {
	
	/**
	 * De methode geeft en creeert een file loader creator object.
	 * @param fileLoaderCreators de enumeratie waarde voor een creator.
	 * @return FileSaverCreator object.
	 */
	public static FileLoaderCreator getFileLoaderCreator(FileLoaderCreators fileLoaderCreators)
	{
		switch(fileLoaderCreators) {
		   case XMLFILELOADER :
		      return new XMLFileLoaderCreator();
		   default : return null;
		}
	}
	
	/**
	 * De methode geeft en creeert een file loader object. 
	 * @return FileLoader object.
	 */
	public abstract FileLoader createFileLoader();
	
}