package xmlPersonas;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        // 1. Creo un arrayList donde guardar ppersonas
        ArrayList<Persona> personas = new ArrayList<>();

        //2. Leo el XML y voy añadiendo personas
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("personas.xml"));

        // Selecciona la lista de nodos hijos <persona>
        NodeList listaPersona = doc.getElementsByTagName("persona");

        // recorro todos los nodos encontrados
        for (int i=0; i<listaPersona.getLength(); i++){
           // Casteo el nodo en un elemento
           Node unNodoHijo = listaPersona.item(i);
           Element e = (Element) unNodoHijo;

           //Extraigo la información del elemento
           String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
           int edad = Integer.parseInt(e.getElementsByTagName("edad").item(0).getTextContent());

           // Añado al arrayList
           personas.add(new Persona(nombre, edad));
        }

        // 3. Modificar algo del arrayList
        for(Persona p: personas){
            if(p.getNombre().equals("Ana")){
                personas.get(personas.indexOf(p)).setEdad(35);
            }
        }

        // Muestro como queda el array
        personas.forEach(System.out::println);

        //4. Guardo el resultado en el XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document docEscritura = db.newDocument();

        Element raiz = docEscritura.createElement("personas");
        docEscritura.appendChild(raiz);

        // Recorro todo el arrayList
        for(Persona p: personas) {
            Element persona = docEscritura.createElement("persona");
            Element nombre = docEscritura.createElement("nombre");
            Element edad = docEscritura.createElement("edad");

            nombre.setTextContent(p.getNombre());
            edad.setTextContent(String.valueOf(p.getEdad()));

            persona.appendChild(nombre);
            persona.appendChild(edad);

            raiz.appendChild(persona);
        }


        // Creo y genero el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(docEscritura);
        StreamResult result = new StreamResult(new File("personas2.xml"));
        transformer.transform(source, result);


    }



}
