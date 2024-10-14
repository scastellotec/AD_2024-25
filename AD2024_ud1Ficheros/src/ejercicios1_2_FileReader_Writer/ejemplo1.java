package ejercicios1_2_FileReader_Writer;

import java.io.FileWriter;
import java.io.IOException;

public class ejemplo1 {

    /*
    Ejemplos para clase: Escribir una frase en un archivo de texto
    (Crear, escribir, cerrar) Revisar el append y el \n
     */
    public static void main(String[] args) {
        try {
            String frase = "\nNos queda menos de una hora de clase";
            String nombreArchivo = "streams1.txt";

            // 1. Abro el archivo
            FileWriter archivo = new FileWriter(nombreArchivo, true);

            // 2. Escribo la frase
            archivo.write(frase);

            //3. Cierro y libero recursos
            archivo.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
