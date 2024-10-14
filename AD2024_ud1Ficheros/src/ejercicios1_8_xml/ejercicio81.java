package ejercicios1_8_xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class ejercicio81 {

    // escribimos un archivo XML utilizando libreria DOM

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        // Genero la colección que quiero volcar en el XML
        ArrayList<Coche> coches = new ArrayList<>();
        // Le doy valores para tener algo de informacion que guardar
        coches.add(new Coche(1,"Tesla"));
        coches.add(new Coche(2,"BMW"));
        coches.add(new Coche(3,"BYD"));
        coches.add(new Coche(4,"Toyota"));
        coches.add(new Coche(5,"Volkswagen"));
        coches.add(new Coche(6,"Peugeot"));
        coches.add(new Coche(7,"Porsche"));
        coches.add(new Coche(8,"Ferrari"));
        coches.add(new Coche(9,"Ford"));
        coches.add(new Coche(10,"Jaguar"));

        // Paso 1: Declaramos los objetos necesarios para crear el documento XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        // Paso 2: Generamos contenido
        //Crear un elemento raiz
        Element raiz = doc.createElement("taller");
        doc.appendChild(raiz);

        // Grabar cada coche del Arraylist => Recorrer el arraylist
        for(Coche c: coches){
            // Creo el elemento coche
            Element coche = doc.createElement("coche");
            // Creo el elemento marca y lo añado a coche
            Element marca = doc.createElement("marca");
            marca.appendChild(doc.createTextNode(c.getMarca()));
            coche.appendChild(marca);
            // Creo el atributo id y lo añado a coche
            Attr attr = doc.createAttribute("id");
            attr.setValue(String.valueOf(c.getId()));
            coche.setAttributeNode(attr);
            // Añado coche al nodo raiz
            raiz.appendChild(coche);
        }

        // Paso 3: Generamos el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("ejercicio81.xml"));
        transformer.transform(source, result);

    }
}
