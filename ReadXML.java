import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.JSONObject;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;



public class ReadXML {
    public static void main(String[] args) {
        try {
            // Setup scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Get user input for fields
            System.out.println("Enter the fields to display (comma-separated, e.g., name,postalZip): ");
            String input = scanner.nextLine();
            String[] fields = input.split(",");
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document document = builder.parse("data.xml");

            // Get the list of record nodes
            NodeList nodeList = document.getElementsByTagName("record");

            // Loop through each record node
            // Print out user-selected field values
            for (String field : fields) {
                field = field.trim();
                if (field.equalsIgnoreCase("name")||field.equalsIgnoreCase("postalZip")||field.equalsIgnoreCase("region")||field.equalsIgnoreCase("country")||field.equalsIgnoreCase("address")||field.equalsIgnoreCase("list")){
                   // for (int i = 0; i < nodeList.getLength(); i++) {
                     //   Node node = nodeList.item(i);

           // if (node.getNodeType() == Node.ELEMENT_NODE) {
                //    Element element = (Element) node;
                 //   JSONObject json = new JSONObject();

                   
                       // json.put(field, element.getElementsByTagName(field).item(0).getTextContent());
                        // Print JSON object
                      //  System.out.println(json.toString(4));
                      // Create a SAX XMLReader
            // Create a SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler(fields);

            // Parse the XML file
            saxParser.parse("data.xml", handler);
                    }else{
                        System.out.println("Invalid Field");
                    }
                    
                    //previous non-JSON code
                    //System.out.println(field.substring(0, 1).toUpperCase() + field.substring(1) + ": " +
                            //element.getElementsByTagName(field).item(0).getTextContent());
                }
                scanner.close();
                }
            
            
         catch (Exception e) {
            e.printStackTrace();
        }
    }
}
