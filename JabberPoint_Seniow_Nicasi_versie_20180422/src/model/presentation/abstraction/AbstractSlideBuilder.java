package model.presentation.abstraction;

/** Model van MVC 
 * 	Builder pattern: abstracte interface voor het 'builden' van een concreet slide object.
 *****************************************************************************************
 * 	De abstracte klas voor het creeren van een slide.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public abstract class AbstractSlideBuilder {
	
	/**
	 * De methode geeft een concrete slide builder
	 * @param slideBuilder een enumaratie waarde van een slide builder.
	 * @return AbstractSlideBuilder object.
	 */
	public static AbstractSlideBuilder getSlideBuilder(SlideBuilders slideBuilder)
	{
		switch(slideBuilder) {
		   case SLIDEBUILDER :
		      return new SlideBuilder();
		   default : return null;
		}
	}
	
	/**
	 * De methode 'builds' een nieuw slide met een titel en zonder een onderwerp.
	 * @param title de title van de slide.
	 */
	public abstract void buildSlide(String title);
	
	/**
	 * De methode zet het subject van de slide.
	 * @param subject het subject van de slide.
	 */
	public abstract void setSubject(String subject);
	
	/**
	 * De methode zet de level van het subject van de slide.
	 * @param levelSubject
	 */
	public abstract void setLevelSubject(int levelSubject);
	
	/**
	 * De methode voegt een text item toe aan de slide
	 * @param level de level van het text item.
	 * @param text de tekst van het text item.
	 */
	public abstract void addTextItem(int level, String text);
	
	/**
	 * De methode voegt een bitmap item toe aan de slide.
	 * @param level de level van het bitmap item.
	 * @param name de naam van de afbeelding.
	 */
	public abstract void addBitmapItem(int level, String name);
	
	/**
	 * De methode geeft het 'gebuilde product' of de slide.
	 * @return Slide object.
	 */
	public abstract Slide getSlide();
	
}
