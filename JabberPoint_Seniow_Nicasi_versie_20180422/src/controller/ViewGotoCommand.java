package controller;

/** Controller van MVC 
 * 	Command pattern: concreet ViewGoto command 
 *  Definieren van een binding met de receiver 
 *  Factory methode: een concreet product
 **********************************************************
 * 	Het commando om een slide te tonen met het slidenummer.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class ViewGotoCommand implements Command{

	private Receiver receiver;
	private int pageNumber;
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param receiver kent de juiste operatie.
	 * @param receiver het slidenummer.
	 */
	public ViewGotoCommand(Receiver receiver, int pageNumber)
	{
		this.receiver = receiver;
		this.pageNumber = pageNumber;
	}
	
	/**
	 * De methode voert de operatie mbv de receiver uit.
	 */
	@Override
	public void execute()
	{
		receiver.viewGoto(pageNumber);
	}
	
}
