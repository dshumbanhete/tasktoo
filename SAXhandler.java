import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.JSONObject;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

class SAXHandler extends DefaultHandler {
    private String[] fields;
    private JSONObject currentRecord;
    private String currentElement;
    private StringBuilder elementValue;

    public SAXHandler(String[] fields) {
        this.fields = fields;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("record")) {
            currentRecord = new JSONObject();
        }
        for (String field : fields) {
            if (qName.equalsIgnoreCase(field.trim())) {
                currentElement = qName;
                elementValue = new StringBuilder();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement != null && qName.equalsIgnoreCase(currentElement)) {
            currentRecord.put(currentElement, elementValue.toString());
            currentElement = null;
        }
        if (qName.equalsIgnoreCase("record")) {
            System.out.println(currentRecord.toString(4));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            elementValue.append(ch, start, length);
        }
    }
}