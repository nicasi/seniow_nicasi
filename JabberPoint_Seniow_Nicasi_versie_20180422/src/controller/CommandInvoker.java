package controller;

/** Controller van MVC 
 * 	Command pattern: command invoker
 **********************************************************************
 * 	De command invoker voert de operaties uit met de commando objecten.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class CommandInvoker {

	private Receiver receiver;
	private Command command;
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param receiver kent de juiste operatie.
	 */
	public CommandInvoker(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	/**
	 * De methode voert de operatie fileExit uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 * @param exitNumber informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
	 */
	public void fileExitCommand(int exitNumber) 
	{
		command = CommandCreator.createFileExitCommand(receiver, exitNumber);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie fileNew uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 */
	public void fileNewCommand() 
	{
		command = CommandCreator.createFileNewCommand(receiver);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie fileOpen uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 * @param fileName de naam van de file.
	 */
	public void fileOpenCommand(String fileName) 
	{
		command = CommandCreator.createFileOpenCommand(receiver, fileName);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie fileSave uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 * @param fileName de naam van de file.
	 */
	public void fileSaveCommand(String fileName) 
	{
		command = CommandCreator.createFileSaveCommand(receiver, fileName);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie viewGoto uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 * @param pageNumber het nummer van de slide.
	 */
	public void viewGotoCommand(int pageNumber) 
	{
		command = CommandCreator.createViewGotoCommand(receiver, pageNumber);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie viewNext uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 */
	public void viewNextCommand() 
	{
		command = CommandCreator.createViewNextCommand(receiver);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie viewPrev uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 */
	public void viewPrevCommand() 
	{
		command = CommandCreator.createViewPrevCommand(receiver);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie addSlideContent uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 */
	public void addSlideContentCommand()
	{
		command = CommandCreator.createAddSlideContentCommand(receiver);
		command.execute();
	}
	
	/**
	 * De methode voert de operatie removeSlideContent uit met het commando object.
	 * @param receiver kent de juiste operatie.
	 */
	public void removeSlideContentCommand()
	{
		command = CommandCreator.createRemoveSlideContentCommand(receiver);
		command.execute();
	}
}
