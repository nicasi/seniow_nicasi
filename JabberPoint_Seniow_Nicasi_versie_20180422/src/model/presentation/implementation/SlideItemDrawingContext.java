package model.presentation.implementation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/** Model van MVC 
 * 	Singleton : definieren van een uniek object van de klas SlideItemDrawingContext
 ***********************************************************************************************************************
 * De klas geeft informatie over de teken context van de grafische omgeving
 * In de view kan informatie aan deze instantie gegeven worden en in het model, de implementatie, kan 
 * de informatie gebruikt worden. De informatie bevat de hoogte waarmee de verschillende slide items
 * in een slide moeten getekend worden.
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author  Seniow Andy, Kevin Nicasi
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class SlideItemDrawingContext {
	
	private static SlideItemDrawingContext instance;
	private Rectangle area;
	private int height;
	private ImageObserver imageObserver;
	private float scale;
	private Graphics graphics;
	
	private SlideItemDrawingContext() {}
	
	/**
	 * De methode creeert en geeft een unieke instantie van deze klas.
	 * @return SlideItemDrawingContext object
	 */
	public static SlideItemDrawingContext getInstance()
	{
		if (instance == null) instance = new SlideItemDrawingContext();
		return instance;
	}
	
	/**
	 * De methode zet de grafische teken context.
	 * @param graphics de grafischet teken context.
	 */
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	
	/**
	 * De methode geeft de grafische context.
	 * @return Graphics object.
	 */
	public Graphics getGraphics() 
	{
		return graphics;
	}
	
	/**
	 * De methode geeft de teken ruimte.
	 * @return Rectangle object.
	 */
	public Rectangle getArea() 
	{
		return area;
	}
	
	/**
	 * De methode zet de teken ruimte.
	 * @param area de teken ruimte.
	 */
	public void setArea(Rectangle area) 
	{
		this.area = area;
	}
	
	/**
	 * De methode geeft de hoogte van teken ruimte.
	 * @return int de hoogte van de tekenruimte.
	 */
	public int getHeight() 
	{
		return height;
	}
	
	/**
	 * De methode zet de hoogte van de teken ruimte.
	 * @param height de hoogte van de teken ruimte.
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * De methode geeft de observer van de afbeelding.
	 * ImageObserver object
	 */
	public ImageObserver getImageObserver() {
		return imageObserver;
	}
	
	/**
	 * De methode zet de observer van de afbeelding.
	 * @param imageObserver de observer.
	 */
	public void setImageObserver(ImageObserver imageObserver) {
		this.imageObserver = imageObserver;
	}
	
	/**
	 * De methode geeft de teken schaal.
	 * @return float de teken schaal.
	 */
	public float getScale() {
		return scale;
	}
	
	/**
	 * De methode zet de teken schaal.
	 * @param scale de teken schaal.
	 */
	public void setScale(float scale) 
	{
		this.scale = scale;
	}	
	
}
