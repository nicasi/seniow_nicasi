package errorhandle;

import javax.swing.JOptionPane;

/** 
 * 	Algemene fout afhandeling
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class JabberPointException{

	private static String error = "An problem occured." +'\n' + "Please contact: seniow@skynet.be"+'\n';
	
	/**
	 * De methode toont het foutbericht in een dialoogvenster.
	 * @param message het foutbericht.
	 */
	public static void showError(String message)
	{
		JOptionPane.showMessageDialog(null,
				"Error: " + error + message, "Jabberpoint Error ",
				JOptionPane.ERROR_MESSAGE);
	}

}
