import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document document = builder.parse("data.xml");

            // Get the list of record nodes
            NodeList nodeList = document.getElementsByTagName("record");

            // Loop through each record node
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Print out the field values
                    System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Postal Zip: " + element.getElementsByTagName("postalZip").item(0).getTextContent());
                    System.out.println("Region: " + element.getElementsByTagName("region").item(0).getTextContent());
                    System.out.println("Country: " + element.getElementsByTagName("country").item(0).getTextContent());
                    System.out.println("Address: " + element.getElementsByTagName("address").item(0).getTextContent());
                    System.out.println("List: " + element.getElementsByTagName("list").item(0).getTextContent());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
