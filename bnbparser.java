/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package proekt1;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.net.*;
 
public class bnbparser {
 
  /*
   * Fuction to download the xml information about the currency from BNB
   * @filename : String with the location of the filename where the downloaded information will be stored.
   */  
  public void DownBnbXml(String filename) throws Exception {
        
      String bnbxml = "http://www.bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/?download=xml&search=&lang=EN";  

      
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try
        {
            in = new BufferedInputStream(new URL(bnbxml).openStream());
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1)
            {
                fout.write(data, 0, count);
            }
        }
        finally
        {
            if (in != null)
                in.close();
            if (fout != null)
                fout.close();
        }
    }
  
  
  public void parseXML(){
       try {
 
        //DownBnbXml("bnb.xml");
	File fXmlFile = new File("bnb.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("ROW");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			System.out.println("NAME_ : " + eElement.getElementsByTagName("NAME_").item(0).getTextContent());
			System.out.println("CODE : " + eElement.getElementsByTagName("CODE").item(0).getTextContent());
			System.out.println("RATIO : " + eElement.getElementsByTagName("RATIO").item(0).getTextContent());
			System.out.println("RATE : " + eElement.getElementsByTagName("RATE").item(0).getTextContent());
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
}