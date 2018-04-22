package model.presentation.implementation;

import java.awt.Color;
import java.awt.Font;

/** Model van MVC 
 * 	Flyweight: De 'Flyweight' concreet teken stijl object 
 ****************************************************************************************************************
 * De klas geeft de teken stijl van een slide item.
 * De teken stijl betreft: het inspringen, lettertype, lettergrootte, de verticale ruimte en de kleur.
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman, Seniow Andy, Kevin Nicasi
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
 */
public class Style {
	
	private static final String FONTNAME = "Helvetica";
	private int indent;
	private Color color;
	private Font font;
	private int fontSize;
	private int leading;

	/**
	 * Constructor
	 * Initialisatie
	 * @param indent het inspringen.
	 * @param color de kleur.
	 * @param points de lettergrootte.
	 * @param leading de verticale ruimte.
	 */
	public Style(int indent, Color color, int points, int leading) 
	{
		this.indent = indent;
		this.color = color;
		font = new Font(FONTNAME, Font.BOLD, fontSize=points);
		this.leading = leading;
	}

	/**
	 * De methode geeft de string van de eigenschappen teken stijl.
	 */
	public String toString() 
	{
		return "["+ indent + "," + color + "; " + fontSize + " on " + leading +"]";
	}

	/**
	 * De methode geeft het lettertype.
	 * @param scale de schaal.
	 * @return Font object.
	 */
	public Font getFont(float scale) 
	{
		return font.deriveFont(fontSize * scale);
	}
	
	/**
	 * De methode geeft het inspringen.
	 * @return int het inspringen.
	 */
	public int getIndent() 
	{
		return indent;
	}

	/**
	 * De methode geeft de kleur.
	 * @return Color object
	 */
	public Color getColor() 
	{
		return color;
	}

	/**
	 * De methode geeft het lettertype.
	 * @return Font object
	 */
	public Font getFont() 
	{
		return font;
	}

	/**
	 * De methode geeft de grootte van het lettertype.
	 * @return int grootte lettertype.
	 */
	public int getFontSize() 
	{
		return fontSize;
	}

	/**
	 * De methode geeft de verticale ruimte.
	 * @return int de verticale ruimte.
	 */
	public int getLeading() 
	{
		return leading;
	}
}
