package model.presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;
import controller.CommandInvoker;
import controller.PresentationReceiver;
import model.DemoPresentation;
import model.presentation.abstraction.ContentSlide;
import model.presentation.abstraction.Presentation;
import model.presentation.abstraction.PresentationComponent;
import model.presentation.abstraction.Slide;
import model.presentation.file.FileLoaderCreator;
import model.presentation.file.FileLoaderCreators;
import model.presentation.file.FileSaverCreator;
import model.presentation.implementation.SlideItemDrawing;
import model.presentation.implementation.SlideItemDrawingBuilder;
import model.presentation.implementation.SlideItemDrawingBuilders;
import model.presentation.implementation.SlideItemDrawingContext;

/** Model van MVC 
 * 	Facade pattern: interface van JabberPoint
 * 	Observer pattern: concreet presentation subject 
 * 	Builder pattern: director voor de constructie van een SlideItemDrawing object met een builder interface
 ***************************************************************************************************************
 * 	De interface van JabberPoint, het concreet presentatie subject en director voor de constructie van objecten.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class PresentationFacade implements PresentationObservable{
	
	private Presentation presentation;
	private SlideItemDrawingBuilder slideItemDrawingBuilder;
	private SlideItemDrawing slideItemDrawing;
	private SlideItemDrawingContext slideItemDrawingContext;
	private FileLoaderCreator fileLoaderCreator;
	private FileSaverCreator fileSaverCreator;  
	private DemoPresentation demoPresentation;
	private PresentationComponent presentationComponent;
    private Vector<PresentationObserver> observers;
    private CommandInvoker commandInvoker;
    
    /**
     * Constructor
     * Initialisatie
     * Standaard zal een SlideItemDrawingA object voor de implementatie tekenwijze voor slide items gecreeerd worden.
     */
    public PresentationFacade() 
    {
    	presentation = Presentation.getInstance();
    	slideItemDrawingContext = SlideItemDrawingContext.getInstance();
    	observers = new Vector<PresentationObserver>();
    	commandInvoker = new CommandInvoker(new PresentationReceiver(this));
    	slideItemDrawing = constructSlideItemDrawing(SlideItemDrawingBuilders.SLIDEITEMDRAWINGBUILDERA);
    }
    
    /**
     * De methode zet de implementatie tekenwijze van slide items.
     * Niet te verwarren met de stijl van een slide item op basis van het attribuut level.
     * @param slideItemDrawingBuilders een builder in enumeratie waarde.
     */
    public void setSlideItemDrawing(SlideItemDrawingBuilders slideItemDrawingBuilders) 
    {	 	
    	this.slideItemDrawing = constructSlideItemDrawing(slideItemDrawingBuilders);
	}
    
    /**
     * De methode geeft de implementatie tekenwijze van slide items.
     * @return SlideItemDrawing object de implementatie tekenwijze van slide items.
     */
	public SlideItemDrawing getSlideItemDrawing()
	{
		return slideItemDrawing;
	}
	
	 /** 
     * Builder pattern: constructie methode van de director(PresentationFacade). 
     * De methode geeft een SlideItemDrawing object en bepaald de specifieke Drawing adaptee's van de slide items.
     * @param slideItemDrawingBuilders een builder in enumeratie waarde.
     * @return SlideItemDrawing object de implementatie tekenwijze van slide items.
     */
	protected SlideItemDrawing constructSlideItemDrawing(SlideItemDrawingBuilders slideItemDrawingBuilders)
	{
		slideItemDrawingBuilder = SlideItemDrawingBuilder.getSlideBuilder(slideItemDrawingBuilders);
		slideItemDrawingBuilder.buildSlideItemDrawing();
		slideItemDrawingBuilder.addTextItemDrawingAdaptee();
		slideItemDrawingBuilder.addBitmapItemDrawingAdaptee();
		return slideItemDrawingBuilder.getSlideItemDrawing();
	}
	
	 /** 
     * De methode zet een demo presentatie en zet de begin slide op 0.
     * @param demoPresentation de demo presentatie.
     */
	public void createDemoBasedPresentation(DemoPresentation demoPresentation) 
	{
		this.demoPresentation = demoPresentation;
		presentation.setSlideItemDrawing(slideItemDrawing);
		presentation = demoPresentation.constructPresentation(presentation);	
		presentation.setSlideNumber(0);
	}
	
	 /** 
     * De methode laadt een presentatie van een bestand en zet de begin slide op 0.
     * Momenteel kunnen enkel xml files geladen worden.
     * @param fileName de filename van het bestand.
     */
	public void loadPresentation(String fileName) 
	{
		presentation.setSlideItemDrawing(slideItemDrawing);
		fileLoaderCreator = FileLoaderCreator.getFileLoaderCreator(FileLoaderCreators.XMLFILELOADER);
		presentation = fileLoaderCreator.createFileLoader().loadFile(presentation, fileName);		
		presentation.setSlideNumber(0);
	}
	
	 /** 
     * De methode bewaart een presentatie op een bestand.
     * Momenteel kunnen enkel xml files bewaard worden.
     * @param fileName de filename van het bestand.
     */
	public void savePresention(String fileName)
	{
		fileSaverCreator = FileSaverCreator.getFileSaverCreator(FileLoaderCreators.XMLFILELOADER);
		fileSaverCreator.createFileSaver().saveFile(presentation, fileName);
	}
	
	/** 
     * De methode geeft een command invoker.
     * De command invoker heeft alle commando's van JabberPoint.
     * @return CommandInvoker object de command invoker.
     */
	public CommandInvoker getCommandInvoker()
	{
		return commandInvoker;
	}
	
	/**
	 * De methode voegt een nieuwe slide met alle onderwerpen van de bestaande slides toe aan de presentatie.
	 */
	public void addSlideContent()
	{
		presentationComponent = new ContentSlide(presentation);
		presentationComponent.append(presentation.getSlideNumber(),new Slide());
		notifyObservers(this);
	}
	
	/**
	 * De methode verwijdert de huidige slide die de inhoud van alle onderwerpen toont uit de presentatie.
	 */
	public void removeSlideContent()
	{
		if(presentationComponent==null){presentationComponent = new ContentSlide(presentation);}
		{
			presentationComponent.remove(presentation.getCurrentSlide());
			notifyObservers(this);
		}
	}
	
	/** 
     * De methode geeft de nummer van de huidige slide.
     * @return int huidige slide nummer.
     */
	public int getCurrentSlideNumber() 
	{
		return presentation.getSlideNumber();
	}
	
	/** 
     * De methode geeft het aantal slides van de presentatie.
     * @return int aantal slides.
     */
	public int getTotalSlides() 
	{
		return presentation.getSize();
	}
	
	/** 
     * De methode zet de volgende slide van de presentatie en 'notifies' alle observers.
     */
	public void nextSlide() 
	{
		presentation.nextSlide();
		this.notifyObservers(this);
	}
	
	/** 
     * De methode zet de vorige slide van de presentatie en 'notifies' alle observers.
     */
	public void prevSlide() 
	{
		presentation.prevSlide();
		this.notifyObservers(this);
	}
	
	/** 
     * De methode zet de slide van de presentatie met het slidenummer en 'notifies' alle observers.
     * @param slide het slidenummer.
     */
	public void setSlideNumber(int slide) 
	{
		presentation.setSlideNumber(slide);	
		this.notifyObservers(this);
	}
	
	/** 
     * De methode verwijdert alle slides van de presentatie zonder 'notifying' alle observers.
     */
	public void clearPresentation() {
		presentation.clear();
	}
	
	/** 
     * De methode tekent alle slide items van de huidige slide.
     * De parameters bepalen de context zodat de implementatie van een slide item kan getekend worden.
     * @param graphics de grafische context van het component waarop getekend moet worden.
     * @param rectangle het tekenruimte van een slide item.
     * @param scale de schaal van het tekenruimte.
     * @param imageObserver informatie over de afbeelding van het bitmap item.
     */
	public void drawPresentation(Graphics graphics, Rectangle rectangle, float scale,  
								ImageObserver imageObserver)
	{
		//De context bestemd voor het SlideItemDrawing object of de implementatie van slide items(implementeren = tekenen).
		slideItemDrawingContext.setGraphics(graphics);
		slideItemDrawingContext.setArea(rectangle);
		slideItemDrawingContext.setImageObserver(imageObserver);
		slideItemDrawingContext.setHeight(0);
		slideItemDrawingContext.setScale(scale);
		
		if(presentation.getSize()!=0)
		{
		presentation.getCurrentSlide().drawSlide();
		}
	}
	
	/** 
     * De methode geeft alle de titel van de presentatie.
     * @return String de titel van de presentatie
     */
	public String getTitle()
	{
		return presentation.getTitle();
	}
	
	/** 
     * De methode geeft het nummer van huidige(getoonde) slide.
     * @return int het nummer van de slide
     */
	public int getSlideNumber() 
	{
		return presentation.getSlideNumber();
	}
	
	/** 
     * De methode geeft het aantal slides van de presentatie.
     * @return int het aantal slides van de presentatie.
     */
	public int getSize() 
	{
		return presentation.getSize();
	}
	
	/** 
     * De methode geeft de presentatie.
     * @return Presentation object de presentatie.
     */
	public Presentation getPresentation()
	{
		return presentation;	
	}
	
	/** 
     * De methode geeft help informatie.
     * @return String help informatie.
     */
	public String getHelpInformation()
	{
		String helpInformation = "JabberPoint is a primitive slide-show program in Java(tm). It\n" +
			"is freely copyable as long as you keep this notice and\n" +
			"the splash screen intact.\n" +
			"Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
			"Adapted by Gert Florijn (version 1.1) and " +
			"Sylvia Stuurman (version 1.2 and higher) for the Open" +
			"University of the Netherlands, 2002 -- now." +
			"Author's version available from http://www.darwinsys.com/";	
		return helpInformation;	
	}
	
	@Override
	public void attach(PresentationObserver presentationObserver) {
		observers.addElement(presentationObserver);
	}

	@Override
	public void detach(PresentationObserver presentationObserver) 
	{
		observers.remove(presentationObserver);		
	}

	@Override
	public void notifyObservers(PresentationFacade presentationFacade) 
	{
		for(PresentationObserver presentationObserver : observers)
		{
			presentationObserver.update(this);
		}
	}	
	
	/** 
     * De methode stopt de applicatie.
     * @param n informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
     */
	public void exit(int n) {
		System.exit(n);
	}	
}
