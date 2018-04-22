package model.presentation.abstraction;

import java.util.ArrayList;

/** Model van MVC 
 * 	Decorator pattern: de concrete decorator voegt gedrag dynamisch toe
 ***************************************************************************************************************
 * 	De concrete decorator klas.
 *  Een nieuwe slide wordt voorzien met de onderwerpen van alle slides.
 *  Indien de vorige of de huidige slide reeds een slide is die onderwerpen toont,
 *  zal er geen nieuwe slide toegevoegd worden.
 *  Indien opeenvoldende slides hetzelfde onderwerp hebben, zal het onderwerp slechts eenmaal toegevoegd worden.
 *  Indien er verschillende slides hetzelfde onderwerp hebben, maar niet opeenvolgend zijn,
 *  zal het onderwerp herhaald worden.
 *  Een slide met als titel "Inhoudsopgave" kan verwijderd worden.
 *  Het onderwerp heeft een level om de teken stijl te bepalen.
 *  Voor de onderwerpen zijn de levels 5-8 bestemd om ideale weergave.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class ContentSlide extends PresentationDecorator{
	
	/**
	 * Constructor
	 * Initialisatie
	 * @param presentationComponent het presentatie component.
	 */
	public ContentSlide(PresentationComponent presentationComponent) 
	{
		super(presentationComponent);
	}

	@Override
	public void clear() 
	{
		super.clear();
	}

	@Override
	public void append(Slide slide) 
	{
		super.append(slide);
	}

	/**
	 * De methode voegt een slide met de onderwerpen toe na de gegeven index.
	 */
	@Override
	public void append(int index, Slide slide)
	{
		if(getSize()==0) {return;}
		String titleBeforeSlide;
		String titleAfterSlide = getSlide(index).getTitle();
		if(index==0)
		{
			titleBeforeSlide="";
		}
		else
		{
			titleBeforeSlide = getSlide(index-1).getTitle();
		}
		//De voorgaande of huidige slide mag geen slide zijn die de onderwerpen reeds toont.
		if(!titleBeforeSlide.equals("Inhoudsopgave") && !titleAfterSlide.equals("Inhoudsopgave")) 
		{
		super.append(index, addSubjects(slide));
		}
	}
	
	@Override
	public Slide getSlide(int number) 
	{
		return super.getSlide(number);
	}
	
	//Enkel slides met als titel "Inhoudsopgave" kunnen verwijdert worden.
	@Override
	public void remove(Slide slide) 
	{
		if(getSize()==0) {return;}
		if(slide.getTitle().equals("Inhoudsopgave"))
		{
		super.remove(slide);
		}
	}
	
	@Override
	public ArrayList<Slide> getSlides()
	{
		return super.getSlides();
	}
	
	@Override
	public int getSize() 
	{
		return super.getSize();
	}	
	
	//De methode controleert vooral een slide toe te voegen
	//1. Controle slide mag geen slide zijn die reeds onderwerpen toont.
	//2. Controle opeenvolgende slides met hetzelfde onderwerp wordt slechts eenmaal opgenomen.
	//3. Als het onderwerp leeg is dan zal het onderwerp gelijk worden gesteld aan de titel.
	private Slide addSubjects(Slide slide)
	{
		String subject="";
		slide.setTitle("Inhoudsopgave");
		slide.setSubject("Inhoudsopgave");
		
		for(Slide tempSlide: getSlides())
		{			
			if(!tempSlide.getTitle().equals("Inhoudsopgave")) 
			{
				String subjectNext = tempSlide.getSubject();
					if(subjectNext==null) 
					{
						tempSlide.setSubject(tempSlide.getTitle());
						subjectNext = tempSlide.getSubject();
					}
					if(!subjectNext.equals(subject))
					{
						SlideItem slideItem = new TextItem(tempSlide.getLevelSubject(),"* " + subjectNext);
						slide.append(slideItem);
						subject = tempSlide.getSubject();
					}
			}
		}
		return slide;
	}
}
