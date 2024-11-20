package quitarTabuladores;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Leer el archivo
        File archivo = new File("codigo.txt");
        Scanner sc = new Scanner(archivo);

        // Archivo de escritura
        PrintWriter archivoFinal = new PrintWriter(new FileWriter("codigoFinal.txt", false));

        // Ejemplo de como leer
        while(sc.hasNextLine()){
           String lineaLeida = sc.nextLine();
           lineaLeida = lineaLeida.replace("\t","  ");
           archivoFinal.println(lineaLeida);
        }

        archivoFinal.close(); //cerrar el fichero
    }
}
