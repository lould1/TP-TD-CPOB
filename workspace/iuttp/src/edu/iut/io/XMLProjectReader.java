package edu.iut.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import edu.iut.app.CommandLineOption;
import edu.iut.app.ExamEvent;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

// EX 1 Completer la classe

public class XMLProjectReader {
	public XMLProjectReader() {
		
	}
	
	public ArrayList<ExamEvent> load(java.io.File xmlfile) throws IOException {
		ArrayList<ExamEvent> data = new ArrayList<ExamEvent>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document= builder.parse(xmlfile);
			
			// EX1: Lire un Document XML
			Element root=(Element) document.createElement("agenda");
			//lire et écrire
			File fichier =  new File("marin.xml") ;
			CommandLineOption<File> projet=  new CommandLineOption<File>() ;
			
			//avec config
			CommandLineOption<File> config =  new CommandLineOption<File>() ;
			
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
