package ejercicios1_4_Buffered;

import java.io.*;

public class ejercicio4_4 {
    public static void main(String[] args) throws IOException {
        // Variables a utilizar
        String nombreArchivoSinCifrar = "private.txt";
        String nombreArchivoCifrado = "public.txt";
        String nombreArchivoDescifrado = "resultado.txt";
        int desplazamiento = 3;

        // Bufferes
        BufferedReader bfreader = new BufferedReader(new FileReader(nombreArchivoSinCifrar));
        BufferedWriter bfwriter = new BufferedWriter(new FileWriter(nombreArchivoCifrado));

        // Ciframos
        int letra;
        while((letra = bfreader.read())!=-1){
            char caracter = (char) letra;
            bfwriter.write(caracter+desplazamiento);
        }

        bfwriter.close();
        bfreader.close();

        // Buferes
        bfreader = new BufferedReader(new FileReader(nombreArchivoCifrado));
        bfwriter = new BufferedWriter(new FileWriter(nombreArchivoDescifrado));

        // Desciframos
        while((letra = bfreader.read())!=-1){
            char caracter = (char) letra;
            bfwriter.write(caracter-desplazamiento);
        }

        bfreader.close();
        bfwriter.close();
    }
}
