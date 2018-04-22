package model.presentation.implementation;

/** Model van MVC 
 *  Bridge pattern: slide item drawing is de 'implementor' van het bridge pattern
 *  Adapter pattern: de target definieert de domein specifieke interface
 *************************************************************************************************************************
 * 	De abstracte klas voor het definieren van de implementatie interface van een slide item.
 *  De implementatie is de visuele weergave of tekenwijze op de componenten van de grafische omgeving.
 *  Niet te verwarren met de teken stijl van slide items. De teken stijl geeft specifieke eigenschappen zoals bv de kleur.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class SlideItemDrawing {

	protected SlideItemDrawingContext slideItemDrawingContext;
	protected Style style;
	
	/**
	 * Constructor
	 * Initialisatie
	 */
	public SlideItemDrawing()
	{
		slideItemDrawingContext = SlideItemDrawingContext.getInstance();
	}
	
	/**
	 * De methode zet de teken stijl op basis van de level van de slide item.
	 * @param level de level van het slide item.
	 */
	public void setStyle(int level) 
	{
		this.style = StyleFactory.getFlyweight(level);
	}

	/**
	 * De methode geeft een string.
	 */
	public String toString() 
	{
		return "["+ style.getIndent() + "," + style.getColor() + "; " + style.getFontSize() + " on " + style.getLeading() +"]";
	}

	/**
	 * De methode tekent een bitmap item.
	 * @param imageName de naam van de afbeelding.
	 */
	public abstract void drawBitmapItem(String imageName);
	
	/**
	 * De methode tekent een text item.
	 * @param text de tekst van het text item.
	 */
	public abstract void drawTextItem(String text);	
	
	/**
	 * De methode tekent een slide.
	 * @param title de titel van de slide.
	 */
	public abstract void drawSlide(String title);
	
}
