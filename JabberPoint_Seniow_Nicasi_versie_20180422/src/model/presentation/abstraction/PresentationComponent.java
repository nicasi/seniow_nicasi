package model.presentation.abstraction;

import java.util.ArrayList;

/** Model van MVC 
 * 	Decorator pattern: het component met de interface waarbij objecten nieuwe gedrag kunnen toevoegen.
 ***************************************************************************************************************
 * 	De interface het presentatie component.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface PresentationComponent {

	/**
	 * De methode voegt een slide toe aan de presentatie.
	 * @param slide
	 */
	public void append(Slide slide);
	
	/**
	 * De methode voegt een slide toe op het gegeven nummer in de presentatie.
	 * @param index de nummer van de slide.
	 * @param slide
	 */
	public void append(int index, Slide slide);
	
	/**
	 * De methode verwijdert een slide van de presentatie.
	 * @param slide
	 */
	public void remove(Slide slide);
	
	/**
	 * De methode geeft de slide volgens nummer.
	 * @param number het nummer van de slide.
	 * @return Slide object
	 */
	public Slide getSlide(int number);
	
	/**
	 * De methode geeft de lijst van de slides.
	 * @return ArrayList<Slide> object.
	 */
	public ArrayList<Slide> getSlides();
	
	/**
	 * De methode verwijdert alle slides uit de lijst.
	 */
	public void clear();
	
	/**
	 * De methode geeft de grootte van de lijst.
	 * @return
	 */
	public int getSize();
}
