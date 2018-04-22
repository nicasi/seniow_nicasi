package model.presentation.abstraction;

/** Model van MVC 
 * 	Composite pattern: text item is een 'leaf' of een 'child' object in het composite pattern
 *  Bridge pattern: text item is een verfijning van de abstractie slide item
 ****************************************************************************************************
/** <p>De concrete klas van een text of slide item<p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/  
public class TextItem extends SlideItem {
	
	private String text;
	
	/**
	 * Constructor
	 * Initialisatie
	* @param level de level waarmee de teken stijl bepaald kan worden 0-4.
  	* @param name de tekst van het text item.
	 */
	public TextItem(int level, String string) 
	{
		super(level);
		text = string;
	}

	/**
	 * Constructor
	 * Initialisatie: standaard tekst = "NO text given."
	 */
	public TextItem() 
	{
		super();
		this.text = "No text given.";
	}

	/**
	 * De methode geeft de tekst van het tekst item.
	 * @return
	 */
	public String getText() 
	{
		return text == null ? "" : text;
	}
	
	@Override
	public void draw() 
	{
		drawTextItem(text);
	}
}
