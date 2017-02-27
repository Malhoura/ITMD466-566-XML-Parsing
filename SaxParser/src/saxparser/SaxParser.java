
package saxparser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.Order;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@SuppressWarnings("unused")
public class SaxParser extends DefaultHandler{

    private List<Order> data;
    
    public List<Order> readDataFromXML(String fileName) throws SAXException, IOException, ParserConfigurationException{
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        parser.parse(new File(fileName), this);
        
        return data;
    }
    
    public void startDocument()throws SAXException{
        System.out.println("Start Document");
    }
    
    public void endDocument()throws SAXException{
        System.out.println("End Document");
    }
    
    public void startElement(String nameSpaceURI, String localName, String qName, Attributes atts)throws SAXException{
        
        System.out.println("Start Element " + qName);
    }
    
    
    public void endElement(String nameSpaceURI, String localName, String qName)throws SAXException{
        System.out.println("End Element " + qName);
    }
    
    public void characters(char[] ch, int start, int length)throws SAXException{
        for(int i = start; i < (start + length); i++){
            System.out.print(ch[i]);
        } 
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
