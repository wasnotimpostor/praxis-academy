import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class kasus {
    public static void main(String[] args) {
        try {
            File inputFile = new File("kasus.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("judul");
            System.out.println();

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Judul Anime : " + eElement.getAttribute("anime"));
                    System.out.println("Tokoh Utama : " + eElement.getElementsByTagName("tokohUtama").item(0).getTextContent());
                    System.out.println("Gender : " + eElement.getElementsByTagName("gender").item(0).getTextContent());
                    System.out.println("Senjata : " + eElement.getElementsByTagName("senjata").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }   
    }
}
