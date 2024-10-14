package ejercicios1_3_Scanner_PrintWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ejercicio3_3 {
    public static void main(String[] args) throws IOException {
        /* Primero escribo el archivo */
        // Instanciar PrintWriter
        PrintWriter pw = new PrintWriter(new FileWriter("streams1.txt"));

        // Escribir las frases que deseemos
        pw.println("Esto es otra frase utilizando Prinwriter");
        pw.println("Adios");

        // Cerrar el archivo
        pw.close();

        /* Segundo leo el archivo */
        // Instanciar scanner
        Scanner sc = new Scanner(new File("streams1.txt"));

        // Leer todas las lineas
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        // Cerrar
        sc.close();
    }
}
