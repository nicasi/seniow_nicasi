package model.presentation;

/** Model van MVC 
 * 	Observer pattern: subject 
 *******************************************************
 * 	Het subject geeft een interface om observers: toe te voegen, te verwijderen en op de hoogte te houden.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface PresentationObservable {

	/**
	 * De methode voegt een observer toe.
	 * @param presentationObserver toe te voegen observer.
	 */
	public void attach(PresentationObserver presentationObserver);
	
	/**
	 * De methode verwijdert een observer.
	 * @param presentationObserver te verwijderen observer.
	 */
	public void detach(PresentationObserver presentationObserver);
	
	/**
	 * De methode houdt de observers op de hoogte
	 * @param presentationFacade de presentatie facade.
	 */
	public void notifyObservers(PresentationFacade presentationFacade);
	
}
