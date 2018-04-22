package controller;

/** Controller van MVC 
 * 	Command pattern: concreet FileSave command 
 *  Definieren van een binding met de receiver 
 *  Factory methode: een concreet product
 ******************************************************
 * 	Het commando voor het bewaren van een bestand.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class FileSaveCommand implements Command{

	private Receiver receiver;
	private String fileName;
	
	/**
	 * De methode bewaart een bestand.
	 * @param receiver kent de juiste operatie.
	 * @param fileName de naam van de file.
	 */
	public FileSaveCommand(Receiver receiver, String fileName)
	{
		this.receiver = receiver;
		this.fileName = fileName;
	}
	
	/**
	 * De methode voert de operatie mbv de receiver uit.
	 */
	@Override
	public void execute()
	{
		receiver.fileSave(fileName);
	}
	
}
