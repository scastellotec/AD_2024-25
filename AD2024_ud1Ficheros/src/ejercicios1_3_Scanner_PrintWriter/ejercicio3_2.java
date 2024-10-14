package ejercicios1_3_Scanner_PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ejercicio3_2 {
    /* Leer un archivo con Scanner*/
    public static void main(String[] args) throws FileNotFoundException {
        // Instanciar scanner
        Scanner sc = new Scanner(new File("streams2.txt"));

        // Leer todas las lineas
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        // Cerrar
        sc.close();

    }
}
