package ejercicios1_1_File;

import java.io.File;
import java.io.IOException;

public class ejercicio1_3_parametro {
    /*
    1.3 Crea un fichero y determina si se ha creado o si ya existía.

     */
    public static void main(String[] args) throws IOException {
        //Recojo el nombre del parametro en tiempo de ejecución
        String nombreArchivo = args[0];

        // Creo el archivo y muestro resultado
        File nuevoArchivo = new File(nombreArchivo);
        if(nuevoArchivo.createNewFile()){
            System.out.println("Archivo creado");
        }else{
            System.out.println("Error: Archivo ya existente");
        }
    }
}
