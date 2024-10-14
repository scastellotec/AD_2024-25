package ejercicios1_2_FileReader_Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2_1 {
    /*
    Crea un fichero de texto con algún editor de texto
     y después realiza una clase de Java que visualice su contenido.
      El programa recibe el nombre del archivo en tiempo de ejecución
       por línea de comandos.
     */
    public static void main(String[] args) throws Exception {

        //Paso 0: Recojo el nombre del archivo como parametro
        String nombreArchivo = args[0];

        //Paso 1: Creo o abro el archivo
        FileReader archivo = new FileReader(nombreArchivo);

        //Paso 2: Leo el contenido del archivo
        int letra;
        while((letra = archivo.read()) != -1){
            System.out.print((char)letra);
        }

        //Paso3: Cierro el archivo
        archivo.close();
    }
}
