package controller;

/** Controller van MVC 
 * 	Command pattern: concreet FileExit command 
 *  Definieren van een binding met de receiver 
 *  Factory methode: een concreet product
 ******************************************************
 * 	Het commando voor het stoppen van de applicatie.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class FileExitCommand implements Command{

	private Receiver receiver;
	private int exitNumber;
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param receiver kent de juiste operatie.
	 * @param exitNumber informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
	 */
	public FileExitCommand(Receiver receiver, int exitNumber)
	{
		this.receiver = receiver;
		this.exitNumber = exitNumber;
	}
	
	/**
	 * De methode voert de operatie mbv de receiver uit.
	 */
	@Override
	public void execute()
	{
		receiver.fileExit(exitNumber);
	}
	
}
