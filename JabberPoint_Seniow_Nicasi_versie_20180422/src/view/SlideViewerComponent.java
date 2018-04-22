package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import model.presentation.PresentationFacade;
import model.presentation.PresentationObserver;
import model.presentation.abstraction.Slide;

/** View van MVC 
 * 	View SlideViewerComponent
 * 	Observer pattern: concrete presentation observer
 *****************************************************************************************************
 * <p>SlideViewerComponent is een grafische component die Slides kan laten zien.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class SlideViewerComponent extends JComponent implements PresentationObserver{
	
	private JFrame frame;
	private PresentationFacade presentationFacade; 			//Interface van Jabberpoint.
	private static final long serialVersionUID = 227L;	
	private Font labelFont; 								//Lettertype label.
	
	//Initialisatie
	public SlideViewerComponent(JFrame frame, PresentationFacade presentationFacade) 
	{
		this.frame = frame;
		setBackground(Color.white); 
		this.presentationFacade = presentationFacade;
		this.presentationFacade.attach(this);
		this.labelFont = new Font("Dialog", Font.BOLD, 10);	
	}

	public Dimension getPreferredSize() 
	{
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	//Teken alle slide Items van de huidige slide in de presentatie.
	public void paintComponent(Graphics g) 
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);
		//Als er geen slides aanwezig zijn, dan zal een leeg venster getoond worden.
		if (presentationFacade.getSlideNumber() < 0 ) 
		{
			return;
		}
		g.setFont(labelFont);
		g.setColor(Color.black);
		g.drawString("Slide " + (1 + presentationFacade.getSlideNumber()) + " of " +
				presentationFacade.getSize(), 900, 20);
		Rectangle area = new Rectangle(0, 20, getWidth(), (getHeight() - 20));
		
		//De parameters bepalen de context voor het tekenen.
		presentationFacade.drawPresentation(g, area, getScale(area), this);
	
	}
	
	//Schaal bepaling voor slide items. 
	private float getScale(Rectangle area) 
	{
		return Math.min(((float)area.width) / ((float)1200), ((float)area.height) / ((float)800));
	}

	//Hertekenen van de slide items in de huidige slide van de presentatie bij veranderingen.
	@Override
	public void update(PresentationFacade presentationFacade) 
	{
		this.presentationFacade = presentationFacade;
		repaint();
		frame.setTitle(presentationFacade.getTitle());
	}
	
}
