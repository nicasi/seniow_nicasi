package controller;

import model.presentation.PresentationFacade;

/** Controller van MVC 
 * 	Command pattern: concreet presentation receiver 
 *  Kent de operaties om de geassocieerde commando's uit te voeren.
 ******************************************************************
 * 	De concrete presentatie receiver.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class PresentationReceiver implements Receiver {

	private PresentationFacade presentationFacade;
	
	/**
	 * Constructor
	 * Initialiseren 
	 * @param presentationFacade de presentatie facade
	 */
	public PresentationReceiver(PresentationFacade presentationFacade)
	{
		this.presentationFacade = presentationFacade;
	}
	
	@Override
	public void fileOpen(String fileName) 
	{
		presentationFacade.clearPresentation();
		presentationFacade.loadPresentation(fileName);
		presentationFacade.setSlideNumber(0);
	}

	@Override
	public void fileSave(String fileName) 
	{
		presentationFacade.savePresention(fileName);
	}

	@Override
	public void fileNew() 
	{	
		presentationFacade.clearPresentation();	
	}

	@Override
	public void fileExit(int exitNumber)  
	{
		presentationFacade.exit(exitNumber);	
	}

	@Override
	public void viewNext() 
	{
		presentationFacade.nextSlide();	
	}

	@Override
	public void viewPrev() 
	{		
		presentationFacade.prevSlide();
	}

	@Override
	public void viewGoto(int pageNumber) 
	{
		if(pageNumber<=presentationFacade.getTotalSlides() && pageNumber > 0)
		{
		presentationFacade.setSlideNumber(pageNumber - 1);
		}
	}

	@Override
	public void addSlideContent() 
	{
		presentationFacade.addSlideContent();
	}

	@Override
	public void removeSlideContent() 
	{
		presentationFacade.removeSlideContent();
	}
}
