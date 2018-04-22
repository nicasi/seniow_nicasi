package model.presentation.abstraction;

import java.util.ArrayList;

import model.presentation.implementation.SlideItemDrawing;

/** Model van MVC 
 * Decorator pattern: concrete component het object waar gedrag dynamisch moet worden aan toegevoegd
 * Singleton : definieren van een uniek object van de klas Presentation
 ****************************************************************************************************
 * <p>Presentation beheerd de slides in de presentatie.</p>
 * <p>Er is slechts één instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class Presentation implements PresentationComponent{
	
	private SlideItemDrawing slideItemDrawing;  //Teken stijl van de presetatie.
	private String showTitle; 					//De titel van de presentatie.
	private ArrayList<Slide> showList = null; 	//Een ArrayList met de slides.
	private int currentSlideNumber = 0; 		//Het slidenummer van de huidige slide.
	private static Presentation instance;
	
	/**
	 * Constructor
	 * Initialisatie
	 */
	private Presentation() 
	{
		clear();
	}
	
	/**
	 * De methode creeert en geeft een uniek object van deze klas.
	 * @return Presentation object
	 */
	public static Presentation getInstance()
	{
		if(instance==null) instance = new Presentation();
		return instance;
	}
	
	/**
	 * De methode zet de implementatie tekenwijze van slide items.
     * Niet te verwarren met de stijl van een slide item op basis van het attribuut level.
	 * @param slideItemDrawing de implementatie tekenwijze.
	 */
	public void setSlideItemDrawing(SlideItemDrawing slideItemDrawing)
	{
		this.slideItemDrawing = slideItemDrawing;
	}
	
	/**
	 * De methode geeft de implementatie tekenwijze van slide items.
	 * @return SlideItemDrawing object.
	 */
	public SlideItemDrawing getSlideItemDrawing()
	{
		return slideItemDrawing;
	}
	
	/**
	 * De methode geeft de titel van de presentatie.
	 * @return String de titel van de presentatie.
	 */
	public String getTitle() 
	{
		return showTitle;
	}

	/**
	 * De methode zet de titel van de presentatie.
	 * @param nt de titel van de presentatie.
	 */
	public void setTitle(String nt) 
	{
		showTitle = nt;
	}

	/**
	 * De methode geeft de nummer van de huidige slide van de presentatie.
	 * @return int het nummer van de huidige slide van de presentatie.
	 */
	public int getSlideNumber() 
	{
		return currentSlideNumber;
	}
	
	/**
	 * De methode zet de huidige slide met gegeven nummer.
	 * @param number de nummer van de slide.
	 */
	public void setSlideNumber(int number) 
	{
		currentSlideNumber = number;
	}

	/**
	 * De methode zet de vorige slide.
	 */
	public void prevSlide() 
	{
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
	    }
	}

	/**
	 * De methode zet de volgende slide.
	 */
	public void nextSlide() 
	{
		if (currentSlideNumber < (showList.size()-1)) 
		{
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	@Override
	public void clear() 
	{
		showList = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	@Override
	public void append(Slide slide) 
	{
		showList.add(slide);
	}

	@Override
	public void append(int index, Slide slide)
	{
		showList.add(index, slide);
	}
	
	@Override
	public void remove(Slide slide) 
	{
		showList.remove(slide);	
	}
	
	@Override
	public ArrayList<Slide> getSlides()
	{
		return showList;
	}
	
	@Override
	public int getSize() 
	{
		return showList.size();
	}
	
	@Override
	public Slide getSlide(int number) 
	{
		if (number < 0 || number >= getSize())
		{
			return null;
	    }
			return (Slide)showList.get(number);
	}

	/**
	 * De methode geeft de huidige slide.
	 * @return Slide object.
	 */
	public Slide getCurrentSlide() 
	{
		return getSlide(currentSlideNumber);
	}

	/** 
     * De methode stopt de applicatie.
     * @param n informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
     */
	public void exit(int n) 
	{
		System.exit(n);
	}
}
