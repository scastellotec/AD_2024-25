package com.iespabloserrano;

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, SQLException {
        ArrayList<Producto> productos;

        // Commentar una de las 2 lineas
        //productos = leerCSV("productos.csv");
        productos = leerXML("productos.xml");
        escribirAleatorio("productos.dat", productos);
        escribirBBDD(productos);
    }

    // 1.1 Leer CSV
   private static ArrayList<Producto> leerCSV(String nombreArchivo) throws FileNotFoundException {

       // Colección donde guardaré los productos
       ArrayList<Producto> productos = new ArrayList<>();

       // Recorro el archivo CSV
       File archivo = new File(nombreArchivo);
       Scanner sc = new Scanner(archivo);

        // Ejemplo de como leer
        while(sc.hasNextLine()){
           String lineaLeida = sc.nextLine();
           String[] datosLinea = lineaLeida.split(",");
           productos.add(new Producto(Integer.parseInt(datosLinea[0]), datosLinea[1], Double.parseDouble(datosLinea[2])));
        }

        for (Producto p: productos) {
            System.out.println(p);
        }

        sc.close();

       return productos;
   }

    // 1.2 Leer XML
    private static ArrayList<Producto> leerXML(String nombreArchivo) throws ParserConfigurationException, IOException, SAXException {

        // Colección donde guardaré los productos
        ArrayList<Producto> productos = new ArrayList<>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(nombreArchivo));

        NodeList nList = doc.getElementsByTagName("producto");
        for (int i=0; i<nList.getLength(); i++){
           Node unNodoHijo = nList.item(i);
           Element e = (Element) unNodoHijo;
           int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
           String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
           double precio = Double.parseDouble(e.getElementsByTagName("precio").item(0).getTextContent());
           productos.add(new Producto(id, nombre, precio));
        }

        for (Producto p: productos) {
            System.out.println(p);
        }

        return productos;
    }

    // 1.3 Escribir Aleatorio
    private static void escribirAleatorio(String nombreArchivo, ArrayList<Producto> productos) throws IOException {
        /*
            int id = 4bytes
            String nombre (8 char) = 2*8 = 16 bytes
            Double precio = 8 bytes
            Tamaño total = 4 + 16 + 8 = 28 bytes total
         */
        final int TAMANO_PRODUCTO = 28;

        RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw");

        for(Producto p: productos){
            // Posicionarme para escribir
            raf.seek(p.getId()*TAMANO_PRODUCTO);

            raf.writeInt(p.getId());
            raf.writeChars(p.getNombre());
            raf.writeDouble(p.getPrecio());
        }

        raf.close();
    }

    // 1.4 Escribir en Base de Datos
    private static void escribirBBDD(ArrayList<Producto> productos) throws SQLException { // Faltarian datos conexion

        Connection conexion = null;

        try {
          conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
        } catch (SQLException sqle) {
          sqle.printStackTrace();
        }

        conexion.setAutoCommit(false);

        String sentenciaSql = "INSERT INTO productos (id, nombre, precio) VALUES (?, ?, ?)";

        for(Producto p: productos) {
            PreparedStatement sentencia = null;

            try {
                sentencia = conexion.prepareStatement(sentenciaSql);
                sentencia.setInt(1, p.getId());
                sentencia.setString(2, p.getNombre());
                sentencia.setDouble(3, p.getPrecio());
                sentencia.executeUpdate();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                if (sentencia != null)
                    try {
                        sentencia.close();
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
            }

        }

        conexion.setAutoCommit(true);
        conexion.close();

    }

}