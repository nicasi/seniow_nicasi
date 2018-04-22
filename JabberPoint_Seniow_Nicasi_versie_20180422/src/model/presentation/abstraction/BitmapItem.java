package model.presentation.abstraction;

/** Model van MVC 
 * 	Composite pattern: bitmap item is een 'leaf' of een 'child' object in het composite pattern
 *  Bridge pattern: bitmap item is een verfijning van de abstractie slide item
 ****************************************************************************************************
/** <p>De concrete klas van een afbeelding of slide item<p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/ 
public class BitmapItem extends SlideItem {
	
	private String imageName;
  
  	/**
  	 * Constructor
  	 * Initialisatie 
  	 * @param level de level waarmee de teken stijl bepaald kan worden 0-4.
  	 * @param name de naam van de afbeelding.
  	 */
	public BitmapItem(int level, String imageName) 
	{
		super(level);
		this.imageName = imageName;	
	}

	/**
	 * De methode geeft de naam van de afbeelding.
	 * @return String de naam van de afbeelding.
	 */
	public String getName() 
	{
		return imageName;
	}
	
	@Override
	public void draw() 
	{
		drawBitmapItem(imageName);
	}
}
