package ejercicios1_4_Buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio4_2 {
    public static void main(String[] args) throws IOException {
        String nombreArchivo = "streams3.txt";

        BufferedReader bfreader = new BufferedReader(new FileReader(nombreArchivo));

        String linea;
        int contador = 0;
        while((linea = bfreader.readLine())!=null){
            contador += linea.split(" ").length;
        }

        System.out.println("Numero de palabras encontradas: "+contador);
    }
}
