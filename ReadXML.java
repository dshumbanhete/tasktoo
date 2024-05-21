import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.JSONObject;


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
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    JSONObject json = new JSONObject();

                   // Print out user-selected field values
                   for (String field : fields) {
                    field = field.trim();
                   
                        json.put(field, element.getElementsByTagName(field).item(0).getTextContent());

                    // Print JSON object
                    System.out.println(json.toString(4));
                    //previous non-JSON code
                    //System.out.println(field.substring(0, 1).toUpperCase() + field.substring(1) + ": " +
                            //element.getElementsByTagName(field).item(0).getTextContent());
                }
                System.out.println();
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
