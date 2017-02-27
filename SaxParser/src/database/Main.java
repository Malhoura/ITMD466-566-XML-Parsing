/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Mazen
 */
public class Main {
    
    public static void main(String[] args) throws Exception{
        //createTable();
        XMLToMySQL();
    }
    
    public static void createTable(){
        try{
            
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS testtable(id int NOT NULL AUTO_INCREMENT,"
                    + "first varchar(255), last varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
            
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Table Created");
        }
    }
    
//    public static void insertIntoDB(){
//        
//        try{
//            Connection con = getConnection();
//            PreparedStatement stmt = con
//    .prepareStatement("INSERT INTO testtable(\n" +
//              "id, firstname, lastname\n" +
//                  "VALUES(?, ?, ?)");
//            
//        }catch(Exception e){
//            
//        }finally{
//            System.out.println("Data inserted");
//        }
//    }
    
    public static void XMLToMySQL(){
        try {

	File fXmlFile = new File("xml/test.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        Object res = xpath.evaluate("xml/test",
                 doc,
                 XPathConstants.NODESET);
        
        Connection con = getConnection();
            PreparedStatement stmt = con
    .prepareStatement("INSERT INTO testtable(id, first, last) VALUES(?, ?, ?)");
            
            

	
	doc.getDocumentElement().normalize();

//	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("user");
        
        for (int i = 0 ; i < nList.getLength() ; i++) {
    Node node = nList.item(i);
    List<String> columns = Arrays
    .asList(getAttrValue(node, "id"),
        getTextContent(node, "firstname"),
        getTextContent(node, "lastname"));
    for (int n = 0 ; n < columns.size() ; n++) {
    stmt.setString(n+1, columns.get(n));
    }
    stmt.execute();
}

    } catch (Exception e) {
	e.printStackTrace();
    }
    }
    
    static private String getAttrValue(Node node,String attrName) {
    if ( ! node.hasAttributes() ) return "";
    NamedNodeMap nmap = node.getAttributes();
    if ( nmap == null ) return "";
    Node n = nmap.getNamedItem(attrName);
    if ( n == null ) return "";
    return n.getNodeValue();
}
    
    static private String getTextContent(Node parentNode,String childName) {
    NodeList nlist = parentNode.getChildNodes();
    for (int i = 0 ; i < nlist.getLength() ; i++) {
    Node n = nlist.item(i);
    String name = n.getNodeName();
    if ( name != null && name.equals(childName) )
        return n.getTextContent();
    }
    return "";
}
    
    
    
    public static Connection getConnection() throws Exception{
        
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
            
            return conn;
        }catch(Exception e){
            System.out.println(e);
        }
        
        return null;
    }
}
