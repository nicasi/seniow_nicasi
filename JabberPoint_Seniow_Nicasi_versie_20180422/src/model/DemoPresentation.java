package model;

import model.presentation.abstraction.Presentation;

/** Model van MVC 
 ******************************************************
 * 	De abstracte klas voor een demo presentatie.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class DemoPresentation {

	protected Presentation presentation;
	
	/**
	 * De methode construeert een demo presentatie.
	 * @param presentation de presentatie.
	 * @return Presentation object.
	 */
	public abstract Presentation constructPresentation(Presentation presentation);
	
}
