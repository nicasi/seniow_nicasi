package view.useractions;

import java.awt.event.KeyEvent;
import model.presentation.PresentationFacade;
import java.awt.event.KeyAdapter;

/** View van MVC 
 * 	View user acties
 ****************************************************************************************************
 * <p>User acties sturen de command invoker (Key events)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class KeyActions extends KeyAdapter {
	
	private PresentationFacade presentationFacade;		//Interface van JabberPoint
	
	//Initialisatie
	public KeyActions(PresentationFacade presentationFacade) 	
	{
		this.presentationFacade = presentationFacade;
	}
	
	public void keyPressed(KeyEvent keyEvent) 
	{
		switch(keyEvent.getKeyCode()) 
		{
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				presentationFacade.getCommandInvoker().viewNextCommand(); 
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				presentationFacade.getCommandInvoker().viewPrevCommand(); 
				break;
			case 'q':
			case 'Q':
				System.exit(0);
				break; 
			default:
				break;
		}
	}
}
