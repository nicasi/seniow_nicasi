package model.presentation.implementation;

/** Model van MVC 
 *  Bridge pattern: slide item drawing A is de concrete 'implementor' van het bridge pattern
 *  Adapter pattern: adapter past de interface van de adaptee aan de target interface
 *************************************************************************************************************************
 * 	De concrete klas voor het definieren van de implementatie interface van een slide item.
 *  De implementatie is de visuele weergave of tekenwijze op de componenten van de grafische omgeving. 
 *  De verschillende adaptees implementeren het grafisch voorstellen van de slide items in de grafische omgeving.
 *  De context waarmee de adaptees tekenen kan gevonden worden in het slideItemDrawingContext object.
 *  Niet te verwarren met de teken stijl van slide items. De teken stijl geeft specifieke eigenschappen zoals bv de kleur.
 *  Het alfabet is genomen als aanduiding voor een specifieke implementatie, in dit geval A.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class SlideItemDrawingA extends SlideItemDrawing {
	
	//Adaptee's
	private SlideItemDrawingAdaptee textItemDrawingAdaptee;
	private SlideItemDrawingAdaptee bitMapItemDrawingAdaptee;
	
	/**
	 * De methode geeft de text item drawing adaptee.
	 * @return SlideItemDrawingAdaptee object
	 */
	public SlideItemDrawingAdaptee getTextItemDrawingAdaptee() 
	{
		return textItemDrawingAdaptee;
	}

	/**
	 * De methode zet de text item drawing adaptee.
	 * @param textItemDrawingAdaptee de text item drawing adaptee.
	 */
	public void setTextItemDrawingAdaptee(SlideItemDrawingAdaptee textItemDrawingAdaptee) 
	{
		this.textItemDrawingAdaptee = textItemDrawingAdaptee;
	}

	/**
	 * De methode geeft de bitmap item drawing adaptee.
	 * @param SlideItemDrawingAdaptee object.
	 */
	public SlideItemDrawingAdaptee getBitMapItemDrawingAdaptee() 
	{
		return bitMapItemDrawingAdaptee;
	}

	/**
	 * De methode zet de bitmap item drawing adaptee.
	 * @param bitMapItemDrawingAdaptee de bitmap item drawing adaptee
	 */
	public void setBitMapItemDrawingAdaptee(SlideItemDrawingAdaptee bitMapItemDrawingAdaptee) 
	{
		this.bitMapItemDrawingAdaptee = bitMapItemDrawingAdaptee;
	}

	
	@Override
	public void drawBitmapItem(String imageName) {
		int height;
	
		bitMapItemDrawingAdaptee.draw(imageName, 
									  slideItemDrawingContext.getArea().x, 
									  slideItemDrawingContext.getHeight(),
								   	  slideItemDrawingContext.getScale(), 
								   	  slideItemDrawingContext.getGraphics(),  style,
								   	  slideItemDrawingContext.getImageObserver());		
		height= bitMapItemDrawingAdaptee.getBoundingBox(slideItemDrawingContext.getGraphics(), 
													    slideItemDrawingContext.getImageObserver(), 
													    slideItemDrawingContext.getScale(), style).height;
		slideItemDrawingContext.setHeight(slideItemDrawingContext.getHeight()+height);
	}
	
	@Override
	public void drawTextItem(String text) {
		int height;
		textItemDrawingAdaptee.draw(text, 
									slideItemDrawingContext.getArea().x, 
									slideItemDrawingContext.getHeight(), 
									slideItemDrawingContext.getScale(),
									slideItemDrawingContext.getGraphics(), style, 
									slideItemDrawingContext.getImageObserver());
		height = textItemDrawingAdaptee.getBoundingBox(slideItemDrawingContext.getGraphics(), 
				 									   slideItemDrawingContext.getImageObserver(), 
				 									   slideItemDrawingContext.getScale(), style).height;
	    slideItemDrawingContext.setHeight(slideItemDrawingContext.getHeight()+height);
	
	}
	
	@Override
	public void drawSlide(String title) {
		int height;
		textItemDrawingAdaptee.draw(title, 
									slideItemDrawingContext.getArea().x, 
									slideItemDrawingContext.getHeight(), 
									slideItemDrawingContext.getScale(),
									slideItemDrawingContext.getGraphics(), style, 
									slideItemDrawingContext.getImageObserver());
		height = textItemDrawingAdaptee.getBoundingBox(slideItemDrawingContext.getGraphics(), 
				 									   slideItemDrawingContext.getImageObserver(), 
				 									   slideItemDrawingContext.getScale(), style).height;
	    slideItemDrawingContext.setHeight(slideItemDrawingContext.getHeight()+height);
	}
}
