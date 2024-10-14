package ejercicios1_2_FileReader_Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio2_4 {
    public static void main(String[] args) throws IOException {
        // Creo archivo
        FileWriter archivo = new FileWriter("frases.txt");

        // Pido frases a usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe frases para grabar:");
        // Leo frase de usuario
        String fraseUsuario = sc.nextLine();

        while(!fraseUsuario.equalsIgnoreCase("fin")){
            // Guardo frase en archivo
            archivo.write(fraseUsuario+"\n");
            // Leo demas frases de usuario
            fraseUsuario = sc.nextLine();
        }

        // cierro archivo
        archivo.close();

        // Muestro archivo
        System.out.println("Muestro archivo:");
        FileReader archivoLectura = new FileReader("frases.txt");

        int letra;
        while((letra = archivoLectura.read())!=-1){
            System.out.print((char)letra);
        }

        archivoLectura.close();
    }
}
