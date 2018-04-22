package model.presentation.implementation;

/** Model van MVC 
 * 	Builder pattern: abstracte interface voor het 'builden' van een concreet 'slide item drawing' object.
 ********************************************************************************************************
 * 	De abstracte klas voor het creeren van een slide item drawing object.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class SlideItemDrawingBuilder {
	
	/**
	 * De methode geeft en creeert een slide item drawing builder.
	 * @param slideItemDrawingBuilder enumeratie waarde van een gegeven slide item drawing builder.
	 * @return SlideItemDrawingBuilder object
	 */
	public static SlideItemDrawingBuilder getSlideBuilder(SlideItemDrawingBuilders slideItemDrawingBuilder)
	{
		switch(slideItemDrawingBuilder) {
		   case SLIDEITEMDRAWINGBUILDERA :
		      return new SlideItemDrawingBuilderA();
		   default : return null;
		}
	}
	
	/**
	 * De methode creeert een slide item drawing object.
	 */
	public abstract void buildSlideItemDrawing();
	
	/**
	 * De methode voegt een text item drawing adaptee toe, aan het slide item drawing object.
	 */
	public abstract void addTextItemDrawingAdaptee();
	
	/**
	 * De methode voegt een bitmap item drawing adaptee toe, aan het slide item drawing object.
	 */
	public abstract void addBitmapItemDrawingAdaptee();
	
	/**
	 * De methode geeft een slide item drawing object.
	 * @param SlideItemDrawing object
	 */
	public abstract SlideItemDrawing getSlideItemDrawing();
}
