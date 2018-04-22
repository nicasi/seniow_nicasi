package view;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import model.presentation.PresentationFacade;
import view.useractions.KeyActions;

/** View van MVC 
 * 	View SlideViewerFrame
 *****************************************************************************************************
 * <p>Het applicatiewindow voor een slideviewcomponent</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class SlideViewerFrame extends JFrame {
		
	private static final long serialVersionUID = 3227L;
	private static int frameHeight = 600;
	private static int frameWidth = 1000;
	
	public SlideViewerFrame(String title, PresentationFacade presentationFacade) 
	{
		super(title);
		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(this, presentationFacade);
		setupWindow(slideViewerComponent, presentationFacade);
	}

	//De GUI opzetten
	public void setupWindow(SlideViewerComponent slideViewerComponent, PresentationFacade presentationFacade) 
	{
		setTitle("Jabberpoint 1.6 - OU");
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
		});
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyActions(presentationFacade)); 						//User key acties initialiseren.
		setJMenuBar(new MenuView(this, presentationFacade));						//Menu view initialiseren.
		setSize(new Dimension(frameWidth, frameHeight)); 							//Afmetingen initialiseren.
		setVisible(true);		
	}
}
