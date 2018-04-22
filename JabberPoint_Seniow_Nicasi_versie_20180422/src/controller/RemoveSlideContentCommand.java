package controller;

/** Controller van MVC 
 * 	Command pattern: concreet FileNew command 
 *  Definieren van een binding met de receiver 
 *  Factory methode: een concreet product
 ***********************************************************************
 * 	Het commando voor het verwijderen van een slide met de inhoudsopgave.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class RemoveSlideContentCommand implements Command{

	private Receiver receiver;
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param receiver kent de juiste operatie.
	 */
	public RemoveSlideContentCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	/**
	 * De methode voert de operatie mbv de receiver uit.
	 */
	@Override
	public void execute() 
	{
		receiver.removeSlideContent();
	}

}
