package model.presentation.implementation;

import java.awt.Color;
import java.util.Hashtable;

/** Model van MVC 
 * 	Flyweight: De 'FlyweightFactory' creeert en beheert flyweight of style objecten 
 **********************************************************************************
 * De klas creeert en beheert 5 teken stijlen. De tekenstijlen komen overeen met 
 * het level van het slide item.
 * @author  Seniow Andy, Kevin Nicasi
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class StyleFactory {

	private static Hashtable<Integer,Style> styles; 
	
	/**
	 * De methode creeert 5 tekenstijlen en geeft een teken stijl object op basis van het level van een slide item.
	 * @param key de key of in dit geval de level van het slide item.
	 * @return Style object
	 */
    public static Style getFlyweight(int key)
    {
    	if(styles==null)
    	{
    	styles = new Hashtable<Integer, Style>();
    	styles.put(0, new Style(0, Color.red,   48, 20));	// style voor item-level 0 -->  voor text en bitmap item
    	styles.put(1, new Style(20, Color.blue,  40, 10));	// style voor item-level 1 -->  voor text en bitmap item
    	styles.put(2, new Style(50, Color.black, 36, 10));	// style voor item-level 2 -->  voor text en bitmap item
    	styles.put(3, new Style(70, Color.black, 30, 10));	// style voor item-level 3 -->  voor text en bitmap item
    	styles.put(4, new Style(90, Color.black, 24, 10));	// style voor item-level 4 -->  voor text en bitmap item
    	
    	styles.put(5, new Style(30, Color.black,   40, 30));	// style voor item-level 0 -->  voor text item als het een onderwerp van een slide is
    	styles.put(6, new Style(30, Color.blue,  40, 30));	// style voor item-level 1 -->  voor text item als het een onderwerp van een slide is
    	styles.put(7, new Style(30, Color.green, 40, 30));	// style voor item-level 2 -->  voor text item als het een onderwerp van een slide is
    	styles.put(8, new Style(30, Color.red, 40, 30));	// style voor item-level 3 -->  voor text item als het een onderwerp van een slide is
    	
    	} 	
    	return styles.get(key);
    }   
}