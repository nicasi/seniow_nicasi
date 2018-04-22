package model.presentation.abstraction;

/** Model van MVC 
 * 	Builder pattern: concrete klas voor het 'builden' van een concrete slide object.
 ***********************************************************************************
 * 	De concrete klas voor het creeren van een slide.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class SlideBuilder extends AbstractSlideBuilder{
	
	private Slide slide;
	
	@Override
	public void buildSlide(String title)
	{
		slide = new Slide();
		slide.setTitle(title);
	}
	
	@Override
	public void setSubject(String subject)
	{
		slide.setSubject(subject);
	}
	
	@Override
	public void setLevelSubject(int levelSubject)
	{
		slide.setLevelSubject(levelSubject);
	}
	
	@Override
	public void addTextItem(int level, String text)
	{
		if(slide!=null)
		{
			slide.append(new TextItem(level, text));
		}
	}
	
	@Override
	public void addBitmapItem(int level, String name)
	{
		if(slide!=null)
		{
			slide.append(new BitmapItem(level, name));
		}
	}
	
	@Override
	public Slide getSlide()
	{
		return slide;
	}
}
