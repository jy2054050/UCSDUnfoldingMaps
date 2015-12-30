package mymodule;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Extension {
	public static void main(String[] args) {
		
		 try {	
	         File inputFile = new File("/home/jitu/workspace/zzzz/jitu.xml");
	        
	            // File inputFile = new File("input.txt");
	             DocumentBuilderFactory dbFactory 
	                = DocumentBuilderFactory.newInstance();
	             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	             Document doc = dBuilder.parse(inputFile);
	             doc.getDocumentElement().normalize();
	             System.out.println("Root element :" 
	                + doc.getDocumentElement().getNodeName());
	             NodeList nList = doc.getElementsByTagName("entry");
	             System.out.println("----------------------------");
	             for (int temp = 0; temp < nList.getLength(); temp++) {
	                Node nNode = nList.item(temp);
	              //  System.out.println("\nCurrent Element :"+ nNode.getNodeName());
	                   Element eElement = (Element) nNode;
	   //  System.out.println( eElement.getElementsByTagName("id").item(0).getTextContent());
	     System.out.println( eElement.getElementsByTagName("title").item(0).getTextContent());
	                   
	                
	             
	}
} catch(Exception e){
	}}
}
