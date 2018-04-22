package controller;

/** Controller van MVC 
 * 	Command pattern: de interface voor 'executing' een operatie
 **************************************************************
 * 	De interface van uitvoeren van operaties.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface Command {

	/**
	 * De methode 'executes' een operatie.
	 */
	public void execute();

}
