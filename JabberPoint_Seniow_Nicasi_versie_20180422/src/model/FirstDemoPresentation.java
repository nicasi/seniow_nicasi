package model;

import model.presentation.abstraction.AbstractSlideBuilder;
import model.presentation.abstraction.Presentation;
import model.presentation.abstraction.SlideBuilders;

/** Model van MVC 
 ******************************************************
 * 	De concrete klas voor een demo presentatie.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class FirstDemoPresentation extends DemoPresentation{

	private AbstractSlideBuilder slideBuilder;
	
	/**
	 * Constructor
	 * Initialisatie
	 */
	public FirstDemoPresentation() 
	{
		this.slideBuilder = AbstractSlideBuilder.getSlideBuilder(SlideBuilders.SLIDEBUILDER);
	}
	
	@Override
	public Presentation constructPresentation(Presentation presentation) {
		
		//Een gegeven presentatie wordt geconstrueerd.
		this.presentation = presentation;
		this.presentation.setTitle("Demo Presentation");	
		
		slideBuilder.buildSlide("JabberPoint");
		slideBuilder.setSubject("Inleiding");
		slideBuilder.setLevelSubject(5);
		slideBuilder.addTextItem(1, "Het Java Presentatie Tool");
		slideBuilder.addTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
		slideBuilder.addTextItem(2, "Copyright (c) 2000-now:");
		slideBuilder.addTextItem(2, "Gert Florijn en Sylvia Stuurman");	
		slideBuilder.addTextItem(4, "JabberPoint aanroepen zonder bestandsnaam");	
		slideBuilder.addTextItem(4, "laat deze presentatie zien");	
		slideBuilder.addTextItem(1, "Navigeren:");	
		slideBuilder.addTextItem(3, "Volgende slide: PgDn of Enter");	
		slideBuilder.addTextItem(3, "Vorige slide: PgUp of up-arrow");
		slideBuilder.addTextItem(3, "Stoppen: q or Q");
		this.presentation.append(slideBuilder.getSlide());
		
		slideBuilder.buildSlide("Demonstratie van levels en stijlen");
		slideBuilder.setSubject("Demonstratie");
		slideBuilder.setLevelSubject(6);
		slideBuilder.addTextItem(1, "Level 1");
		slideBuilder.addTextItem(2, "Level 2");
		slideBuilder.addTextItem(1, "Nogmaals level 1");
		slideBuilder.addTextItem(1, "Level 1 heeft stijl nummer 1");
		slideBuilder.addTextItem(2, "Level 2 heeft stijl nummer 2");
		slideBuilder.addTextItem(3, "Zo ziet level 3 er uit");
		slideBuilder.addTextItem(4, "En dit is level 4");
		this.presentation.append(slideBuilder.getSlide());
		
		slideBuilder.buildSlide("De derde slide");
		slideBuilder.setSubject("Demonstratie");
		slideBuilder.setLevelSubject(7);
		slideBuilder.addTextItem(1, "Om een nieuwe presentatie te openen,");
		slideBuilder.addTextItem(2, "gebruik File->Open uit het menu.");
		slideBuilder.addTextItem(1, " ");
		slideBuilder.addTextItem(1, "Dit is het einde van de presentatie.");
		slideBuilder.addBitmapItem(1, "JabberPoint.jpg");
		this.presentation.append(slideBuilder.getSlide());
		
		return this.presentation;
	}
}
