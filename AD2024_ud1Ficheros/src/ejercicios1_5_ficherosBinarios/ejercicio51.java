package ejercicios1_5_ficherosBinarios;

import java.io.FileInputStream;
import java.io.IOException;

public class ejercicio51 {
    public static void main(String[] args) throws IOException {
        FileInputStream fInput = new FileInputStream("ejemplo0.dat");

        int b;
        while((b = fInput.read())!=-1){
            System.out.print(b+" ");
        }

        fInput.close();
    }
}
