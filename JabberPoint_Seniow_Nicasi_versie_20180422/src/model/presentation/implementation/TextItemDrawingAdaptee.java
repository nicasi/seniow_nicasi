package model.presentation.implementation;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import model.presentation.abstraction.Slide;
import java.util.Iterator;
import java.util.ArrayList;

/** Model van MVC 
 *  Adapter pattern: concrete adaptee, een bestaande interface
 *  Builder pattern: een product
 ******************************************************************
 * 	De concrete klas voor het tekenen van een text item. 
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class TextItemDrawingAdaptee implements SlideItemDrawingAdaptee{

	private String text;
	
	@Override
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		List<TextLayout> layouts = getLayouts(g, style, scale);
		int xsize = 0, ysize = (int) (style.getLeading() * scale);
		Iterator<TextLayout> iterator = layouts.iterator();
		while (iterator.hasNext()) {
			TextLayout layout = iterator.next();
			Rectangle2D bounds = layout.getBounds();
			if (bounds.getWidth() > xsize) {
				xsize = (int) bounds.getWidth();
			}
			if (bounds.getHeight() > 0) {
				ysize += bounds.getHeight();
			}
			ysize += layout.getLeading() + layout.getDescent();
		}
		return new Rectangle((int) (style.getIndent()*scale), 0, xsize, ysize );
	}

	@Override
	public void draw(String information, int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {	
		text = information;
		if (text == null || text.length() == 0) {
			return;
		}
		List<TextLayout> layouts = getLayouts(g, style, scale);
		Point pen = new Point(x + (int)(style.getIndent() * scale), 
				y + (int) (style.getLeading() * scale));
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(style.getColor());
		Iterator<TextLayout> it = layouts.iterator();
		while (it.hasNext()) {
			TextLayout layout = it.next();
			pen.y += layout.getAscent();
			layout.draw(g2d, pen.x, pen.y);
			pen.y += layout.getDescent();
		}
		
	}

	// geef de AttributedString voor het item
	public AttributedString getAttributedString(Style style, float scale) 
	{
		AttributedString attrStr = new AttributedString(text);
		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
		return attrStr;
	}
		
	private List<TextLayout> getLayouts(Graphics g, Style style, float scale) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();
		AttributedString attrStr = getAttributedString(style, scale);
	    Graphics2D g2d = (Graphics2D) g;
	    FontRenderContext frc = g2d.getFontRenderContext();
	    LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
	    float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;
	    while (measurer.getPosition() < text.length()) {
	    	TextLayout layout = measurer.nextLayout(wrappingWidth);
	    	layouts.add(layout);
	    }
	    return layouts;
		}
}
