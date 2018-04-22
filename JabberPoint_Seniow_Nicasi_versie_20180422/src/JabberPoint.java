import errorhandle.JabberPointException;
import model.FirstDemoPresentation;
import model.presentation.PresentationFacade;
import view.SlideViewerFrame;

/** JabberPoint Main Programma
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class JabberPoint {
		
	/** Het Main Programma */
	public static void main(String argv[]) 
	{
		
		try {
				//Model
				//Facade pattern: interface van JabberPoint.
				PresentationFacade presentationFacade = new PresentationFacade();
				
				//Een demopresentatie of een xml gebaseerde presentatie wordt getoond.
		
				if (argv.length == 0) 
					{ // een demo presentatie
						presentationFacade.createDemoBasedPresentation(new FirstDemoPresentation());
					} 
				else 
					{
						presentationFacade.loadPresentation(argv[0]);
					}
				
				//View
				new SlideViewerFrame("Jabberpoint 1.6 - OU version", presentationFacade);	
				} 
		catch (Exception ex) 
			{
				//Error handling
				JabberPointException.showError(ex.getMessage());
			}		
	}
}
