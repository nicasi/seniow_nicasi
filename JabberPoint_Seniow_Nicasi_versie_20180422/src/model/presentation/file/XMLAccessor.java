package model.presentation.file;

import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import model.presentation.abstraction.AbstractSlideBuilder;
import model.presentation.abstraction.BitmapItem;
import model.presentation.abstraction.Presentation;
import model.presentation.abstraction.SlideBuilders;
import model.presentation.abstraction.Slide;
import model.presentation.abstraction.SlideItem;
import model.presentation.abstraction.TextItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/** Model van MVC 
 *  Adapter pattern: concrete adaptee, een bestaande interface
 * 	Factory method pattern: een product 
 ****************************************************************
 * 	De concrete klas voor het laden en bewaren van XML bestanden. 
 * 	@author Seniow Andy, Kevin Nicasi
 * 	@version 1.1 23/04/2018 Seniow Andy en Kevin Nicasi
*/
public class XMLAccessor extends Accessor {
	
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** namen van xml tags of attributen */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDESUBJECT = "subject";
    protected static final String SLIDETOC = "toc";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    
    /** tekst van messages */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";
    
    private AbstractSlideBuilder slideBuilder;
    
   
    private String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();  	
    }
    
    private String getSubject(Element element, String tagName) {
    	NodeList subjects = element.getElementsByTagName(tagName);
    	return subjects.item(0).getTextContent();  	
    }
    
    private int getToc(Element element, String tagName) {
    	NodeList tocs = element.getElementsByTagName(tagName);
    	return Integer.parseInt(tocs.item(0).getTextContent());  	
    }
    
    @Override
	public Presentation loadFile(Presentation presentation, String filename) throws IOException {
    	this.presentation = presentation;
		int slideNumber, itemNumber, max = 0, maxItems = 0;
		
		if (slideBuilder==null)
		{
			slideBuilder = AbstractSlideBuilder.getSlideBuilder(SlideBuilders.SLIDEBUILDER);
		}
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();    
			Document document = builder.parse(new File(filename)); // maak een JDOM document
			Element doc = document.getDocumentElement();
			presentation.setTitle(getTitle(doc, SHOWTITLE));
			
			NodeList slides = doc.getElementsByTagName(SLIDE);
			max = slides.getLength();
			
			for (slideNumber = 0; slideNumber < max; slideNumber++) {
				Element xmlSlide = (Element) slides.item(slideNumber);
				slideBuilder.buildSlide(getTitle(xmlSlide, SLIDETITLE));
				slideBuilder.setSubject(getSubject(xmlSlide, SLIDESUBJECT));
				slideBuilder.setLevelSubject(getToc(xmlSlide, SLIDETOC));
				
				NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
				maxItems = slideItems.getLength();
				for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
					Element item = (Element) slideItems.item(itemNumber);
					loadSlideItem(item);
				}
				presentation.append(slideBuilder.getSlide());
			}
		} 
		catch (IOException iox) {
			System.err.println(iox.toString());
		}
		catch (SAXException sax) {
			System.err.println(sax.getMessage());
		}
		catch (ParserConfigurationException pcx) {
			System.err.println(PCE);
		}
		
		return presentation;
	}
    

	protected void loadSlideItem(Element item) {
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();
		String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
		if (leveltext != null) {
			try {
				level = Integer.parseInt(leveltext);
			}
			catch(NumberFormatException x) {
				System.err.println(NFE);
			}
		}
		String type = attributes.getNamedItem(KIND).getTextContent();
		if (TEXT.equals(type)) {
			slideBuilder.addTextItem(level, item.getTextContent());
		}
		else {
			if (IMAGE.equals(type)) {
				slideBuilder.addBitmapItem(level, item.getTextContent());
			}
			else {
				System.err.println(UNKNOWNTYPE);
			}
		}
	}
	
	@Override
	public void saveFile(Presentation presentation, String filename) throws IOException {
		this.presentation = presentation;
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
		out.println("<presentation>");
		out.print("<showtitle>");
		out.print(presentation.getTitle());
		out.println("</showtitle>");
		for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++) {
			Slide slide = presentation.getSlide(slideNumber);
			out.println("<slide>");
			out.println("<title>" + slide.getTitle() + "</title>");
			out.println("<subject>" + slide.getSubject() + "</subject>");
			out.println("<toc>" + slide.getLevelSubject() + "</toc>");
			Vector<SlideItem> slideItems = slide.getSlideItems();
			for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++) {
				SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);
				out.print("<item kind="); 
				if (slideItem instanceof TextItem) {
					out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
					out.print( ( (TextItem) slideItem).getText());
				}
				else {
					if (slideItem instanceof BitmapItem) {
						out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
						out.print( ( (BitmapItem) slideItem).getName());
					}
					else {
						System.out.println("Ignoring " + slideItem);
					}
				}
				out.println("</item>");
			}
			out.println("</slide>");
		}
		out.println("</presentation>");
		out.close();
	}
}
