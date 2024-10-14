package ejercicios1_4_Buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ejercicio4_1 {
    public static void main(String[] args) throws IOException {
        String nombreArchivo = "streams3.txt";
        int numLineas = 50;

        BufferedWriter bfwriter = new BufferedWriter(new PrintWriter(nombreArchivo));

        for(int i=1; i<=numLineas; i++){
            bfwriter.write("Esta es la linea "+i);
            bfwriter.newLine();
        }

        bfwriter.flush();
        bfwriter.close();

    }
}
