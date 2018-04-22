package model.presentation.abstraction;

import java.util.ArrayList;

/** Model van MVC 
 * 	Decorator pattern: de decorator heeft een referentie naar het component en kan gedrag dynamisch toevoegen
 ************************************************************************************************************
 * 	De presentatie decorator klas.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class PresentationDecorator implements PresentationComponent{

	private PresentationComponent presentationComponent;
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param presentationComponent het presentatie component.
	 */
	public PresentationDecorator(PresentationComponent presentationComponent)
	{
		this.presentationComponent = presentationComponent;
	}
	
	@Override
	public void clear() 
	{
		presentationComponent.clear();
	}

	@Override
	public void append(Slide slide) 
	{
		presentationComponent.append(slide);
	}
	
	@Override
	public void append(int index, Slide slide)
	{
		presentationComponent.append(index, slide);
	}
	
	@Override
	public Slide getSlide(int number) 
	{
		return presentationComponent.getSlide(number);
	}
	
	@Override
	public void remove(Slide slide) 
	{
		presentationComponent.remove(slide);	
	}
	
	@Override
	public ArrayList<Slide> getSlides()
	{
		return presentationComponent.getSlides();
	}
	
	@Override
	public int getSize() 
	{
		return presentationComponent.getSize();
	}
}
