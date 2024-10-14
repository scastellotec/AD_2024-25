package ejercicios1_2_FileReader_Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2_2 {
    public static void main(String[] args) throws IOException {

        //Inicializdo variables necesarias
        String nombreArchivo = "streams2.txt";
        char vocal = 'a';
        char vocalMayus = 'A';
        int contador = 0;

        //Abro el archivo
        FileReader archivo = new FileReader(nombreArchivo);

        //Leo el archivo en busca de vocales
        int letra;
        while((letra=archivo.read())!=-1){
            if((char)letra==vocal ||  (char)letra==vocalMayus)
                contador++;
        }

        //Cierro archivo
        archivo.close();

        //Muestro resultado
        System.out.println("La vocal ha salido: "+contador);
    }
}
