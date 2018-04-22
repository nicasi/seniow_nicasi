package model.presentation.implementation;

/** Model van MVC 
 * 	Builder pattern: concrete interface voor het 'builden' van een concreet 'slide item drawing' object.
 ********************************************************************************************************
 * 	De concrete klas voor het creeren van een slide item drawing object.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class SlideItemDrawingBuilderA extends SlideItemDrawingBuilder{

	private SlideItemDrawingA slideItemDrawingA;
	
	@Override
	public void buildSlideItemDrawing() {
		
		slideItemDrawingA = new SlideItemDrawingA();
	}

	@Override
	public void addTextItemDrawingAdaptee() {
		
		slideItemDrawingA.setTextItemDrawingAdaptee(new TextItemDrawingAdaptee());
	}

	@Override
	public void addBitmapItemDrawingAdaptee() {
		
		slideItemDrawingA.setBitMapItemDrawingAdaptee(new BitmapItemDrawingAdaptee());
	}

	@Override
	public SlideItemDrawing getSlideItemDrawing() {
		
		return slideItemDrawingA;
	}
}
