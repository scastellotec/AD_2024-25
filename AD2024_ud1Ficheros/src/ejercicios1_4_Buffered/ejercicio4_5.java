package ejercicios1_4_Buffered;

import java.io.*;

public class ejercicio4_5 {
    public static void main(String[] args) throws IOException {
        // nombres de archivos
        String archivo1 = "archivo1.txt";
        String archivo2 = "archivo2.txt";
        String archivoResultado = "merged.txt";

        BufferedReader bfreader = new BufferedReader(new FileReader(archivo1));
        BufferedWriter bfwriter = new BufferedWriter(new FileWriter(archivoResultado));

        String linea;
        while((linea = bfreader.readLine())!=null){
            bfwriter.write(linea);
            bfwriter.newLine();
        }

        bfreader.close();
        bfreader = new BufferedReader(new FileReader(archivo2));

        while((linea = bfreader.readLine())!=null){
            bfwriter.write(linea);
            bfwriter.newLine();
        }

        bfreader.close();
        bfwriter.close();

    }
}
