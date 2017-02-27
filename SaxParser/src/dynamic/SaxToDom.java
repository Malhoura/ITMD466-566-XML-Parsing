package dynamic;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class SaxToDom {
    public SaxToDom(XMLReader reader, InputSource input) {
        myReader = reader;
        myInput  = input;
    }

    
    public Document makeDom() throws IOException {
        Document doc = null;
        try {
            // Find the implementation
            File fXmlFile = new File("xml/test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation impl = builder.getDOMImplementation();

            // Create the document
            doc = impl.createDocument(null, null, null);

            // The Handlers and the actual building
            SaxToDomHandler handlers = new SaxToDomHandler(doc);
            myReader.setContentHandler(handlers);
            myReader.setErrorHandler(handlers);
            myReader.parse(myInput);
        }
        // For the catch handlers below, use your usual logging facilities.
        catch (DOMException e) {
            System.err.println(e); 
        }
        catch (ParserConfigurationException e) {
            System.err.println(e); 
        }
        catch (SAXException e) {
            System.err.println(e); 
        }
        catch (IOException e) {
            System.err.println(e); 
        }
        return doc;
    }

    private XMLReader myReader;
    private InputSource myInput;
}


