package controller;

/** Controller van MVC 
 * 	Command pattern: receiver 
 *  Kent de operaties om de geassocieerde commando's uit te voeren.
 ******************************************************************
 * 	De interface van de receiver.
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public interface Receiver {

	/**
	 * De methode laadt een bestand.
	 * @param fileName de naam van de file.
	 */
	public void fileOpen(String fileName);
	
	/**
	 * De methode bewaart een bestand.
	 * @param fileName de naam van de file.
	 */
	public void fileSave(String fileName);
	
	/**
	 * De methode verwijdert alle slides van de presentatie.
	 */
	public void fileNew();
	
	/**
	 * De methode stopt de applicatie
	 * @param exitNumber informatie over het stoppen van de applicatie: 0=succesvol, 1=met exception en -1= met fout.
	 */
	public void fileExit(int exitNumber);
	
	/**
	 * De methode toont de volgende slide.
	 */
	public void viewNext();
	
	/**
	 * De methode toont de vorige slide.
	 */
	public void viewPrev();
	
	/**
	 * De methode toont de slide met het slidenummer.
	 * @param pageNumber het slidenummer.
	 */
	public void viewGoto(int pageNumber);
	
	/**
	 * De methode voegt een slide met de inhoudsopgave toe.
	 */
	public void addSlideContent();
	
	/**
	 * De methode verwijdert de slide met de inhoudsopgave.
	 */
	public void removeSlideContent();
}
