package model.presentation.implementation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import errorhandle.JabberPointException;

/** Model van MVC 
 *  Adapter pattern: concrete adaptee, een bestaande interface
 *  Builder pattern: een product
 ******************************************************************
 * 	De concrete klas voor het tekenen van een bitmap item. 
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class BitmapItemDrawingAdaptee implements SlideItemDrawingAdaptee{

	private BufferedImage bufferedImage;
	
	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) 
	{
		return new Rectangle((int) (style.getIndent() * scale), 0,
				(int) (bufferedImage.getWidth(observer) * scale),
				((int) (style.getLeading() * scale)) + 
				(int) (bufferedImage.getHeight(observer) * scale));
	}

	@Override
	public void draw(String information, int x, int y, float scale, Graphics g, Style style, ImageObserver observer) 
	{
		try {
			bufferedImage = ImageIO.read(new File(information));
		}
		catch (IOException e) {
			JabberPointException.showError("Bestand " + information + " niet gevonden") ;
		}
		
		int width = x + (int) (style.getIndent() * scale);
		int height = y + (int) (style.getLeading() * scale);
		g.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer)*scale),
                (int) (bufferedImage.getHeight(observer)*scale), observer);	
	}
}
