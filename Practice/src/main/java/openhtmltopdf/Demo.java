package openhtmltopdf;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Demo {

    public static void main(String[] args) throws Exception {
        //final String htmlString = getHTMLFromXML();
        convertHTMLToPDF();
    }

    public static void convertHTMLToPDF() throws Exception {
        try (OutputStream os = new FileOutputStream("D:\\out.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri("file:///C:/Users/rpaunikar/Desktop/RN-1252/input_5.html");
            /*builder.withHtmlContent("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<h2>An Unordered HTML List</h2>\n" +
                    "\n" +
                    "<ul>\n" +
                    "  <li>Coffee</li>\n" +
                    "  <li>Tea</li>\n" +
                    "  <li>Milk</li>\n" +
                    "</ul>  \n" +
                    "\n" +
                    "<h2>An Ordered HTML List</h2>\n" +
                    "\n" +
                    "<ol>\n" +
                    "  <li>Coffee</li>\n" +
                    "  <li>Tea</li>\n" +
                    "  <li>Milk</li>\n" +
                    "</ol> \n" +
                    "\n" +
                    "</body>\n" +
                    "</html>", null);*/
            builder.toStream(os);
            builder.run();
        }
    }

    public static String getHTMLFromXML() throws Exception{
        File file = new File("D:\\Mintz_GAR_CPIC_PROV_xml_failing_build - Copy.xml");
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList nodes = doc.getElementsByTagName("Screenings");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            NodeList title = element.getElementsByTagName("Text");
            Element line = (Element) title.item(0);
            System.out.println("Text: " + getCharacterDataFromElement(line));
            return getCharacterDataFromElement(line);
        }
        return null;
    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }

    public static void addWatermark() {

    }
}
