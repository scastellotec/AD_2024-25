package ejercicios1_2_FileReader_Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejemplo2 {
    public static void main(String[] args) {
        try {
            // 1. Abro el archivo que deseo leer
            FileReader archivo = new FileReader("streams1.txt");

            // 2. Utilizando read() sigo leyendo
            int letra;
            while((letra=archivo.read()) != -1){
                System.out.print((char)letra);
            }

            //3. Cierro y libero recursos
            archivo.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
