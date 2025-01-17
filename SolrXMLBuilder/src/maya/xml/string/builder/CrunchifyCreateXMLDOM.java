package maya.xml.string.builder;

import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
 
/**
 * @author Crunchify.com
 */
 
public class CrunchifyCreateXMLDOM {
 
    public static void main(String[] args) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("add");
            doc.appendChild(mainRootElement);
            
            // append child elements to root element
            mainRootElement.appendChild(getDoc(doc, "FSP940101-001", "940101", 
            		"Os quenianos dominaram a corrida de S�o Silvestre ontem. Simon Chemwoyo, 25, venceu a prova masculina pelo segundo ano consecutivo, num final confuso. Outros dois quenianos chegaram em terceiro e sexto lugares. A tamb�m queniana Hellen Kimaiyo, 25, venceu a prova feminina, disputada mais cedo. Fita Bayesa, 22, da Eti�pia, liderava os �ltimos metros perseguido de perto por Chemwoyo. Na chegada, seguiram as motos dos batedores e entraram pelo corredor exclusivo para os ve�culos que acompanhavam a prova. Chemwoyo foi mais r�pido ao voltar para o corredor de chegada e completou a prova com o tempo de 43min20. Chemwoyo, Bayesa e William Sigei (3.�) se revezaram na lideran�a o tempo todo. O mexicano Arturo Barrios, vencedor da prova em 90 e 91, chegou em quarto lugar. O brasileiro melhor colocado foi Ronaldo Costa, na s�timo posi��o. No feminino a brasileira Carmem Oliveira chegou a cinco segundos da vencedora. A portuguesa Albertina Dias foi a terceira. P�g. 5-1"));
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
 
            System.out.println("\nXML DOM Created Successfully..");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static Node getDoc(Document doc, String id, String date, String text) {
    	Element docElem = doc.createElement("doc");
        docElem.appendChild(getFieldElement(doc, "id", id));
        docElem.appendChild(getFieldElement(doc, "date", date));
        docElem.appendChild(getFieldElement(doc, "text", text));
        return docElem;
    }
 
    // utility method to create text node
    private static Node getFieldElement(Document doc, String atribute, String value) {
        Element field = doc.createElement("field");
        field.setAttribute("name", atribute);
        field.setTextContent(value);
        return field;
    }
}