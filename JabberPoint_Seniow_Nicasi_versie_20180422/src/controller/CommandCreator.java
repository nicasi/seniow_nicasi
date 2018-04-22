package controller;

/** Controller van MVC 
 * 	Factory method pattern: declareren van de factory methoden  
 **********************************************************************************
 * 	De concrete command creator initialiseert en creeert concrete command objecten.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class CommandCreator {

	/**
	 * De methode initialiseert en creeert een FileExitCommand object.
	 * @param receiver kent de juiste operatie.
	 * @param exitNumber informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
	 * @return Command object.
	 */
	public static Command createFileExitCommand(Receiver receiver, int exitNumber) 
	{
		return new FileExitCommand(receiver, exitNumber);
	}

	/**
	 * De methode initialiseert en creeert een FileNewCommand object.
	 * @param receiver kent de juiste operatie.
	 * @return Command object.
	 */
	public static Command createFileNewCommand(Receiver receiver) 
	{
		return new FileNewCommand(receiver);
	}

	/**
	 * De methode initialiseert en creeert een FileOpenCommand object.
	 * @param receiver kent de juiste operatie.
	 * @param fileName de naam van de file.
	 * @return Command object.
	 */
	public static Command createFileOpenCommand(Receiver receiver, String fileName) 
	{
		return new FileOpenCommand(receiver, fileName);
	}

	/**
	 * De methode initialiseert en creeert een FileSaveCommand object.
	 * @param receiver kent de juiste operatie.
	 * @param fileName de naam van de file.
	 * @return Command object.
	 */
	public static Command createFileSaveCommand(Receiver receiver, String fileName) 
	{
		return new FileSaveCommand(receiver, fileName);
	}

	/**
	 * De methode initialiseert en creeert een ViewGotoCommand object.
	 * @param receiver kent de juiste operatie.
	 * @param pageNumber het nummer van de slide.
	 * @return Command object.
	 */
	public static Command createViewGotoCommand(Receiver receiver, int pageNumber) 
	{
		return new ViewGotoCommand(receiver, pageNumber);
	}

	/**
	 * De methode initialiseert en creeert een ViewNextCommand object.
	 * @param receiver kent de juiste operatie.
	 * @return Command object.
	 */
	public static Command createViewNextCommand(Receiver receiver) 
	{
		return new ViewNextCommand(receiver);
	}

	/**
	 * De methode initialiseert en creeert een ViewPrevCommand object.
	 * @param receiver kent de juiste operatie.
	 * @return Command object.
	 */
	public static Command createViewPrevCommand(Receiver receiver) 
	{
		return new ViewPrevCommand(receiver);
	}
	
	/**
	 * De methode initialiseert en creeert een AddSlideContentCommand object.
	 * @param receiver kent de juiste operatie.
	 * @return Command object.
	 */
	public static Command createAddSlideContentCommand(Receiver receiver)
	{
		return new AddSlideContentCommand(receiver);
	}
	
	/**
	 * De methode initialiseert en creeert een RemoveSlideContentCommand object.
	 * @param receiver kent de juiste operatie.
	 * @return Command object.
	 */
	public static Command createRemoveSlideContentCommand(Receiver receiver)
	{
		return new RemoveSlideContentCommand(receiver);
	}
}
