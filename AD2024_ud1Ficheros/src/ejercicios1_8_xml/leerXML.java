package ejercicios1_8_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class leerXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // Colección donde guardare cada elemento que encuentre
        ArrayList<Coche> coches = new ArrayList<>();

        // Paso 1: Cargo el archivo
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse("ejercicio81.xml");

        // Paso 2: Busco todos los elementos coche y los ire guardando en la coleccion
        NodeList nList = doc.getElementsByTagName("coche");

        for (int i = 0; i < nList.getLength(); i++) {
            // Recojo el elemento de la lista y lo casteo a Element
            Element e = (Element)nList.item(i);
            // Leo el atributo del elemento
            int id = Integer.parseInt(e.getAttribute("id"));
            // Leo la "primera etiqueta marca que encuentre" y recojo su contenido de texto
            String marca =  e.getElementsByTagName("marca").item(0).getTextContent();
            // Añado los valores a coche
            coches.add(new Coche(id, marca));
        }

        // Al terminar muestro el arrayList
        for (int i = 0; i < coches.size(); i++) {
            System.out.println(coches.get(i).toString());
        }

        for(Coche c: coches){
            System.out.println(c.toString());
        }

        //coches.forEach(c -> System.out.println(c));
        coches.forEach(System.out::println);



    }
}
