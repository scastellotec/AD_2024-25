package ejercicios1_2_FileReader_Writer;

import java.io.FileWriter;
import java.io.IOException;

public class ejercicio2_3 {
    public static void main(String[] args) throws IOException {

        int numero = 6;
        String frase = "Este es el fichero nombre";
        String nombreFichero = "nombre";

        for(int i=1; i<=numero; i++){
            //Crear archivo
            FileWriter archivo = new FileWriter(nombreFichero+i+".txt");

            // Rellenarlo con información
            archivo.write(frase+i+".txt");

            // Cerrarlo
            archivo.close();
        }
    }
}
