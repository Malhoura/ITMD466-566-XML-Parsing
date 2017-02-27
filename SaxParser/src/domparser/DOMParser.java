/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domparser;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Order;

/**
 *
 * @author Mazen
 */
public class DOMParser {


    public static void main(String [] args) {
        

    try {

	File fXmlFile = new File("xml/order.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("order");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("orderID : " + eElement.getAttribute("id"));
			System.out.println("orderDate : " + eElement.getElementsByTagName("orderDate").item(0).getTextContent());
			System.out.println("customerID : " + eElement.getElementsByTagName("customerID").item(0).getTextContent());
			System.out.println("employeeID : " + eElement.getElementsByTagName("employeeID").item(0).getTextContent());
			System.out.println("truckID : " + eElement.getElementsByTagName("truckID").item(0).getTextContent());
                        System.out.println("isSpecial : " + eElement.getElementsByTagName("isSpecial").item(0).getTextContent());
                        System.out.println("PONumber : " + eElement.getElementsByTagName("PONumber").item(0).getTextContent());
                        System.out.println("orderTotalAmount : " + eElement.getElementsByTagName("orderTotalAmount").item(0).getTextContent());

                        System.out.println("--------------------");
                        
                        NodeList list = eElement.getChildNodes();
                        for(int j = 0; j< list.getLength(); j++){
                            Node n = list.item(j);
                            if(n.getNodeType() == Node.ELEMENT_NODE){
                                Element ele = (Element) n;
                                
                                System.out.println(ele.getTagName() + " " + ele.getTextContent());
                            }
                        }
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
}
