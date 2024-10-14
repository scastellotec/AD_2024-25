package ejercicios1_1_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio1_3_scanner {
    /*
    1.3 Crea un fichero y determina si se ha creado o si ya existía.

     */
    public static void main(String[] args) throws IOException {
        // Solicito al usuario que escriba el nombre del archivo
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();

        // Creo el archivo y muestro resultado
        File nuevoArchivo = new File("usuarios",nombreArchivo);
        if(nuevoArchivo.createNewFile()){
            System.out.println("Archivo creado");
        }else{
            System.out.println("Error: Archivo ya existente");
        }
    }
}
