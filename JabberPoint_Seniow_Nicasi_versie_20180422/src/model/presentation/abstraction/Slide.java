package model.presentation.abstraction;

import java.util.Vector;

/** Model van MVC 
 * 	Composite pattern: slide is de 'composite' van de composite pattern
 *  De specifieke methoden voor een composite pattern zijn geimplementeerd in de 'composite'( klas Slide)
 *  van het composite pattern en niet in de abstracte klas SlideItem.
 *  Bridge pattern: slide is de 'abstraction' van het bridge pattern
 *  Builder pattern: een product
 ****************************************************************************************************
/** <p>De concrete klas van een slide of slide item en bevat alle slide items<p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class Slide extends SlideItem{
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	private String title; //De titel wordt apart bewaard
	private String subject; // Het onderwerp van de slide
	private int levelSubject; //de level van het subject
	protected Vector<SlideItem> items; //De slide items worden in een Vector bewaard.

	/**
	 * Constructor
	 * Initialisatie
	 */
	public Slide() 
	{
		items = new Vector<SlideItem>();
	}
	
	/**
	 * De methode geeft de titel van de slide.
	 * @return de titel van de slide.
	 */
	public String getTitle() 
	{
		return title;
	}

	/**
	 * De methode zet de titel van de slide.
	 * @param newTitle de titel van de slide.
	 */
	public void setTitle(String newTitle) 
	{
		title = newTitle;
	}
	
	/**
	 * De methode geeft het onderwerp van de slide.
	 * @return String het onderwerp van de slide.
	 */
	public String getSubject()
	{
		return subject;
	}
	
	/**
	 * De methode zet het onderwerp van de slide.
	 * @param subject het onderwerp van de slide.
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	/**
	 * De methode geeft de waarde van de level van het subject.
	 * @return int de waarde van de level van het subject.
	 */
	public int getLevelSubject()
	{
		return levelSubject;
	}
	
	/**
	 * De methode zet de waarde van de level van het subject.
	 * @param levelSubject de waarde van de level van het subject.
	 */
	public void setLevelSubject(int levelSubject)
	{
		this.levelSubject = levelSubject;
	}
	
	/**
	 * De methode voegt een slide item aan de slide toe.
	 * @param anItem het slide item.
	 */
	public void append(SlideItem anItem) 
	{
		items.addElement(anItem);
	}
	
	/**
	 * De methode verwijdert een slide item.
	 * @param anItem het slide item.
	 */
	public void remove(SlideItem anItem)
	{
		items.remove(anItem);
	}	
	
	/**
	 * De methode geeft het slide item op basis van de nummer in de lijst.
	 * @param number de nummer in de lijst van slide items.
	 * @return SlideItem object
	 */
	public SlideItem getSlideItem(int number) 
	{
		return (SlideItem)items.elementAt(number);
	}

	/**
	 * De methode geeft alle slide items.
	 * @return Vector<SlideItem> object.
	 */
	public Vector<SlideItem> getSlideItems() 
	{
		return items;
	}

	/**
	 * De methode geeft de grootte van lijst van slide items.
	 * @return int de grootte van de lijst van slide items
	 */
	public int getSize() 
	{
		return items.size();
	}
	
	/**
	 * De methode tekent de slide. 
	 */
	public void drawSlide()
	{
		this.draw();
		for (SlideItem slideItem : items)
		{
			slideItem.draw();
		}
	}
	
	@Override
	public void draw() 
	{
		drawSlide(title);
	}

}
