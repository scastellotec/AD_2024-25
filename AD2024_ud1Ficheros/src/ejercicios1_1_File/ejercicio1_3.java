package ejercicios1_1_File;

import java.io.File;
import java.io.IOException;

public class ejercicio1_3 {
    /*
    1.3 Crea un fichero y determina si se ha creado o si ya existía.

     */
    public static void main(String[] args) throws IOException {
        // Creo el archivo y muestro resultado
        File nuevoArchivo = new File("usuarios","ejercicio13.txt");
        if(nuevoArchivo.createNewFile()){
            System.out.println("Archivo creado");
        }else{
            System.out.println("Error: Archivo ya existente");
        }
    }
}
