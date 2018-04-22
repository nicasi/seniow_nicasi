package model.presentation.implementation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/** Model van MVC 
 *  Adapter pattern: abstracte adaptee, een bestaande interface
 ******************************************************************
 * 	De abstracte klas voor het tekenen van een text en bitmap item. 
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface SlideItemDrawingAdaptee {

	/**
	 * De methode geeft de tekenruimte van het text of bitmap item.
	 * @param g de grafische context.
	 * @param observer informatie over de afbeelding.
	 * @param scale de teken schaal.
	 * @param style de teken stijl.
	 * @return Rectangle object
	 */
	public abstract Rectangle getBoundingBox(Graphics g, 
			ImageObserver observer, float scale, Style style);

	/**
	 * De methode tekent een text of een bitmap met de gegeven context.
	 * @param information de informatie(tekst, naam afbeelding)
	 * @param x de x coordinaat van de tekenruimte.
	 * @param y de y coordinaat van de tekenruimte.
	 * @param scale de tekenschaal.
	 * @param g de grafische context.
	 * @param style de tekenstijl.
	 * @param observer informatie over de afbeelding
	 */
	public abstract void draw(String information, int x, int y, float scale, 
			Graphics g, Style style, ImageObserver observer);
	
}
