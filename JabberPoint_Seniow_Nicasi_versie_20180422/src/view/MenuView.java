package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import errorhandle.JabberPointException;
import model.presentation.PresentationFacade;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;


/** View van MVC 
 * 	View MenuView
 *  Facade pattern: De menu gebruikt de facade als interface voor JabberPoint
 *****************************************************************************************************
 *  <p>User acties van menu view sturen de command invoker (Action events)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.7 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class MenuView extends JMenuBar {
	
	private static final long serialVersionUID = 227L;
	private JFrame frame;	
	private PresentationFacade presentationFacade;		//interface van Jabberpoint
		
	/**
	 * Constructor
	 * Initialisatie
	 * @param frame grafische context.
	 * @param slideViewerComponent grafische context.
	 * @param presentationFacade de facade of de interface van JabberPoint.
	 */
	public MenuView(JFrame frame, PresentationFacade presentationFacade) 
	{
		this.frame = frame;
		this.presentationFacade = presentationFacade;
		createMenu();
	}
	
	/**
	 * De methode creeert en initialiseert menu's.
	 */
	private void createMenu()
	{
		//1. Creeren van menu "File".
		//2. Creeren van menu items "Open", "New", "Save", "Exit" en toevoegen aan menu "File".
		//3. Creeren en toevoegen van acties.
		//4. Acties sturen de command invoker.
		//5. Toevoegen aan menubar.
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(mkMenuItem("Open",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					presentationFacade.getCommandInvoker().fileOpenCommand("test.xml");
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(frame, "Exception: " + exc, 
							"Load Error", JOptionPane.ERROR_MESSAGE);
				}
				frame.repaint();
			}
		}));
		fileMenu.add(mkMenuItem("New",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().fileNewCommand();
				frame.repaint();
			}
		}));
		fileMenu.add(mkMenuItem("Save",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presentationFacade.getCommandInvoker().fileSaveCommand ("dump.xml");
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(frame, "Exception: " + exc, 
							"Save Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}));
		fileMenu.addSeparator();
		fileMenu.add(mkMenuItem("Exit",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().fileExitCommand(0); 
			}
		}));
		add(fileMenu);
		
		//6. Creeren van menu "View".
		//7. Creeren van menu items "Next", "Prev", "Go to" en toevoegen aan menu "View".
		//8. Creeren en toevoegen van acties.
		//9. Acties sturen de command invoker.
		//10. Toevoegen aan menubar.
		JMenu viewMenu = new JMenu("View");
		viewMenu.add(mkMenuItem("Next",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().viewNextCommand(); 
			}
		}));
		viewMenu.add(mkMenuItem("Prev",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().viewPrevCommand(); 
			}
		}));
		viewMenu.add(mkMenuItem("Go to",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object)"Page number?");
				try {
				int pageNumber = Integer.parseInt(pageNumberStr);
					presentationFacade.getCommandInvoker().viewGotoCommand(pageNumber); 
				}
				catch(Exception ex)
				{
					JabberPointException.showError(ex.getMessage());
				}
			}
		}));
		add(viewMenu);
			
		JMenu slideMenu = new JMenu("Content Slide");
		slideMenu.add(mkMenuItem("Add",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().addSlideContentCommand();
			}
		}));
		slideMenu.add(mkMenuItem("Remove",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentationFacade.getCommandInvoker().removeSlideContentCommand();
			}
		}));
		add(slideMenu);
		
		
		//11. Creeren van menu "Help"
		//12. Creeren van menu items "About", "Prev", "Go to" en toevoegen aan menu "Help".
		//13. Creeren en toevoegen van acties
		//14. Acties sturen een dialoog met informatie aan.
		//15. Instellen aan menubar.
		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(mkMenuItem("About",new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AboutBox.show(frame);
			}
		}));
		add(helpMenu);
	}	
	
	/**
	 * De methode creeert en initialiseert menu items.
	 * @param name de naam van het menu item.
	 * @param actionListener actie of event listener.
	 * @return JMenuItem object.
	 */
	public JMenuItem mkMenuItem(String name,ActionListener actionListener) 
	{
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.addActionListener(actionListener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(name.charAt(0), CTRL_DOWN_MASK));
		return menuItem;
	}
}


