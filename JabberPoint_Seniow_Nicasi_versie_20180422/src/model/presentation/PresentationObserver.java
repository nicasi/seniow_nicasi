package model.presentation;

/** Model van MVC 
 * 	Observer pattern: observer 
 *******************************************************
 *  De observer definieert de 'updating' interface voor objecten,
 *  die op de hoogte gehouden moeten worden door veranderingen in het subject.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface PresentationObserver {

	/**
	 * De methode 'updates' het subject.	
	 * @param presentationFacade de presentatie facade.
	 */
	public void update(PresentationFacade presentationFacade);
	
}
