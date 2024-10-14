package ejercicios1_3_Scanner_PrintWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ejercicio3_1 {
    /* Leer un fichero de texto con PrintWriter */
    public static void main(String[] args) throws IOException {

        // Instanciar PrintWriter
        PrintWriter pw = new PrintWriter(new FileWriter("streams1.txt"));

        // Escribir las frases que deseemos
        pw.println("Esto es otra frase utilizando Prinwriter");
        pw.println("Adios");

        // Cerrar el archivo
        pw.close();

    }
}
