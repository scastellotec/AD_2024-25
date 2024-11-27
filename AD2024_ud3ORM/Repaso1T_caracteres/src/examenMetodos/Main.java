package examenMetodos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Coche> misCoches = leerCSV("garaje.csv");

        // Opcional crearse un metodo que los muestre
        for (Coche c : misCoches) {
            System.out.println(c);
        }

        //escribirJDBC(misCoches);
        escribirAleatorio(misCoches);

        leerCocheAleatorio("garage.random", 8);
    }

    public static ArrayList<Coche> leerCSV(String nombreFichero) throws FileNotFoundException {
        ArrayList<Coche> coches = new ArrayList<>();

        // 1. Instanciar el fichero para poder leerlo
        File archivo = new File(nombreFichero);
        Scanner sc = new Scanner(archivo);

        //2. Itero por los resultados
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] datosLinea = linea.split(",");
            //3. Genero coche y lo inserto en el arrayList
            coches.add(new Coche(Integer.parseInt(datosLinea[0]),
                    datosLinea[1],
                    datosLinea[2],
                    Boolean.valueOf(datosLinea[3])));
        }

        return coches;
    }

    public static void escribirJDBC(ArrayList<Coche> coches) {

        //1. Creo la conexion
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sergio",
                    "root", "");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        //2. Inserto los datos
        PreparedStatement sentencia = null;

        try {
            for (Coche c : coches) {
                String sentenciaSql = "INSERT INTO coches (id, marca, matricula, tiene_seguro) VALUES (?,?,?,?)";


                sentencia = conexion.prepareStatement(sentenciaSql);
                sentencia.setInt(1, c.getId());
                sentencia.setString(2, c.getMarca());
                sentencia.setString(3, c.getMatricula());
                sentencia.setBoolean(4, c.isTieneSeguro());
                sentencia.executeUpdate();
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // Cerramos la conexión al terminar
            if (sentencia != null)
                try {
                    sentencia.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
        }
    }

    public static void escribirAleatorio(ArrayList<Coche> coches) throws IOException {
        int cocheByteSize = 4 + 3 * 2 + 7 * 2;

        //1. Instancio archivo
        RandomAccessFile raf = new RandomAccessFile("garage.random", "rw");

        for (Coche c : coches) {
            // Antes de escribir posicionate en el archivo en funcion del ID
            raf.seek(c.getId() * cocheByteSize);
            // Guardo los datos
            raf.writeInt(c.getId());
            raf.writeChars(c.getMarca());
            raf.writeChars(c.getMatricula());
        }

        raf.close();

        //2. Recorro array

        //3. Voy escribiendo los valores

    }

    public static void leerCocheAleatorio(String nombreFichero, int idCoche) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r");

        // Posicionarme en el archivo para leer el ID deseado
        int cocheByteSize = 4 + 3 * 2 + 7 * 2;
        raf.seek(cocheByteSize * idCoche);

        int id = raf.readInt();

        String marca = "";
        for (int i = 0; i < 3; i++) {
            marca += raf.readChar();
        }

        String matricula = "";
        for (int i = 0; i < 7; i++) {
            matricula += raf.readChar();
        }

        Coche nuevoCoche = new Coche(id, marca, matricula, true);
        System.out.println(nuevoCoche);

    }

}
