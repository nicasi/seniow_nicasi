package model.presentation.abstraction;

import model.presentation.implementation.SlideItemDrawing;

/** Model van MVC 
 * 	Composite pattern: slide item is het 'component' van de composite pattern
 *  Bridge pattern: slide item is de 'abstraction' van het bridge pattern
 ****************************************************************************************************
/** <p>De abstracte klas van een slide item<p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class SlideItem {
	
	//Bereik van 0-4
	private int level;
	private Presentation presentation;
	protected SlideItemDrawing slideItemDrawing;
	
	/**
	 * Constructor
	 * Initialisatie: standaard is level 0.
	 */
	public SlideItem() 
	{
		this(0);
	}

	/**
	 * Constructor
	 * Initialisatie
	 * @param level de level bepaalt teken eigenschappen en bepaalt de stijl van het slide item in de implementatie.
	 */
	public SlideItem(int level) 
	{
		this.level = level;	
		this.presentation = Presentation.getInstance();
		this.slideItemDrawing = this.presentation.getSlideItemDrawing();
	}

	/**
	 * De methode zet het level 0-4. De level bepaalt de (tekenstijl) van het slide item in de implementatie.
	 * @return int het level.
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * De methode tekent het slide item.
	 */
	public abstract void draw();
	
	/**  
	 * De methode tekent het slide item als text item.
	 * @param text de tekst van het slide item.
	 */
	protected void drawTextItem(String text) 
	{
		slideItemDrawing.setStyle(level);
		slideItemDrawing.drawTextItem(text);
	}
	
	/**
	 * De methode tekent het slide item als bitmap item.
	 * @param imageName de naam van de afbeelding.
	 */
	protected void drawBitmapItem(String imageName) 
	{
		slideItemDrawing.setStyle(level);
		slideItemDrawing.drawBitmapItem(imageName);
	}
	
	/**
	 * De methode tekent het slide item als slide.
	 * @param title de titel van de slide.
	 */
	protected void drawSlide(String title) 
	{
		slideItemDrawing.setStyle(level);
		slideItemDrawing.drawSlide(title);
	}	
}
